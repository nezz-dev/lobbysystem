package me.nezz.lobbysystem.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardUtils {

    public static Scoreboard getBaseScoreboard() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("main", "main", ChatColor.BLUE + "Stellar Network");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Add some scores to the scoreboard

        objective.getScore("§3stellar.ddns.net").setScore(1);
        objective.getScore("   ").setScore(2);
        objective.getScore("Server: §bHub").setScore(3);
        objective.getScore("Stellar Shards: §b254").setScore(4);
        objective.getScore("  ").setScore(5);
        objective.getScore("Rank: §4Admin").setScore(6);
        objective.getScore(" ").setScore(7);
        objective.getScore(ChatColor.STRIKETHROUGH + "                          ").setScore(8);

        return scoreboard;

    }
}
