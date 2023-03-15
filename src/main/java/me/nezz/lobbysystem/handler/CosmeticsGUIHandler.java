package me.nezz.lobbysystem.handler;

import me.nezz.lobbysystem.LobbySystem;
import me.nezz.lobbysystem.inventories.EffectsGUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CosmeticsGUIHandler implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        event.setCancelled(true);
        if (event.getClickedInventory() == null) return;
        if (!(event.getView().getTitle().equals("Cosmetics"))) return;
        if (clickedItem == null) return;
        String checkName = clickedItem.getItemMeta().getDisplayName();
        if (checkName.contains("§lCOMING SOON")) {
            player.closeInventory();
            player.sendMessage(LobbySystem.prefix + ChatColor.RED + "Feature coming soon");
        }
        else if (checkName.equals(ChatColor.AQUA + "Effects " + ChatColor.GOLD + "§lNEW")) {
            player.openInventory(new EffectsGUI().getInventory());
        }
    }
}
