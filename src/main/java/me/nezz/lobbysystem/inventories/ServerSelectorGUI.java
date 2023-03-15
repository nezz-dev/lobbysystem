package me.nezz.lobbysystem.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ServerSelectorGUI implements InventoryHolder {
    private final Inventory ServerSelectorGUIInventory;

    public ServerSelectorGUI() {
        // creating the actual inventory
        ServerSelectorGUIInventory = Bukkit.createInventory(this, 45, "Server Selector");

        // creating the item
        ItemStack close_item = new ItemStack(Material.BARRIER, 1);
        ItemStack fill_item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemStack mlgRush_item = new ItemStack(Material.STICK, 1);
        ItemStack creative_item = new ItemStack(Material.GRASS_BLOCK, 1);

        // creating the item meta (ex. the display name would be set here)
        ItemMeta close_itemMeta = close_item.getItemMeta();
        close_itemMeta.setDisplayName(ChatColor.RED + "Close");


        ItemMeta fill_itemMeta = fill_item.getItemMeta();
        fill_itemMeta.setDisplayName(ChatColor.RESET + "");


        ItemMeta mlgRush_itemMeta = mlgRush_item.getItemMeta();
        mlgRush_itemMeta.setDisplayName(ChatColor.AQUA + "MLGRush" + ChatColor.GOLD + ChatColor.BOLD + " NEW UPDATE");
        mlgRush_itemMeta.addEnchant(Enchantment.LUCK, 1, true);
        mlgRush_itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> mlgRush_itemLore = new ArrayList<String>();
        mlgRush_itemLore.add(ChatColor.DARK_GRAY + "Competitive");
        mlgRush_itemLore.add("");
        mlgRush_itemLore.add(ChatColor.GRAY + "Placeholder Desc");
        mlgRush_itemLore.add(ChatColor.GRAY + "Placeholder Desc");
        mlgRush_itemLore.add("");
        mlgRush_itemLore.add(ChatColor.BLUE + "> Click to Connect");


        ItemMeta creative_itemMeta = creative_item.getItemMeta();
        creative_itemMeta.setDisplayName(ChatColor.AQUA + "Bauwelt" + ChatColor.GOLD + ChatColor.BOLD + " RELEASE");
        ArrayList<String> creative_itemLore = new ArrayList<String>();
        creative_itemLore.add(ChatColor.DARK_GRAY + "Creative");
        creative_itemLore.add("");
        creative_itemLore.add(ChatColor.GRAY + "Placeholder Desc");
        creative_itemLore.add(ChatColor.GRAY + "Placeholder Desc");
        creative_itemLore.add("");
        creative_itemLore.add(ChatColor.BLUE + "> Click to Connect");



        // setting item meta | 1. lore -> 2. meta
        close_item.setItemMeta(close_itemMeta);

        fill_item.setItemMeta(fill_itemMeta);

        mlgRush_itemMeta.setLore(mlgRush_itemLore);
        mlgRush_item.setItemMeta(mlgRush_itemMeta);

        creative_itemMeta.setLore(creative_itemLore);
        creative_item.setItemMeta(creative_itemMeta);


        // setting the items into the inventory
        for (int i = 0; i < 9; i++) {
            ServerSelectorGUIInventory.setItem(i, fill_item);
        }
        for (int i = 36; i < 45; i++) {
            ServerSelectorGUIInventory.setItem(i, fill_item);
        }

        ServerSelectorGUIInventory.setItem(22, mlgRush_item);
        ServerSelectorGUIInventory.setItem(24, creative_item);
    }


    @Override
    public Inventory getInventory() {
        return ServerSelectorGUIInventory;
    }
}
