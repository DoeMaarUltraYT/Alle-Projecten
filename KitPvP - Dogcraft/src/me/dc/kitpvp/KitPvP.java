package me.dc.kitpvp;

import org.bukkit.ChatColor;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by gebruiker on 23-3-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: KitPvP - Dogcraft
 * Package: me.dc.kitpvp
 */
public class KitPvP extends JavaPlugin {

    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage(ChatColor.RED + e.getEntity().getName() + " got rekt by" + e.getEntity().getKiller() + "!");
    }

    public void onSign(SignChangeEvent e) {
        if (e.getLine(1).equalsIgnoreCase("[KitPvP]")) {
            e.setLine(1, "§9[KitPvP]");
        }
        if (e.getLine(2).equals("WASD"))
    }

}
