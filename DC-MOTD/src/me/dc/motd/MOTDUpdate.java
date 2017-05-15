package me.dc.motd;

import net.minecraft.server.v1_9_R1.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.event.server.ServerListPingEvent;

import java.net.Inet4Address;

/**
 * Created by gebruiker on 26-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-MOTD
 * Package: me.dc.motd
 */
public class MOTDUpdate implements Runnable {
    @Override
    public void run() {
        String one =
                "              &3&l╔Dogcraft - Network╗\n              &3&l╚Nice to see you╝".replaceAll("&","§");
        String two =
                "              &3&l╔Dogcraft - Network╗\n      &3&l╚&5Creative&3, &2Skywars&3 and &cmore&3╝".replaceAll("&","§");
        String MOTD = Bukkit.getServer().getMotd();
        if (MOTD != one && MOTD != two) {
            MinecraftServer.getServer().setMotd(one);
        }
        if (MOTD == one)  {
            MinecraftServer.getServer().setMotd(two);
        } else if (MOTD == two) {
            MinecraftServer.getServer().setMotd(one);
        }
    }
}
