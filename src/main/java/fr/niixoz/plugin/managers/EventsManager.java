package fr.niixoz.plugin.managers;

import fr.niixoz.plugin.MainPlugin;
import fr.niixoz.plugin.listeners.PlayerHandler;

public class EventsManager {

    public static void registerEvents() {
        MainPlugin plugin = MainPlugin.getInstance();
        plugin.getServer().getPluginManager().registerEvents(new PlayerHandler(), plugin);
    }

}
