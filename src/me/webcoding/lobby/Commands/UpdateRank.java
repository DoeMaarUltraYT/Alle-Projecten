package me.webcoding.lobby.Commands;

import me.webcoding.lobby.Core;
import me.webcoding.lobby.Ranks.RankType;
import me.webcoding.lobby.Ranks.RankUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class UpdateRank implements CommandExecutor {

	Core plugin;
	public UpdateRank(Core plugin) {
		this.plugin = plugin;
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getName().equalsIgnoreCase("updaterank")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (RankUtils.getRank(p) == RankType.ADMIN
						|| RankUtils.getRank(p) == RankType.OWNER
						|| RankUtils.getRank(p) == RankType.DEVELOPER) {
					if (args.length == 0) {
						p.sendMessage(ChatColor
								.translateAlternateColorCodes('&',
										"&7Please use &f\"&3/updaterank <Player> <Rank>&f\" &7Thanks&f."));
						
						return true;
					}
					if (args.length == 1) {
						p.sendMessage(ChatColor
								.translateAlternateColorCodes('&',
										"&7Please use &f\"&3/updaterank <Player> <Rank>&f\" &7Thanks&f."));
						return true;
					}
					if (args.length == 2) {
						Player target = Bukkit.getPlayerExact(args[0]);
						if (target == null) {
							p.sendMessage(ChatColor
									.translateAlternateColorCodes('&',
											"&7The player &3" + args[0]
													+ "&7 is not online!"));
							return true;
						} else if (target != null) {
							if (args[1].equalsIgnoreCase("owner")) {
								RankUtils.rank.put(target, RankType.OWNER);
								plugin.getConfig().set("Ranks." + target.getName().toString(), "owner");
								plugin.saveConfig();
								p.sendMessage(ChatColor
										.translateAlternateColorCodes(
												'&',
												"&7The player &3"
														+ target.getName()
																.toString()
														+ "&7 Has been added to the rank OWNER"));
								return true;
							}
							if (args[1].equalsIgnoreCase("admin")) {
								RankUtils.rank.put(target, RankType.ADMIN);
								plugin.getConfig().set("Ranks." + target.getName().toString(), "admin");
								plugin.saveConfig();
								p.sendMessage(ChatColor
										.translateAlternateColorCodes(
												'&',
												"&7The player &3"
														+ target.getName()
																.toString()
														+ "&7 Has been added to the rank ADMIN"));
								return true;
							}
							if (args[1].equalsIgnoreCase("dev")
									|| args[1].equalsIgnoreCase("developer")) {
								RankUtils.rank.put(target, RankType.DEVELOPER);
								plugin.getConfig().set("Ranks." + target.getName().toString(), "developer");
								plugin.saveConfig();
								p.sendMessage(ChatColor
										.translateAlternateColorCodes(
												'&',
												"&7The player &3"
														+ target.getName()
																.toString()
														+ "&7 Has been added to the rank DEVELOPER"));
								return true;
							}
							if (args[1].equalsIgnoreCase("srmod")) {
								RankUtils.rank.put(target, RankType.SRMOD);
								plugin.getConfig().set("Ranks." + target.getName().toString(), "srmod");
								plugin.saveConfig();
								p.sendMessage(ChatColor
										.translateAlternateColorCodes(
												'&',
												"&7The player &3"
														+ target.getName()
																.toString()
														+ "&7 Has been added to the rank SR.MOD"));
								return true;
							}
							if (args[1].equalsIgnoreCase("mod")) {
								RankUtils.rank.put(target, RankType.MODERATOR);
								plugin.getConfig().set("Ranks." + target.getName().toString(), "mod");
								plugin.saveConfig();
								p.sendMessage(ChatColor
										.translateAlternateColorCodes(
												'&',
												"&7The player &3"
														+ target.getName()
																.toString()
														+ "&7 Has been added to the rank MOD"));
								return true;
							}
							if (args[1].equalsIgnoreCase("trainee")) {
								RankUtils.rank.put(target, RankType.TRAINEE);
								plugin.getConfig().set("Ranks." + target.getName().toString(), "trainee");
								plugin.saveConfig();
								p.sendMessage(ChatColor
										.translateAlternateColorCodes(
												'&',
												"&7The player &3"
														+ target.getName()
																.toString()
														+ "&7 Has been added to the rank TRAINEE"));
								return true;
							}
						}

					}
				} else if (!(RankUtils.getRank(p) == RankType.ADMIN)
						|| !(RankUtils.getRank(p) == RankType.OWNER || !(RankUtils.getRank(p) == RankType.DEVELOPER))) {
					p.sendMessage(ChatColor
							.translateAlternateColorCodes('&',
									"This command needs the Permisson &7[&3ADMIN+&7]&f."));
					return true;
				}
			} else if (!(sender instanceof Player)){
				
			}
		}
		
		return true;
	}
}


