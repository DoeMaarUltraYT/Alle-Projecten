package me.webcoding.lobby.Ranks;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class RankUtils {

	public static HashMap<Player, RankType> rank = new HashMap<Player, RankType>();
	public static HashMap<Player, Integer> xp = new HashMap<Player, Integer>();
	
	public static RankType getRank(Player p) {
		return rank.get(p);
	}

	public static void setRank(Player p, RankType r) {
		rank.put(p, r);
	}
}
