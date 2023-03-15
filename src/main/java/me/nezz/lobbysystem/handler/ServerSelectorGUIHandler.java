package me.nezz.lobbysystem.handler;

import me.nezz.lobbysystem.LobbySystem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class ServerSelectorGUIHandler implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        event.setCancelled(true);
        if (event.getClickedInventory() == null) return;
        if (!(event.getView().getTitle().equals("Server Selector"))) return;
        if (clickedItem == null) return;
        String checkName = clickedItem.getItemMeta().getDisplayName();
        if (checkName.equals(ChatColor.AQUA + "MLGRush" + ChatColor.GOLD + ChatColor.BOLD + " NEW UPDATE")) {
            player.closeInventory();
            player.sendMessage(LobbySystem.prefix + ChatColor.GREEN + "Attempting to send you to MLGRush");
            LobbySystem.sendPlayerToServer(player, "mlgrush");
        }
        else if (checkName.equals(ChatColor.AQUA + "Bauwelt" + ChatColor.GOLD + ChatColor.BOLD + " RELEASE")) {
            player.closeInventory();
            player.sendMessage(LobbySystem.prefix + ChatColor.GREEN + "Attempting to send you to Creative");
            LobbySystem.sendPlayerToServer(player, "creative");
        }
    }
}
