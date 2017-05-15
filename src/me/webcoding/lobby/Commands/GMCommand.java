package me.webcoding.lobby.Commands;

import org.bukkit.command.CommandExecutor;

/**
 * Created by gebruiker on 11-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Commands
 */
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMCommand implements CommandExecutor {

    public boolean onCommand(CommandSender cs, Command cmd, String cmdLabel,
                             String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm")) {
            if (!(cs instanceof Player)) {
                return true;
            } else {
                Player p = (Player) cs;
                if (p.getGameMode() == GameMode.ADVENTURE) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("§7Gamemode: §2Enabled");
                    return true;
                } else if (p.getGameMode() == GameMode.CREATIVE) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage("§7Gamemode: §cDisabled");
                    return true;
                } else if (p.getGameMode() == GameMode.SURVIVAL) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage("§7Gamemode: §cChanged to Circle");
                    return true;
                }
            }


        }
        return true;
    }

}
