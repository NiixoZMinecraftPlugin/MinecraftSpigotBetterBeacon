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
        loadBeacons();
    }

    public static void loadBeacons() {
        beacons.clear();
        if (config.isConfigurationSection("beacons")) {
            for (String key : config.getConfigurationSection("beacons").getKeys(false)) {
                Location loc = config.getLocation("beacons." + key + ".location");
                String playerUUID = config.getString("beacons." + key + ".playerUUID");
                String datePlaced = config.getString("beacons." + key + ".datePlaced");
                int level = config.getInt("beacons." + key + ".level");
                if (loc != null && playerUUID != null && datePlaced != null) {
                    beacons.add(new BeaconData(loc, playerUUID, datePlaced, level));
                }
            }
        }
    }

    public static void saveBeaconsFile() {
        // Efface l'ancienne section "beacons"
        config.set("beacons", null);
        int index = 0;
        for (BeaconData beaconData : beacons) {
            String path = "beacons.beacon" + index;
            config.set(path + ".location", beaconData.getLocation());
            config.set(path + ".playerUUID", beaconData.getPlayerUUID());
            config.set(path + ".datePlaced", beaconData.getDatePlaced());
            config.set(path + ".level", beaconData.getLevel());
            index++;
        }
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addBeacon(BeaconData beacon) {
        beacons.add(beacon);
        saveBeaconsFile();
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
        saveBeaconsFile();
    }

    public static void loopBeacons() {

    }

}
