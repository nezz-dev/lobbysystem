package me.nezz.lobbysystem;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.nezz.lobbysystem.handler.CosmeticsGUIHandler;
import me.nezz.lobbysystem.handler.EffectsGUIHandler;
import me.nezz.lobbysystem.handler.PlayerInventoryHandler;
import me.nezz.lobbysystem.handler.ServerSelectorGUIHandler;
import me.nezz.lobbysystem.listener.EventCancelListener;
import me.nezz.lobbysystem.listener.JoinListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    private static LobbySystem instance;

    public static LobbySystem getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new EventCancelListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new CosmeticsGUIHandler(), this);
        getServer().getPluginManager().registerEvents(new EffectsGUIHandler(), this);
        getServer().getPluginManager().registerEvents(new PlayerInventoryHandler(), this);
        getServer().getPluginManager().registerEvents(new ServerSelectorGUIHandler(), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    public static void sendPlayerToServer(Player player, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);

        player.sendPluginMessage(LobbySystem.getPlugin(LobbySystem.class), "BungeeCord", out.toByteArray());
    }

    public final static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Stellar" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;
}
