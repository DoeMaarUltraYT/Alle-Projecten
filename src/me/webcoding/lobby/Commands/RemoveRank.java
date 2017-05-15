package me.webcoding.lobby.Commands;

import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;

import me.webcoding.lobby.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class RemoveRank implements CommandExecutor {

	private Core plugin;

	public RemoveRank(Core plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getName().equalsIgnoreCase("removerank")) {
			Player p = (Player) sender;
			
			if (RankUtils.getRank(p) == RankType.ADMIN || RankUtils.getRank(p) == RankType.OWNER
					|| RankUtils.getRank(p) == RankType.DEVELOPER) {
				if (args.length == 0) {
					p.sendMessage(ChatColor
							.translateAlternateColorCodes('&',
									"&7Please use &f\"&3/derank <Player>\" &7Thanks&f."));
				} else if (args.length == 1) {
					Player target = Bukkit.getPlayerExact(args[0]);
					if (target == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes(
								'&', "&7The player &3" + args[0]
										+ "&7 is not online!"));
					}
					if (target != null) {
						RankUtils.rank.put(target, RankType.MEMBER);
						plugin.getConfig().set("Ranks." + target.getName().toString(), "member");
						plugin.saveConfig();
						p.sendMessage(ChatColor
								.translateAlternateColorCodes(
										'&',
										"&7The player &3"
												+ target.getName().toString()
												+ "&7 Has been deranked from the staff team"));
						return true;
					}
				}
			} else if (!(RankUtils.getRank(p) == RankType.ADMIN)
					|| !(RankUtils.getRank(p) == RankType.OWNER)
					|| !(RankUtils.getRank(p) == RankType.DEVELOPER)) {

				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						"This command needs the Permisson &7[&3ADMIN+&7]&f."));
				return true;
			}
		}
		return false;
	}

}
