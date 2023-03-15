package me.nezz.lobbysystem.util;

import org.bukkit.ChatColor;

public class Painter {

    public static String paint(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
