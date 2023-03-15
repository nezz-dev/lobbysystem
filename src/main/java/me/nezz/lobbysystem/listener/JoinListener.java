package me.nezz.lobbysystem.listener;

import static me.nezz.lobbysystem.util.Painter.paint;
import me.nezz.lobbysystem.LobbySystem;
import me.nezz.lobbysystem.util.ScoreboardUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener {

    Location hubLocation = new Location(Bukkit.getWorld("world"), 0.5, 100, 0.5, 0, 0);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setScoreboard(ScoreboardUtils.getBaseScoreboard());
        if (player.getGameMode() != GameMode.ADVENTURE) {
            player.setGameMode(GameMode.ADVENTURE);
        }
        if (player.isGlowing()) {
            player.setGlowing(false);
        }
        player.teleport(hubLocation);
        player.getInventory().clear();
        player.getInventory().setItem(0, server_selector);
        player.getInventory().setItem(3, no_gadget);
        player.getInventory().setItem(5, cosmetics);
        player.getInventory().setItem(8, hide);
    }

    private final ItemStack server_selector = new ItemStack(Material.NETHER_STAR, 1);

    {
        ItemMeta server_selectorMeta = server_selector.getItemMeta();
        server_selectorMeta.setDisplayName(paint(LobbySystem.getInstance().getConfig().getString("serverselector_name")));
        server_selector.setItemMeta(server_selectorMeta);
    }

    private final ItemStack no_gadget = new ItemStack(Material.BARRIER, 1);

    {
        ItemMeta no_gadgetMeta = no_gadget.getItemMeta();
        no_gadgetMeta.setDisplayName(paint(LobbySystem.getInstance().getConfig().getString("nogadget_name")));
        no_gadget.setItemMeta(no_gadgetMeta);
    }

    private final ItemStack cosmetics = new ItemStack(Material.CHEST, 1);

    {
        ItemMeta cosmeticsMeta = cosmetics.getItemMeta();
        cosmeticsMeta.setDisplayName(paint(LobbySystem.getInstance().getConfig().getString("cosmetics_name")));
        cosmetics.setItemMeta(cosmeticsMeta);

    }

    private final ItemStack hide = new ItemStack(Material.LIME_DYE, 1);

    {
        ItemMeta hideMeta = hide.getItemMeta();
        hideMeta.setDisplayName(paint(LobbySystem.getInstance().getConfig().getString("hidervisible_name")));
        hide.setItemMeta(hideMeta);

    }
}
