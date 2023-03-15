package me.nezz.lobbysystem.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EffectsGUI implements InventoryHolder {

    private final Inventory EffectsGUIInventory;

    public EffectsGUI() {
        // creating the actual inventory
        EffectsGUIInventory = Bukkit.createInventory(this,27,"Effects");

        // creating the items
        ItemStack close_item = new ItemStack(Material.BARRIER, 1);
        ItemStack fill_item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemStack glow = new ItemStack(Material.GLOW_INK_SAC, 1);
        ItemStack hearts = new ItemStack(Material.POPPY, 1);
        ItemStack sparks = new ItemStack(Material.NETHER_STAR, 1);
        ItemStack fire_locked = new ItemStack(Material.FIRE_CHARGE,1);

        // creating the item meta (ex. the display name would be set here)
        // closing item
        ItemMeta close_itemMeta = close_item.getItemMeta();
        close_itemMeta.setDisplayName(ChatColor.RED + "Close");
        close_item.setItemMeta(close_itemMeta);

        // filling item
        ItemMeta fill_itemMeta = fill_item.getItemMeta();
        fill_itemMeta.setDisplayName(ChatColor.RESET + "");
        fill_item.setItemMeta(fill_itemMeta);

        // white glow
        ItemMeta glowMeta = glow.getItemMeta();
        glowMeta.setDisplayName(ChatColor.AQUA + "Glow" + ChatColor.DARK_GRAY + " (Unlocked)");
        glow.setItemMeta(glowMeta);

        // hearts particle effect
        ItemMeta heartsMeta = hearts.getItemMeta();
        heartsMeta.setDisplayName(ChatColor.AQUA + "Pure Love" + ChatColor.DARK_GRAY + " (Unlocked)");
        hearts.setItemMeta(heartsMeta);

        // firework spark particle effect
        ItemMeta sparksMeta = sparks.getItemMeta();
        sparksMeta.setDisplayName(ChatColor.AQUA + "Magical Sparks" + ChatColor.DARK_GRAY + " (Unlocked)");
        sparks.setItemMeta(sparksMeta);

        // fire effect
        ItemMeta fire_lockedMeta = fire_locked.getItemMeta();
        fire_lockedMeta.setDisplayName(ChatColor.AQUA + "Fire Storm" + ChatColor.DARK_GRAY + " (Locked)");
        fire_locked.setItemMeta(fire_lockedMeta);

        // setting the items into the inventory
        for (int i = 0; i < 9; i++) {
            EffectsGUIInventory.setItem(i, fill_item);
        }
        for (int i = 18; i < 27; i++) {
            EffectsGUIInventory.setItem(i, fill_item);
        }

        EffectsGUIInventory.setItem(10, fire_locked);
        EffectsGUIInventory.setItem(12, glow);
        EffectsGUIInventory.setItem(14, hearts);
        EffectsGUIInventory.setItem(16, sparks);
    }

    @Override
    public Inventory getInventory() {
        return EffectsGUIInventory;
    }
}
