package me.dc.thatplugincoder.chat;

import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Score;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 * Created by gebruiker on 10-3-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Chat
 * Package: me.dc.thatplugincoder.chat
 */
public class CoreChat extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        System.out.println("Hallo Chat is geactiveerd");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    Scoreboard.setupSB(all);
                }
            }
        }, 0, 20);
        try {

            MySQL.openConnection("sql8.freemysqlhosting.net","sql8165382","sql8165382","4pIWgYC6CL",3306);
            Statement statement = MySQL.connection.createStatement();

            Bukkit.getConsoleSender().sendMessage("-----------------------------");
            Bukkit.getConsoleSender().sendMessage("     -=-=- MySQL -=-=-");
            Bukkit.getConsoleSender().sendMessage("  Connection Established");
            Bukkit.getConsoleSender().sendMessage("-----------------------------");
            Bukkit.getConsoleSender().sendMessage("-=-=- Creating database -=-=-");
            Bukkit.getConsoleSender().sendMessage("-----------------------------");

            try {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `Users`(UserID INTEGER AUTO_INCREMENT PRIMARY KEY, UUID varchar(255),Rank varchar(255), Name varchar(255));");
                Bukkit.getConsoleSender().sendMessage("-=-=- Database created -=-=-");
                Bukkit.getConsoleSender().sendMessage("-----------------------------");
            } catch (SQLException e) {
                getLogger().log(Level.SEVERE, "ERROR                                                                    -=-=-");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Hallo Chat is uitgezet");
        MySQL.closeConnection();

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("Welkom, " + e.getPlayer().getName() + "!");
        if (MySQL.playerExists(e.getPlayer()) == true) {
            return;
        } else if (MySQL.playerExists(e.getPlayer()) == false) {
            MySQL.set(e.getPlayer(), "NOOB");
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String Rank = MySQL.get(e.getPlayer());
        if (Rank.equalsIgnoreCase("OWNER")) {
            e.setCancelled(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.sendMessage("§7[§4§lCEO§7] §9" + e.getPlayer().getName() + " §f" + e.getMessage().replaceAll("&", "§"));
            }
        }
        if (Rank.equalsIgnoreCase("DAV")) {
            e.setCancelled(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.sendMessage("§7[§4§lDEV§7] §9" + e.getPlayer().getName() + " §f" + e.getMessage().replaceAll("&", "§"));
            }
        }
        if (Rank.equalsIgnoreCase("AD")) {
            e.setCancelled(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.sendMessage("§7[§4§lADMIN§7] §9" + e.getPlayer().getName() + " §f" + e.getMessage().replaceAll("&", "§"));
            }
        }
        if (Rank.equalsIgnoreCase("H-B")) {
            e.setCancelled(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.sendMessage("§7[§9§lHead-Builder§7] §9" + e.getPlayer().getName() + " §f" + e.getMessage().replaceAll("&", "§"));
            }
        }
        if (Rank.equalsIgnoreCase("B")) {
            e.setCancelled(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.sendMessage("§7[§9§lBuilder§7] §9" + e.getPlayer().getName() + " §f" + e.getMessage().replaceAll("&", "§"));
            }
        }
        if (Rank.equalsIgnoreCase("NOOB")) {
            e.setCancelled(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.sendMessage("§7[§7§lNormal§7] §9" + e.getPlayer().getName() + " §f" + e.getMessage());
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("lang")) {
            if (sender instanceof ConsoleCommandSender) {

                sender.sendMessage("§cCS can't execute this command");
            } else {
                Player p = (Player) sender;
                TextComponent text = new TextComponent("Run the command \"/lang\"");
                text.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "lang"));
                text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to run").create()));
                p.sendMessage(text.getText());
                None.out.printLn("Fuck off");
            }
        }
        if (command.getName().equalsIgnoreCase("huisblokboem")) {
            Player p = (Player) sender;
            getServer().getWorlds().
        }
        return true;
    }
}
