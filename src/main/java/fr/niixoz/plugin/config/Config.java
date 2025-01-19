package fr.niixoz.plugin.config;

import fr.niixoz.plugin.MainPlugin;

public class Config {

    public static String errorPrefix = "§4[§cBetterBeacon§4] §c";
    public static String errorMessage = "Une erreur est survenue, merci de contacter un administrateur.";


    public static void loadConfig() {
        MainPlugin.getInstance().getLogger().info("Loading config...");

    }

    public static void reload() {
        MainPlugin.getInstance().reloadConfig();
        loadConfig();
    }
}
