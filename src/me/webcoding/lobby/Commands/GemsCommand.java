package me.webcoding.lobby.Commands;

import me.webcoding.lobby.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Commands
 */
public class GemsCommand implements CommandExecutor {

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            return true;
        }
        return true;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0 || strings.length == 1) {
            commandSender.sendMessage("§9Gems> §7Err... something went wrong!");
            return true;
        }
        if (strings.length > 1) {
                OfflinePlayer target = Bukkit.getPlayer(strings[0]);
                        if (isInt(strings[1])) {
                            commandSender.sendMessage("g");
                            Integer money = Integer.parseInt(strings[1]);
                            Double moneyd = money.doubleValue();
                            Core.economy.depositPlayer(target, moneyd);
                        return true;
                    } else if (!isInt(strings[1])){
                            commandSender.sendMessage("§9Gems> §7Err... something went wrong!");
                            return true;
                        }
                    }
                    return true;
            }
        }
