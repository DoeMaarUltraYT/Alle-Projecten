package me.dc.punish;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by gebruiker on 23-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Punish
 * Package: me.dc.punish
 */
public class Punish extends JavaPlugin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().kickPlayer("§cKicked \n §cReason: Being too cool");
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("p")) {
            if (sender.hasPermission("punish.use")) {
                if (args.length == 0) {
                    sender.sendMessage("§9Punish> §7Pleaase use §f\"§7/p <player> <reason> §6Mod§f\"§7 .");
                }
            }
        }
        return true;
    }
}
