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

public class GadgetsGUI implements InventoryHolder {

    private final Inventory GadgetsGUIInventory;

    public GadgetsGUI() {
        // creating the actual inventory
        GadgetsGUIInventory = Bukkit.createInventory(this, 45, "Gadgets");

        // creating the items
        ItemStack close_item = new ItemStack(Material.BARRIER, 1);
        ItemStack black_item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemStack back_item = new ItemStack(Material.ARROW, 1);
        ItemStack fly_gadget = new ItemStack(Material.FEATHER, 1);
        ItemStack bonzo = new ItemStack(Material.BLAZE_ROD, 1);

        // creating the item meta (ex. the display name would be set here)
        ItemMeta close_itemMeta = close_item.getItemMeta();
        close_itemMeta.setDisplayName(ChatColor.RED + "Close");

        ItemMeta black_itemMeta = black_item.getItemMeta();
        black_itemMeta.setDisplayName(ChatColor.RESET + "");

        ItemMeta back_itemMeta = back_item.getItemMeta();
        back_itemMeta.setDisplayName(ChatColor.GRAY + "Back");

        ItemMeta fly_gadgetMeta = fly_gadget.getItemMeta();
        fly_gadgetMeta.setDisplayName(ChatColor.GREEN + "Magical Feather" + ChatColor.DARK_GRAY + " (Unlocked)");
        fly_gadgetMeta.addEnchant(Enchantment.LUCK, 1, true);
        fly_gadgetMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> fly_gadgetLore = new ArrayList<String>();
        fly_gadgetLore.add(ChatColor.DARK_GRAY + "Ancient");
        fly_gadgetLore.add("");
        fly_gadgetLore.add(ChatColor.BLUE + "§oThe ancient legends say");
        fly_gadgetLore.add(ChatColor.BLUE + "§oif you hold this feather,");
        fly_gadgetLore.add(ChatColor.BLUE + "§oit gives you the ability");
        fly_gadgetLore.add(ChatColor.BLUE + "§oto fly indefinitely.");
        fly_gadgetMeta.setLore(fly_gadgetLore);

        ItemMeta bonzoMeta = bonzo.getItemMeta();
        bonzoMeta.setDisplayName(ChatColor.GREEN + "Bonzo Staff" + ChatColor.DARK_GRAY + " (Unlocked)");

        ArrayList<String> bonzoLore = new ArrayList<String>();
        bonzoLore.add(ChatColor.DARK_GRAY + "Placehodler");
        bonzoLore.add("");
        bonzoLore.add(ChatColor.BLUE + "§oPlacehodler");
        bonzoLore.add(ChatColor.BLUE + "§oPlacehodler");
        bonzoLore.add(ChatColor.BLUE + "§oPlacehodler");
        bonzoLore.add(ChatColor.BLUE + "§oPlacehodler");
        bonzoMeta.setLore(bonzoLore);


        // setting item meta | 1. lore -> 2. meta
        close_item.setItemMeta(close_itemMeta);
        black_item.setItemMeta(black_itemMeta);
        back_item.setItemMeta(back_itemMeta);
        fly_gadget.setItemMeta(fly_gadgetMeta);
        bonzo.setItemMeta(bonzoMeta);



        // setting the items into the inventory
        for (int i = 0; i < 9; i++) {
            GadgetsGUIInventory.setItem(i, black_item);
        }
        for (int i = 36; i < 45; i++) {
            GadgetsGUIInventory.setItem(i, black_item);
        }

        GadgetsGUIInventory.setItem(19, fly_gadget);
        GadgetsGUIInventory.setItem(21, bonzo);
    }

    @Override
    public Inventory getInventory() {
        return GadgetsGUIInventory;
    }

}
