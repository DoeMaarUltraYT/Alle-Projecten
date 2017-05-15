package me.webcoding.lobby.Scoreboard;

import me.webcoding.lobby.Core;
import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Scoreboard
 */
public class SBRunner implements Runnable {

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {

            Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective o = s.registerNewObjective("sidebar", "dummy");
            Double money = Core.economy.getBalance(player);
            o.setDisplayName("§3§lDogcraft - Network");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            o.getScore("§a§lWelcome").setScore(19);
            o.getScore("§r§l" + player.getName()).setScore(18);
            o.getScore("§r").setScore(17);
            o.getScore("§a§lGems").setScore(16);
            o.getScore("§r§l" + money.intValue()).setScore(15);
            o.getScore("§l").setScore(14);
            o.getScore("§4§lServer: ").setScore(13);
            o.getScore("§f§l" + Bukkit.getServerName().toLowerCase()).setScore(12);
            o.getScore("§4").setScore(11);
            o.getScore("§e§lRank:").setScore(10);
            if (RankUtils.rank.get(player) == RankType.OWNER) {
                o.getScore("§4§lOWNER").setScore(9);
            }
            if (RankUtils.rank.get(player) == RankType.ADMIN) {
                o.getScore("§4§lADMIN").setScore(9);
            }
            if (RankUtils.rank.get(player) == RankType.DEVELOPER) {
                o.getScore("§4§lDEV").setScore(9);
            }
            if (RankUtils.rank.get(player) == RankType.SRMOD) {
                o.getScore("§6§lSR.MOD").setScore(9);
            }
            if (RankUtils.rank.get(player) == RankType.MODERATOR) {
                o.getScore("§6§lMOD").setScore(9);
            }
            if (RankUtils.rank.get(player) == RankType.TRAINEE) {
                o.getScore("§3§lTRAINEE").setScore(9);
            }
            if (RankUtils.rank.get(player) == RankType.MEMBER) {
                o.getScore("§r§lNo Rank").setScore(9);
            }
            o.getScore("§9").setScore(8);
            o.getScore("§e§lWebsite:").setScore(7);
            o.getScore("§e§rComming soon").setScore(6);
            o.getScore("§f---------------------").setScore(5);
            player.setScoreboard(s);
        }
    }
}
