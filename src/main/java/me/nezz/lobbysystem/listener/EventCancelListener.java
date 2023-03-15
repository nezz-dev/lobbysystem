package me.nezz.lobbysystem.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class EventCancelListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onItemDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler(ignoreCancelled = true)
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler(ignoreCancelled = true)
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if (location.getY() < 69) {
            // Teleport the player back to spawn
            Location hubLocation = new Location(Bukkit.getWorld("world"), 0.5, 100, 0.5, 0, 0);
            player.teleport(hubLocation);
            player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SCREAM, 1.0F, randomPitch());
        }
    }

    public float randomPitch() {
        Random random = new Random();
        return random.nextFloat() * 2;
    }
}


