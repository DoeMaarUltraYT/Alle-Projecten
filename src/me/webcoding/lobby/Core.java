package me.webcoding.lobby;

import java.util.HashMap;

import me.webcoding.lobby.Commands.*;
import me.webcoding.lobby.Events.ChatEvent;
import me.webcoding.lobby.Events.JoinEvent;
import me.webcoding.lobby.Events.ServerMOTD;
import me.webcoding.lobby.Events.Teleport;
import me.webcoding.lobby.Friends.FriendCommand;
import me.webcoding.lobby.Scoreboard.SBRunner;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;
import java.util.logging.Level;
import org.bukkit.plugin.RegisteredServiceProvider;
import me.webcoding.lobby.Ranks.ChatType;
import org.bukkit.entity.Player;
/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: ${PACKAGE_NAME}
 */
public class Core extends JavaPlugin {
    public static Economy economy = null;
    public static HashMap<Player, ChatType> chat = new HashMap<Player, ChatType>();
    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "The lobby has been activated");
        registerCommand("help",  new LHelpCommand());
        registerCommand("sc",  new StaffChat());
        registerCommand("g",  new Global());
        registerCommand("ip",  new IPConsole());
        registerCommand("f",  new FriendCommand());
        registerCommand("gems",  new GemsCommand());
        registerCommand("announce", new SAnnounceCommand());
        registerCommand("updaterank", new UpdateRank(this));
        registerCommand("removerank",  new RemoveRank(this));
        registerCommand("ma",  new MACommand());
        registerCommand("a",  new ACommand());
        registerCommand("gm",  new GMCommand());
        registerCommand("tp",  new TPCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new Teleport(), Core.getPlugin(Core.class));
        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(this), Core.getPlugin(Core.class));
        Bukkit.getServer().getPluginManager().registerEvents(new ChatEvent(), Core.getPlugin(Core.class));
        Bukkit.getServer().getPluginManager().registerEvents(new ServerMOTD(), Core.getPlugin(Core.class));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this,
                new SBRunner(), 10L, 10L);
        setupEconomy();
    }

    @Override
    public void onDisable() {
       getLogger().log(Level.INFO, "The lobby has been deactivated");
    }
    private void registerCommand(String name, CommandExecutor CMDClass) {
        Core.getPlugin(Core.class).getCommand(name).setExecutor(CMDClass);
    }
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

}
// e.getPlayer().teleport(new Location(Bukkit.getWorld("ProtectThePresident"), -0.5 , 64 , -0.5));
