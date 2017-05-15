package me.webcoding.lobby.Commands;

import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import org.bukkit.command.CommandExecutor;

/**
 * Created by gebruiker on 11-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby
 */
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ACommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (RankUtils.getRank(p) == RankType.MEMBER) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&9Message> &7Err.... Something went wrong"));
                    return true;
                }
                if (args.length > 1 || args.length == 1) {
                    StringBuilder b = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        b.append(" ");
                        b.append(args[i]);
                    }

                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                        //p.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + p.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        if (!(RankUtils.getRank(all) == RankType.MEMBER)) {
                            all.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + p.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        }
                    }
                }
            } else if (!(RankUtils.getRank(p) == RankType.MEMBER)) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9Message> &7This command is for normal Players!"));
                return true;
            }
        }
        return false;
    }
}

