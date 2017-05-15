package me.webcoding.lobby.Commands;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by gebruiker on 10-2-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DC-Lobby
 * Package: ${PACKAGE_NAME}
 */
public class SAnnounceCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("announce")) {
            if (strings.length == 0) {
                commandSender.sendMessage("§9Announce> §7Err... Something went wrong!");
                return true;
            }
            if (strings.length == 1) {
                sendAnnounce(Bukkit.getServer(), strings[0]);
                return true;
            }
            if (strings.length > 1) {
                StringBuilder b = new StringBuilder();
                for (int i = 0; i < strings.length; i++) {
                    b.append(" ");
                    b.append(strings[i]);

                }
                sendAnnounce(Bukkit.getServer(), b.toString());
                return true;
            }
        }

        return true;
    }
    public void sendAnnounce(Server Bukkit, String message) {
        IChatBaseComponent announce = IChatBaseComponent.ChatSerializer.a("{\"text\":\"Announcement\",\"color\":\"yellow\",\"bold\":true}");
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutTitle TITLE = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, announce, 10, 80 , 10);
        PacketPlayOutTitle SUBTITLE = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, cbc, 10, 80 , 10);

        for (Player all : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(TITLE);
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(SUBTITLE);
        }
    }
}
