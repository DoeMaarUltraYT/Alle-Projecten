package me.webcoding.lobby.Events;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import me.webcoding.lobby.Core;
import me.webcoding.lobby.Ranks.ChatType;
/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Events
 */
public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (Core.chat.get(e.getPlayer()) == ChatType.GLOBAL) {
            if (RankUtils.getRank(e.getPlayer()) == RankType.OWNER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&2[G] &b" + RankUtils.xp.get(e.getPlayer())
                                    + " &4&lOWNER &e"
                                    + e.getPlayer().getName().toString()
                                    + " &f" + e.getMessage()));
                }
            }
            if (RankUtils.getRank(e.getPlayer()) == RankType.ADMIN) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&2[G] &b" + RankUtils.xp.get(e.getPlayer())
                                    + " &4&lADMIN &e"
                                    + e.getPlayer().getName().toString()
                                    + " &f" + e.getMessage()));
                }
            }
            if (RankUtils.getRank(e.getPlayer()) == RankType.DEVELOPER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&2[G] &b" + RankUtils.xp.get(e.getPlayer())
                                    + " &4&lDEV &e"
                                    + e.getPlayer().getName().toString()
                                    + " &f" + e.getMessage()));
                }
            }
            if (RankUtils.getRank(e.getPlayer()) == RankType.SRMOD) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&2[G] &b" + RankUtils.xp.get(e.getPlayer())
                                    + " &6&lSR.MOD &e"
                                    + e.getPlayer().getName().toString()
                                    + " &f" + e.getMessage()));
                }
            }
            if (RankUtils.getRank(e.getPlayer()) == RankType.MODERATOR) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&2[G] &b" + RankUtils.xp.get(e.getPlayer())
                                    + " &6&lMOD &e"
                                    + e.getPlayer().getName().toString()
                                    + " &f" + e.getMessage()));
                }
            }
            if (RankUtils.getRank(e.getPlayer()) == RankType.TRAINEE) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&2[G] &b" + RankUtils.xp.get(e.getPlayer())
                                    + " &3&lTRAINEE &e"
                                    + e.getPlayer().getName().toString()
                                    + " &f" + e.getMessage()));
                }
            }
            if (RankUtils.getRank(e.getPlayer()) == RankType.MEMBER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&2[G] &b" + RankUtils.xp.get(e.getPlayer())
                                    + " &e"
                                    + e.getPlayer().getName().toString()
                                    + " &f" + e.getMessage()));
                }
            }
        }
        if (Core.chat.get(e.getPlayer()) == ChatType.STAFFCHAT) {
            if (RankUtils.getRank(e.getPlayer()) == RankType.OWNER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    if (RankUtils.getRank(all) == RankType.MEMBER) {
                        return;
                    } else if (!(RankUtils.getRank(all) == RankType.MEMBER)) {
                        all.sendMessage(ChatColor.translateAlternateColorCodes(
                                '&', "&4[S] &4&lOWNER &e"
                                        + e.getPlayer().getName().toString()
                                        + " &f" + e.getMessage()));
                    }
                }
            }
            if (RankUtils.getRank(e.getPlayer()) == RankType.ADMIN) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    if (RankUtils.getRank(all) == RankType.MEMBER) {
                        return;
                    } else if (!(RankUtils.getRank(all) == RankType.MEMBER)) {
                        all.sendMessage(ChatColor.translateAlternateColorCodes(
                                '&', "&4[S] &4&lADMIN &e"
                                        + e.getPlayer().getName().toString()
                                        + " &f" + e.getMessage()));
                    }
                }
                if (RankUtils.getRank(e.getPlayer()) == RankType.DEVELOPER) {
                    e.setCancelled(true);
                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                        if (RankUtils.getRank(all) == RankType.MEMBER) {
                            return;
                        } else if (!(RankUtils.getRank(all) == RankType.MEMBER)) {
                            all.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            "&4[S] &4&lDEV &e"
                                                    + e.getPlayer().getName()
                                                    .toString() + " &f"
                                                    + e.getMessage()));
                        }
                    }
                    if (RankUtils.getRank(e.getPlayer()) == RankType.SRMOD) {
                        e.setCancelled(true);
                        for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                            if (RankUtils.getRank(all) == RankType.MEMBER) {
                                return;
                            } else if (!(RankUtils.getRank(all) == RankType.MEMBER)) {
                                all.sendMessage(ChatColor
                                        .translateAlternateColorCodes(
                                                '&',
                                                "&4[S] &6&lSR.MOD &e"
                                                        + e.getPlayer()
                                                        .getName()
                                                        .toString()
                                                        + " &f"
                                                        + e.getMessage()));
                            }
                        }
                        if (RankUtils.getRank(e.getPlayer()) == RankType.MODERATOR) {
                            e.setCancelled(true);
                            for (Player all : Bukkit.getServer()
                                    .getOnlinePlayers()) {
                                if (RankUtils.getRank(all) == RankType.MEMBER) {
                                    return;
                                } else if (!(RankUtils.getRank(all) == RankType.MEMBER)) {
                                    all.sendMessage(ChatColor
                                            .translateAlternateColorCodes(
                                                    '&',
                                                    "&4[S] &6&lMOD &e"
                                                            + e.getPlayer()
                                                            .getName()
                                                            .toString()
                                                            + " &f"
                                                            + e.getMessage()));
                                }
                            }
                            if (RankUtils.getRank(e.getPlayer()) == RankType.TRAINEE) {
                                e.setCancelled(true);
                                for (Player all : Bukkit.getServer()
                                        .getOnlinePlayers()) {
                                    if (RankUtils.getRank(all) == RankType.MEMBER) {
                                        return;
                                    } else if (!(RankUtils.getRank(all) == RankType.MEMBER)) {
                                        all.sendMessage(ChatColor
                                                .translateAlternateColorCodes(
                                                        '&',
                                                        "&4[S] &3&lTRAINEE &e"
                                                                + e.getPlayer()
                                                                .getName()
                                                                .toString()
                                                                + " &f"
                                                                + e.getMessage()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
