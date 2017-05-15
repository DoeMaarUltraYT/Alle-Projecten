package me.webcoding.lobby.Events;

import me.webcoding.lobby.Core;
import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import me.webcoding.lobby.Ranks.ChatType;
/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Events
 */
public class JoinEvent implements Listener{

    private Core plugin;

    public JoinEvent(Core plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPlayedBefore() == false) {
            e.getPlayer().setGameMode(GameMode.ADVENTURE);
            if (e.getPlayer().getName().equalsIgnoreCase("YouDontKnowMe007")) {
                RankUtils.rank.put(e.getPlayer(), RankType.OWNER);

                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7The Coder of this plugin Joined: &3&lWebCoding&7!"));
                Core.chat.put(e.getPlayer(), ChatType.GLOBAL);

                return;
            } else {
                RankUtils.rank.put(e.getPlayer(), RankType.MEMBER);
                plugin.getConfig().set("Ranks." + e.getPlayer(), "member");
                plugin.saveConfig();
                Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                return;
            }
        }
        if (e.getPlayer().hasPlayedBefore() == true) {
            e.getPlayer().setGameMode(GameMode.ADVENTURE);
            if (e.getPlayer().getName().equalsIgnoreCase("YouDontKnowMe007")) {
                RankUtils.rank.put(e.getPlayer(), RankType.OWNER);
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&',
                        "&7The Coder of this plugin Joined: &3&lWebCoding&7!"));
                Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                return;
            } else {
                String name = plugin.getConfig().getString(
                        "Ranks." + e.getPlayer().getName().toString());
                if (name == null) {
                    Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    return;
                } else {
                    if (name.equalsIgnoreCase("member")) {
                        RankUtils.rank.put(e.getPlayer(), RankType.MEMBER);
                        Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    }
                    if (name.equalsIgnoreCase("trainee")) {
                        RankUtils.rank.put(e.getPlayer(), RankType.TRAINEE);
                        Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    }
                    if (name.equalsIgnoreCase("mod")) {
                        RankUtils.rank.put(e.getPlayer(), RankType.MODERATOR);
                        Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    }
                    if (name.equalsIgnoreCase("srmod")) {
                        RankUtils.rank.put(e.getPlayer(), RankType.SRMOD);
                        Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    }
                    if (name.equalsIgnoreCase("developer")) {
                        RankUtils.rank.put(e.getPlayer(), RankType.DEVELOPER);
                        Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    }
                    if (name.equalsIgnoreCase("admin")) {
                        RankUtils.rank.put(e.getPlayer(), RankType.ADMIN);
                        Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    }
                    if (name.equalsIgnoreCase("owner")) {
                        RankUtils.rank.put(e.getPlayer(), RankType.OWNER);
                        Core.chat.put(e.getPlayer(), ChatType.GLOBAL);
                    }
                }
            }
            return;
        }

    }
}
