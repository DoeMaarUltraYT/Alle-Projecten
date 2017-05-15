package me.dc.thatplugincoder.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

/**
 * Created by gebruiker on 16-3-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Chat
 * Package: me.dc.thatplugincoder.chat
 */
public class Scoreboard {
    private CoreChat pl;

    public Scoreboard(CoreChat pl) {
        this.pl =pl;
    }

    public static void setupSB(Player p) {
       ScoreboardManager manager = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard sb = manager.getNewScoreboard();
        Objective objective = sb.registerNewObjective("Scoreboard", "dummy");
        objective.setDisplayName("§6§lDOGCRAFT - NETWORK");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.getScore("§7§lWelcome:").setScore(15);
        objective.getScore("§9§l" + p.getName() + "!").setScore(14);
        objective.getScore("§1").setScore(13);
        objective.getScore("§a§lGems:").setScore(12);
        objective.getScore("§fNone").setScore(11);
        objective.getScore("§2").setScore(10);
        objective.getScore("§9§lOnline:").setScore(9);
        objective.getScore("§9" + Bukkit.getServer().getOnlinePlayers().size()).setScore(8);
        objective.getScore("§3").setScore(7);
        objective.getScore("§9§LServer:").setScore(6);
        objective.getScore("§9" + Bukkit.getServer().getServerName().toString()).setScore(5);
        objective.getScore("§4").setScore(4);
        objective.getScore("§e§lRank:").setScore(2);
        objective.getScore("§7[§4§lCEO§7]").setScore(1);
        p.setScoreboard(sb);
    }
}

