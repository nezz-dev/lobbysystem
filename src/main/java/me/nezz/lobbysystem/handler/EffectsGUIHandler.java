package me.nezz.lobbysystem.handler;

import me.nezz.lobbysystem.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class EffectsGUIHandler implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        event.setCancelled(true);
        if (event.getClickedInventory() == null) return;
        if (!(event.getView().getTitle().equals("Effects"))) return;
        if (clickedItem == null) return;
        String checkName = clickedItem.getItemMeta().getDisplayName();
        if (checkName.contains(" (Locked)")) {
            player.closeInventory();
            player.sendMessage(LobbySystem.prefix + ChatColor.RED + "You don't have this effect unlocked yet");
        }
        else if (checkName.equals(ChatColor.AQUA + "Fire Storm" + ChatColor.DARK_GRAY + " (Unlocked)")) {
            fireEffect(player);
        }
        else if (checkName.equals(ChatColor.AQUA + "Glow" + ChatColor.DARK_GRAY + " (Unlocked)")) {
            glowEffect(player);
        }
        else if (checkName.equals(ChatColor.AQUA + "Pure Love" + ChatColor.DARK_GRAY + " (Unlocked)")){
            loveEffect(player);
        }
        else if (checkName.equals(ChatColor.AQUA + "Magical Sparks" + ChatColor.DARK_GRAY + " (Unlocked)")) {
            sparkEffect(player);
        }
    }

    private void fireEffect(Player player) {
        player.closeInventory();
        player.sendMessage(LobbySystem.prefix + ChatColor.RED + "Feature coming soon");
    }

    private void glowEffect(Player player) {
        if (player.isGlowing()) {
            player.closeInventory();
            player.setGlowing(false);
            player.sendMessage(LobbySystem.prefix + ChatColor.GREEN + "Removed " + ChatColor.AQUA + "Glow" + ChatColor.GREEN + " effect");
            player.playSound(player.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1.0F, 0.2F);
        }
        else {
            player.sendMessage(LobbySystem.prefix + ChatColor.GREEN + "Applied " + ChatColor.AQUA + "Glow" + ChatColor.GREEN + " effect");
            player.closeInventory();
            player.setGlowing(true);
            player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1.0F, 0.2F);
        }
    }

    private void loveEffect(Player player) {
        player.sendMessage(LobbySystem.prefix + ChatColor.GREEN + "Applied " + ChatColor.AQUA + "Pure Love" + ChatColor.GREEN + " effect");
        player.closeInventory();
        Bukkit.getScheduler().runTaskTimer(LobbySystem.getInstance(), () -> {
            double radius = 1.0;
            double angle = Math.toRadians(Math.random() * 360);
            double x = player.getLocation().getX() + radius * Math.cos(angle);
            double y = player.getLocation().getY() + 1.0;
            double z = player.getLocation().getZ() + radius * Math.sin(angle);

            player.spawnParticle(Particle.HEART, x, y, z, 1, 0, 0.4, 0, 0.01);
        }, 0L, 10L);
    }

    private void sparkEffect(Player player) {
        player.sendMessage(LobbySystem.prefix + ChatColor.GREEN + "Applied " + ChatColor.AQUA + "Magical Sparks" + ChatColor.GREEN + " effect");
        player.closeInventory();
        Bukkit.getScheduler().runTaskTimer(LobbySystem.getInstance(), () -> {
            double radius = 0.8;
            double speed = 8.0; // Set the speed to 8 degrees per tick
            double angle = Math.toRadians((player.getTicksLived() * speed) % 360);
            double x = player.getLocation().getX() + radius * Math.cos(angle);
            double y = player.getLocation().getY() + 0.7;
            double z = player.getLocation().getZ() + radius * Math.sin(angle);
            player.spawnParticle(Particle.FIREWORKS_SPARK, x, y, z, 1, 0, 0, 0, 0.01);
        }, 0L, 1L);
        Bukkit.getScheduler().runTaskTimer(LobbySystem.getInstance(), () -> {
            double radius = 0.8;
            double speed = -8.0; // Set the speed to -8 degrees per tick
            double angle = Math.toRadians((player.getTicksLived() * speed) % 360);
            double x = player.getLocation().getX() + radius * Math.cos(angle);
            double y = player.getLocation().getY() + 0.7;
            double z = player.getLocation().getZ() + radius * Math.sin(angle);
            player.spawnParticle(Particle.FIREWORKS_SPARK, x, y, z, 1, 0, 0, 0, 0.01);
        }, 0L, 1L);
        Bukkit.getScheduler().runTaskTimer(LobbySystem.getInstance(), () -> {
            double radius = 0.8;
            double speed = 8.0; // Set the speed to -8 degrees per tick
            double angle = Math.toRadians((player.getTicksLived() * speed+ 180) % 360);
            double x = player.getLocation().getX() + radius * Math.cos(angle);
            double y = player.getLocation().getY() + 1.7;
            double z = player.getLocation().getZ() + radius * Math.sin(angle);
            player.spawnParticle(Particle.FIREWORKS_SPARK, x, y, z, 1, 0, 0, 0, 0.01);
        }, 0L, 1L);
        Bukkit.getScheduler().runTaskTimer(LobbySystem.getInstance(), () -> {
            double radius = 0.8;
            double speed = -8.0; // Set the speed to -8 degrees per tick
            double angle = Math.toRadians((player.getTicksLived() * speed + 180) % 360);
            double x = player.getLocation().getX() + radius * Math.cos(angle);
            double y = player.getLocation().getY() + 1.7;
            double z = player.getLocation().getZ() + radius * Math.sin(angle);
            player.spawnParticle(Particle.FIREWORKS_SPARK, x, y, z, 1, 0, 0, 0, 0.01);
        }, 0L, 1L);
    }
}
