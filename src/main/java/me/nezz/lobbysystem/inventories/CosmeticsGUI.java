package me.nezz.lobbysystem.inventories;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class CosmeticsGUI implements InventoryHolder {

    private final Inventory CosmeticsGUIInventory;

    public CosmeticsGUI() {
        // creating the actual inventory
        CosmeticsGUIInventory = Bukkit.createInventory(this, 27, "Cosmetics");

        // creating the items
        ItemStack close_item = new ItemStack(Material.BARRIER, 1);
        ItemStack fill_item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemStack gadgets = new ItemStack(Material.ENDER_CHEST, 1);
        ItemStack outfits = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemStack effects = new ItemStack(Material.LINGERING_POTION, 1);


        // creating the item meta (ex. the display name would be set here)
        // closing item
        ItemMeta close_itemMeta = close_item.getItemMeta();
        close_itemMeta.setDisplayName(ChatColor.RED + "Close");
        close_item.setItemMeta(close_itemMeta);

        // filling item
        ItemMeta fill_itemMeta = fill_item.getItemMeta();
        fill_itemMeta.setDisplayName(ChatColor.RESET + "");
        fill_item.setItemMeta(fill_itemMeta);


        // gadgets menu item
        ItemMeta gadgetsMeta = gadgets.getItemMeta();
        gadgetsMeta.setDisplayName(ChatColor.AQUA + "Gadgets " + ChatColor.RED + "§lCOMING SOON");
        gadgets.setItemMeta(gadgetsMeta);

        // outfits menu item
        ItemMeta outfitsMeta = outfits.getItemMeta();
        outfitsMeta.setDisplayName(ChatColor.AQUA + "Outfits " + ChatColor.RED + "§lCOMING SOON");
        outfits.setItemMeta(outfitsMeta);
        LeatherArmorMeta outfitsMetaColor = (LeatherArmorMeta)outfits.getItemMeta();
        outfitsMetaColor.setColor(Color.fromRGB(255, 255, 255));
        outfits.setItemMeta(outfitsMetaColor);

        // effects menu
        ItemMeta effectsMeta = effects.getItemMeta();
        effectsMeta.setDisplayName(ChatColor.AQUA + "Effects " + ChatColor.GOLD + "§lNEW");
        effects.setItemMeta(effectsMeta);


        // setting the items into the inventory
        for (int i = 0; i < 9; i++) {
            CosmeticsGUIInventory.setItem(i, fill_item);
        }
        for (int i = 18; i < 27; i++) {
            CosmeticsGUIInventory.setItem(i, fill_item);
        }

        CosmeticsGUIInventory.setItem(11, gadgets);
        CosmeticsGUIInventory.setItem(13, outfits);
        CosmeticsGUIInventory.setItem(15, effects);
    }

    @Override
    public Inventory getInventory() {
        return CosmeticsGUIInventory;
    }

}
