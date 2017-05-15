package me.webcoding.lobby.Friends;

import net.minecraft.server.v1_9_R1.IChatBaseComponent;
import net.minecraft.server.v1_9_R1.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;


/**
 * Created by gebruiker on 10-2-2017.
 */
public class FriendCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p=(Player)commandSender;
            if (strings.length == 0) {
                p.sendMessage("§9Friend> §7please enter a name");
                return true;
            }
            if (strings.length == 1) {
                Player target = Bukkit.getServer().getPlayer(strings[0]);
                if (target == null) {
                    p.sendMessage("§9Friend> §7Err... something went wrong");
                }
                if (target != null) {
                    AcceptAndDenyMSG(p, target);
                }
            }
        } else {
            commandSender.sendMessage("§9Console> §7You can't have friend's go cry in a corner");
            return true;
        }
        return true;
    }

    public void AcceptAndDenyMSG(Player p, Player target) {
        String FC = "{\"text\":\"Friend> \",\"color\":\"dark_aqua\"},{\"text\":\"You got a friend request\",\"color\":\"gray\"}";
        IChatBaseComponent FriendChat = IChatBaseComponent.ChatSerializer.a(FC);
        String FC2 = "{\"text\":\"Click \",\"color\":\"gray\"},{\"text\":\"[✘]\",\"color\":\"dark_red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/say Nice\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"Deny the request\"}]}}},{\"text\":\" or \",\"color\":\"gray\"},{\"text\":\"[✔]\",\"color\":\"green\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/say Nice too\"},\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"Accept the request\"}]}}}";
        IChatBaseComponent FriendChat2 = IChatBaseComponent.ChatSerializer.a(FC2);
        PacketPlayOutChat FriendMSG = new PacketPlayOutChat(FriendChat);
        PacketPlayOutChat FriendMSG2 = new PacketPlayOutChat(FriendChat2);
        ((CraftPlayer) target).getHandle().playerConnection.sendPacket(FriendMSG);
        ((CraftPlayer) target).getHandle().playerConnection.sendPacket(FriendMSG2);
    }
}
//
// ✘✔
