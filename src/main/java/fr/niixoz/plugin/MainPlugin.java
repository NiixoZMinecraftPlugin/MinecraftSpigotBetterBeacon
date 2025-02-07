package fr.niixoz.plugin;

import fr.niixoz.plugin.config.Config;
import fr.niixoz.plugin.managers.Beacons;
import fr.niixoz.plugin.managers.CommandsManager;
import fr.niixoz.plugin.managers.EventsManager;
import fr.niixoz.plugin.tasks.BeaconUpdater;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainPlugin extends JavaPlugin {

    private static MainPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        Config.loadConfig();
        initPlugin();
    }

    @Override
    public void onDisable() {
        Beacons.saveBeaconsFile();
    }

    private void initPlugin() {
        CommandsManager.registerCommands();
        EventsManager.registerEvents();
        Beacons.loadBeacons();
        getServer().getScheduler().runTaskTimer(this, new BeaconUpdater(), 0L, 200L);
    }

    public static MainPlugin getInstance() {
        return instance;
    }
}
