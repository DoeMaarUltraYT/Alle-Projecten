package me.thatplugincoder.mcca.Essentials;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by gebruiker on 28-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: Essentials
 * Package: me.thatplugincoder.mcca.Essentials
 */
public enum Railroad {
    OFFICIALCARGO, OUTSIDER;

    public static Railroad getRR(Player p) {
        if (Main.__rp.get(p) == Railroad.OFFICIALCARGO) {
            return Railroad.OFFICIALCARGO;
        }
        return Railroad.OUTSIDER;
    }

}
