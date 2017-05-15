package me.webcoding.lobby.Commands;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Commands
 */

public class IPConsole implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ip")) {
                if (Bukkit.getServer().getIp().equalsIgnoreCase("")) {
                    sender.sendMessage("§aThe server ip is: §clocalhost§a and the port is: §c"
                            + Bukkit.getServer().getPort());
                } else if (Bukkit.getServer().getIp() != null) {
                    sender.sendMessage("§aThe server ip is: §c"
                            + Bukkit.getServer().getIp() + " §aand the port is: §c"
                            + Bukkit.getServer().getPort());
                }
            }
        return false;
        }

    }

