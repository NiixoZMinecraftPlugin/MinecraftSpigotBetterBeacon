package fr.niixoz.plugin;

import fr.niixoz.plugin.config.Config;
import fr.niixoz.plugin.managers.CommandsManager;
import fr.niixoz.plugin.managers.EventsManager;
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
    }

    private void initPlugin() {
        CommandsManager.registerCommands();
        EventsManager.registerEvents();
    }

    public static MainPlugin getInstance() {
        return instance;
    }
}
