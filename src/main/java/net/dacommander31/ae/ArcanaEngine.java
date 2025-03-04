package net.dacommander31.ae;

import net.dacommander31.ae.event.ItemUseEvents;
import net.dacommander31.ae.event.ServerEvents;
import net.dacommander31.ae.event.SpellKeybindEvents;
import net.dacommander31.ae.util.SpellKeybinds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ArcanaEngine implements ModInitializer {
	public static final String MOD_ID = "arcana_engine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SpellKeybinds.registerKeybinds();
		SpellKeybindEvents.registerKeybindEvents();
		ServerEvents.registerServerEvents();
		ItemUseEvents.registerItemUseEvents();
	}
}