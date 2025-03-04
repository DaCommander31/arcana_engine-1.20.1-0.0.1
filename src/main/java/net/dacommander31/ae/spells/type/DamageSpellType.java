package net.dacommander31.ae.spells.type;

import net.dacommander31.ae.util.SpellBuilder;
import net.dacommander31.ae.util.SpellType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class DamageSpellType extends SpellType {
    private final float damageAmount;
    private final RegistryKey<DamageType> damageType;

    public DamageSpellType(float damageAmount, RegistryKey<DamageType> damageType) {
        this.damageAmount = damageAmount;
        this.damageType = damageType;
    }
    @Override
    public void applyEffect(Entity caster, Vec3d pos, ServerWorld world, SpellBuilder spellBuilder, Entity target) {
        if (target instanceof LivingEntity entity && entity.canTakeDamage()) {
            DynamicRegistryManager registryManager = world.getRegistryManager();
            RegistryEntry<DamageType> magicDamageEntry = registryManager
                    .get(RegistryKeys.DAMAGE_TYPE)
                    .getEntry(this.damageType)
                    .orElseThrow(() -> new IllegalStateException("DamageType not found."));

            entity.damage(new DamageSource(magicDamageEntry, caster), damageAmount * spellBuilder.getPowerLevel());
        }
    }
}
