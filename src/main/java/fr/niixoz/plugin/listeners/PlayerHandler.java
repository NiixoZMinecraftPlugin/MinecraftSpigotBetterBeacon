package fr.niixoz.plugin.listeners;

import fr.niixoz.plugin.managers.BeaconData;
import fr.niixoz.plugin.managers.Beacons;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlayerHandler implements Listener {

    @EventHandler
    public void onPlayerPlaceBeacon(BlockPlaceEvent e) {
        if(e.getBlock().getType() == Material.BEACON) {
            Location location = e.getBlock().getLocation();
            String playerUUID = e.getPlayer().getUniqueId().toString();
            String datePlaced = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Beacon beacon = (Beacon)e.getBlock();
            int level = beacon.getTier();

            BeaconData beaconData = new BeaconData(location, playerUUID, datePlaced, level);
            Beacons.addBeacon(beaconData);
            System.out.println("Add beacon at location: " + location.toString() + " with level: " + level);
        }
    }

    @EventHandler
    public void onPlayerBreakBeacon(BlockBreakEvent e) {
        if(e.getBlock().getType() == Material.BEACON) {
            BeaconData beacon = Beacons.getBeaconByLocation(e.getBlock().getLocation());
            Beacons.removeBeacon(beacon);
            System.out.println("Remove beacon at location: " + e.getBlock().getLocation().toString());
        }
    }
}
