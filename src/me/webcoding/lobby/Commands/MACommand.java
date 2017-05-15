package me.webcoding.lobby.Commands;

import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
/**
 * Created by gebruiker on 11-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Commands
 */
public class MACommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (RankUtils.getRank(p) == RankType.MEMBER) {
                p.sendMessage(ChatColor
                        .translateAlternateColorCodes('&',
                                "&9Administration> &7This command is for [&9TRAINEE&7]!"));
                return true;
            }
            if (args.length == 0 || args.length == 1) {
                p.sendMessage(ChatColor
                        .translateAlternateColorCodes(
                                '&',
                                "&9Administration> &7Please enter a player that summitted a &f\"./a\"&7 Report."));
                return true;
            }
            if (args.length > 1 || args.length == 2) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&7The player &3" + args[0] + "&7 is not online!"));
                    return true;
                } else if (target != null) {
                    RankType getRank = RankUtils.getRank(p);
                    if (getRank == RankType.TRAINEE) {
                        StringBuilder b = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            b.append(" ");
                            b.append(args[i]);
                        }
                        target.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.DARK_AQUA + "§lTRAINEE §3" + p.getName().toString() + ChatColor.LIGHT_PURPLE + " " + b);
                        p.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + target.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        return true;
                    }
                    if (getRank == RankType.MODERATOR) {
                        StringBuilder b = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            b.append(" ");
                            b.append(args[i]);
                        }
                        target.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.GOLD + "§lMOD §6" + p.getName().toString() + ChatColor.LIGHT_PURPLE + " " + b);
                        p.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + target.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        return true;
                    }
                    if (getRank == RankType.SRMOD) {
                        StringBuilder b = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            b.append(" ");
                            b.append(args[i]);
                        }
                        target.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.GOLD + "§lSR.MOD §6" + p.getName().toString() + ChatColor.LIGHT_PURPLE + " " + b);
                        p.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + target.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        return true;
                    }
                    if (getRank == RankType.DEVELOPER) {
                        StringBuilder b = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            b.append(" ");
                            b.append(args[i]);
                        }
                        target.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.DARK_RED + "§lDEV §4" + p.getName().toString() + ChatColor.LIGHT_PURPLE + " " + b);
                        p.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + target.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        return true;
                    }
                    if (getRank == RankType.ADMIN) {
                        StringBuilder b = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            b.append(" ");
                            b.append(args[i]);
                        }
                        target.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.DARK_RED + "§lAdmin §4" + p.getName().toString() + ChatColor.LIGHT_PURPLE + " " + b);
                        p.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + target.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        return true;
                    }
                    if (getRank == RankType.OWNER) {
                        StringBuilder b = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            b.append(" ");
                            b.append(args[i]);
                        }
                        target.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.DARK_RED + "§lOwner §4" + p.getName().toString() + ChatColor.LIGHT_PURPLE + " " + b);
                        p.sendMessage(ChatColor.LIGHT_PURPLE + "-> " + ChatColor.WHITE + target.getName().toString() + " " + ChatColor.LIGHT_PURPLE + b);
                        return true;
                    }
                }
            }

        } else {
            sender.sendMessage(ChatColor.DARK_RED
                    + "This command is only for Players");
        }
        return false;
    }

}
