package net.dacommander31.ae.util;

import net.dacommander31.ae.event.SpellCastCallback;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public abstract class SpellBehavior {

    public abstract void executeSpellBehavior(Entity caster, Vec3d offset, ServerWorld world, float areaOfEffect);

    public void cast(Entity caster, SpellBuilder spell) {
        SpellCastCallback.EVENT.invoker().onSpellCast(caster, spell);
    }

    public abstract void setTargets(List<Entity> targets);

    public abstract List<Entity> getTargets();
}
