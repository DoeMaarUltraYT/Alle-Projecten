package me.webcoding.lobby.Events;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import net.minecraft.server.v1_9_R1.PlayerConnection;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

/**
 * Created by gebruiker on 10-2-2017.
 */
public class Teleport implements Listener{

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        sendActionBar(e.getPlayer(), ChatColor.translateAlternateColorCodes('&', "&9Je kunt Fast-Travel gebruiken door op [f] te klikken!"));
        e.setCancelled(true);
    }
    public static void sendActionBar(Player player, String message){
        PlayerConnection p = ((CraftPlayer) player).getHandle().playerConnection;
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
        p.sendPacket(ppoc);
    }
}
