package me.webcoding.lobby.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by gebruiker on 19-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: me.webcoding.lobby.Events
 */
public class ServerMOTD implements Listener {

    @EventHandler
    public void onServerPing(ServerListPingEvent e) {
        e.setMotd("§6§lPrivate Test Server.");
    }
}
