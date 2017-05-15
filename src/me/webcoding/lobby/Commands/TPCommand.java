package me.webcoding.lobby.Commands;

import me.webcoding.lobby.Core;
import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

/**
 * Created by gebruiker on 19-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Commands
 */
public class TPCommand implements CommandExecutor {

    @Override
    @SuppressWarnings("deprecated")
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (RankUtils.getRank(p) == RankType.MEMBER || RankUtils.getRank(p) == RankType.TRAINEE) {
                p.sendMessage(ChatColor
                        .translateAlternateColorCodes('&',
                                "&9Administration> &7This command is for [&9MOD&7]!"));
                return true;
            } else if (!(RankUtils.getRank(p) == RankType.MEMBER) || !(RankUtils.getRank(p) == RankType.TRAINEE)) {
                if (strings.length == 0) {
                    p.sendMessage("§9Teleport> §7Please enter a name!");
                    sendErrorMessage(p);
                    return true;
                }
                if (strings.length == 1) {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null) {
                        p.sendMessage("§9Teleport> §7Trying to locate " + strings[0] + "!");
                        getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new BukkitRunnable() {
                            @Override
                            public void run() {
                                p.sendMessage("§9Teleport> §7Unable to locate " + strings[0] + "!");
                            }
                        }, 2 * 20L);
                        return true;
                    }
                    if (target != null) {
                        p.sendMessage("§9Teleport> §7Teleporting to " + target.getName() + "!");
                        getServer().getScheduler().scheduleSyncDelayedTask(Core.getPlugin(Core.class), new BukkitRunnable() {
                            @Override
                            public void run() {
                                p.sendMessage("§9Teleport> §7Found " + target.getName() + " teleporting now!");
                                p.teleport(target.getLocation());
                            }
                        }, 2 * 20L);
                        return true;
                    }
                }
            }
        }

        return true;
    }

    private static void sendErrorMessage(Player p) {
        p.sendMessage("§7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        p.sendMessage("§c");
        p.sendMessage("§c");
        p.sendMessage("§c         A Fatal error came up");
        p.sendMessage("§c      Please contact an Staffmember");
        p.sendMessage("§c      Or report this on the forums");
        p.sendMessage("§c");
        p.sendMessage("§c");
        p.sendMessage("§7-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");


    }
}
