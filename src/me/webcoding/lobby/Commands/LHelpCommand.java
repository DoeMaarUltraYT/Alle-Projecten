package me.webcoding.lobby.Commands;

import org.bukkit.Achievement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: ${PACKAGE_NAME}
 */
public class LHelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (strings.length == 0 || strings[0].equalsIgnoreCase("1")) {
                return true;
            }
            if (strings.length == 1 && strings[0].equalsIgnoreCase("2")) {
                p.sendMessage("Nope");
                return true;
            }
        } else {
            commandSender.sendMessage("§9Console> §7You must use \"?\"");
        }
        return true;
    }
}
