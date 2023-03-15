package me.nezz.lobbysystem.handler;

import static me.nezz.lobbysystem.util.Painter.paint;
import me.nezz.lobbysystem.LobbySystem;
import me.nezz.lobbysystem.inventories.CosmeticsGUI;
import me.nezz.lobbysystem.inventories.ServerSelectorGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInventoryHandler implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        event.setCancelled(true);
        player.setItemOnCursor(null);
        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getType() != InventoryType.PLAYER) return;
        if (clickedItem == null) return;
        String checkName = clickedItem.getItemMeta().getDisplayName();
        if (checkName.equals(paint(LobbySystem.getInstance().getConfig().getString("serverselector_name")))) {
            // player.closeInventory();
            player.openInventory(new ServerSelectorGUI().getInventory());

        } else if (checkName.equals(paint(LobbySystem.getInstance().getConfig().getString("cosmetics_name")))) {
            // player.closeInventory();
            player.openInventory(new CosmeticsGUI().getInventory());

        } else if (checkName.equals(paint(LobbySystem.getInstance().getConfig().getString("hidervisible_name")))) {
            player.closeInventory();
            player.sendMessage(LobbySystem.prefix + ChatColor.RED + "Feature coming soon");
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR)) {
            player.openInventory(new ServerSelectorGUI().getInventory());
        } else if (player.getInventory().getItemInMainHand().getType().equals(Material.BARRIER)) {
            player.sendMessage(LobbySystem.prefix + ChatColor.RED + "Equip a Gadget by clicking the cosmetics menu");

        } else if (player.getInventory().getItemInMainHand().getType().equals(Material.CHEST)) {
            player.openInventory(new CosmeticsGUI().getInventory());

        } else if (player.getInventory().getItemInMainHand().getType().equals(Material.LIME_DYE)) {
            player.sendMessage(LobbySystem.prefix + ChatColor.RED + "Feature coming soon");
        }
    }
}
