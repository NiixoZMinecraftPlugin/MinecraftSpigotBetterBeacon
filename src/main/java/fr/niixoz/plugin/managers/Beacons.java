package fr.niixoz.plugin.managers;

import fr.niixoz.plugin.MainPlugin;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Beacons {

    private static File configFile;
    private static FileConfiguration config;
    public static List<BeaconData> beacons = new ArrayList<BeaconData>();

    public static void loadBeaconsFile() {
        MainPlugin plugin = MainPlugin.getInstance();
        configFile = new File(plugin.getDataFolder(), "beacons.yml");
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            plugin.saveResource("beacons.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void loadBeacons() {
        beacons.clear();
    }

    private static void saveConfigFile() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBeacon(BeaconData beacon) {
        beacons.add(beacon);
        //config
        //saveConfigFile();
    }

    public static BeaconData getBeaconByLocation(Location location) {
        for (BeaconData b : beacons) {
            if (b.getLocation().equals(location)) {
                return b;
            }
        }
        return null;
    }

    public static void removeBeacon(BeaconData beacon) {
        beacons.remove(beacon);
        //config
        //saveConfigFile();
    }

    public static void loopBeacons() {

    }

}
