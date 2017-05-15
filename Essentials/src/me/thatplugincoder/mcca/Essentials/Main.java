package me.thatplugincoder.mcca.Essentials;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by gebruiker on 28-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: Essentials
 * Package: me.thatplugincoder.mcca.Essentials
 */
public class Main extends JavaPlugin implements Listener {

    public static HashMap<Railroad, String> __rrprefix = new HashMap<>();
    public static HashMap<Player, RailRank> __rrprank = new HashMap<>();
    public static HashMap<Player, Railroad> __rp = new HashMap<>();
    @Override
    public void onEnable() {
        __rrprefix.put(Railroad.OFFICIALCARGO, "§6Official Cargo");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void Join(PlayerJoinEvent e) {
        e.getPlayer().getInventory().addItem(new ItemStack(Material.getMaterial(29343)));
        if (e.getPlayer().getName().equalsIgnoreCase("ThatPluginCoder")) {
            __rrprank.put(e.getPlayer(), RailRank.OWNER);
            __rp.put(e.getPlayer(), Railroad.OFFICIALCARGO);
        }
        if (e.getPlayer().isOp() == true) {
            e.setJoinMessage("§8Join> §4§lOP§7 " + e.getPlayer().getName() + "!");
        } else if (e.getPlayer().isOp() == false) {
            e.setJoinMessage("");
        }
    }


    @EventHandler
    public void Break(BlockBreakEvent e) {
        if (Railroad.getRR(e.getPlayer()) == Railroad.OUTSIDER) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§cYou can't break blocks Because your not in a §6RR");
        }
    }
    @EventHandler
    public void Place(BlockPlaceEvent e) {
        if (Railroad.getRR(e.getPlayer()) == Railroad.OUTSIDER) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§cYou can't place blocks Because your not in a §6RR");
        }
    }
    @EventHandler
    public void Chat(AsyncPlayerChatEvent e) {
        if (Railroad.getRR(e.getPlayer()) == Railroad.OFFICIALCARGO) {
            if (__rrprank.get(e.getPlayer()) == RailRank.WORKER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage("§7[" + __rrprefix.get(Railroad.OFFICIALCARGO) + "§7][§6RR WORKER§7] §f" + e.getPlayer().getName() + " "+ e.getMessage());
                }
            }
            if (__rrprank.get(e.getPlayer()) == RailRank.DRIVER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage("§7[" + __rrprefix.get(Railroad.OFFICIALCARGO) + "§7][§6RR DRIVER§7] §f" + e.getPlayer().getName() + " "+ e.getMessage());
                }
            }
            if (__rrprank.get(e.getPlayer()) == RailRank.MANAGER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage("§7[" + __rrprefix.get(Railroad.OFFICIALCARGO) + "§7][§6RR MANAGER§7] §f" + e.getPlayer().getName() + " "+ e.getMessage());
                }
            }
            if (__rrprank.get(e.getPlayer()) == RailRank.OWNER) {
                e.setCancelled(true);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    all.sendMessage("§7[" + __rrprefix.get(Railroad.OFFICIALCARGO) + "§7][§6RR OWNER§7] §f" + e.getPlayer().getName() + " "+ e.getMessage());
                }
            }
        }
        if (Railroad.getRR(e.getPlayer()) == Railroad.OUTSIDER) {
            e.setCancelled(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.sendMessage("§7[" + __rrprefix.get(Railroad.OUTSIDER) + "§7][§6RR WORKER7] §f" + e.getPlayer().getName() + " "+ e.getMessage());
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gm")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.isOp()) {
                    if (args.length == 0) {
                        p.sendMessage("Invalid");
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("1")) {
                            p.setGameMode(GameMode.CREATIVE);
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("2")) {
                            p.setGameMode(GameMode.ADVENTURE);
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("0")) {
                            p.setGameMode(GameMode.SURVIVAL);
                            return true;
                        }
                    }
                } else if (p.isOp()) {
                    return true;
                }
            } else {
                return true;
            }
        }
        if (command.getName().equalsIgnoreCase("updaterrrank")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
            } else {
                return true;
            }
            return true;
        }
        return true;


    }


}
