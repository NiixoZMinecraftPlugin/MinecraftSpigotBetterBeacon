package fr.niixoz.plugin.managers;

import fr.niixoz.plugin.MainPlugin;
import fr.niixoz.plugin.commands.TestCommand;

public class CommandsManager {

    public static void registerCommands() {
        MainPlugin plugin = MainPlugin.getInstance();
        //plugin.getCommand("test").setExecutor(new TestCommand());
    }
}
