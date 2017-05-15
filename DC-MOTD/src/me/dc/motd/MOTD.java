package me.dc.motd;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by gebruiker on 26-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-MOTD
 * Package: me.dc.motd
 */
public class MOTD extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new MOTDUpdate(), 1L, 5 * 20L);
        getLogger().log(Level.SEVERE, "The MOTD Is enabled switching now");
    }

}
