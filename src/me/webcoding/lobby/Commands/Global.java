package me.webcoding.lobby.Commands;

import me.webcoding.lobby.Core;
import me.webcoding.lobby.Ranks.ChatType;
import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Global implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getName().equalsIgnoreCase("g")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (RankUtils.getRank(p) == RankType.MEMBER) {
					return true;
				} else {
					if (args.length == 0) {
						p.sendMessage("§fChannel set: §7[§2G§7]");
						Core.chat.put(p, ChatType.GLOBAL);
						return true;
					}
					if (!(args.length == 0)) {
						p.sendMessage("§fChannel set: §7[§2G§7]");
						Core.chat.put(p, ChatType.GLOBAL);
					}
				}
				
			} else {
				return true;
			}
		}
		return false;
	}

}
