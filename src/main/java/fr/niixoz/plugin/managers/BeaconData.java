package fr.niixoz.plugin.managers;

import org.bukkit.Location;

import java.util.Random;
import java.util.UUID;

public class BeaconData {

    private Location location;
    private String playerUUID;
    private String datePlaced;
    private int level;

    public BeaconData(Location location, String playerUUID, String datePlaced, int level) {
        this.location = location;
        this.playerUUID = playerUUID;
        this.datePlaced = datePlaced;
        this.level = level;
    }

    public Location getLocation() {
        return location;
    }

    public String getPlayerUUID() {
        return playerUUID;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
