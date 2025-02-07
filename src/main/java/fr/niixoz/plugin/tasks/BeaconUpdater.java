package fr.niixoz.plugin.tasks;

import fr.niixoz.plugin.managers.BeaconData;
import fr.niixoz.plugin.managers.Beacons;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class BeaconUpdater implements Runnable {

    private static final int EFFECT_RADIUS = 100;

    @Override
    public void run() {
        for (BeaconData beaconData : Beacons.beacons.toArray(new BeaconData[0])) {
            Location loc = beaconData.getLocation();
            Block block = loc.getBlock();
            if (block.getType() != Material.BEACON) {
                Beacons.removeBeacon(beaconData);
                continue;
            }
            Beacon beaconState = (Beacon) block.getState();
            PotionEffect primaryEffect = beaconState.getPrimaryEffect();
            if (primaryEffect == null) continue;

            // Création d'un effet dont la durée dépasse légèrement l'intervalle de mise à jour (ex. 110 ticks ≈ 5,5 s)
            PotionEffect effectToApply = new PotionEffect(
                    primaryEffect.getType(),
                    (18+2*beaconData.getLevel())*20,
                    primaryEffect.getAmplifier(),
                    false,
                    true,
                    true
            );

            // On parcourt tous les joueurs du monde et on applique l'effet s'ils sont à portée
            for (Player player : loc.getWorld().getPlayers()) {
                if (player.getLocation().distanceSquared(loc) <= EFFECT_RADIUS * EFFECT_RADIUS) {
                    player.addPotionEffect(effectToApply, true);
                }
            }
        }
        Beacons.saveBeaconsFile();
    }
}
