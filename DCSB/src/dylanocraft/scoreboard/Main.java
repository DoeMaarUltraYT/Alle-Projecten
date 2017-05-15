package dylanocraft.scoreboard;

/**
 * Created by gebruiker on 11-3-2017.
 * If you steal my code i will porform LEGAL Actions against You
 * Project: DCSB
 * Package: dylanocraft.scoreboard
 */
import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.Server;
        import org.bukkit.entity.Player;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.player.PlayerJoinEvent;
        import org.bukkit.plugin.PluginManager;
        import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
        import org.bukkit.scoreboard.Objective;
        import org.bukkit.scoreboard.Score;
        import org.bukkit.scoreboard.Scoreboard;
        import org.bukkit.scoreboard.ScoreboardManager;
        import ru.tehkode.permissions.PermissionUser;
        import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main
        extends JavaPlugin
        implements Listener
{
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(this, new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    sb(all);
                }
            }
        }, 20L, 20L);
    }

    public String getPlayerRank(Player p)
    {
        PermissionUser user = PermissionsEx.getUser(p.getName());

        String[] groups = user.getGroupNames();
        return groups[0];
    }

    public void sb(Player p)
    {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective obj = scoreboard.registerNewObjective("Board", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        obj.setDisplayName("§b§lDylano§d§lCraft");
        Score one = obj.getScore(" ");
        one.setScore(5);
        Score two = obj.getScore("§7Naam: §6" + p.getDisplayName());
        two.setScore(4);
        Score three = obj.getScore("§7Rank: §6" + getPlayerRank(p));
        three.setScore(3);
        Score four = obj.getScore("§7Online: §6" + Bukkit.getOnlinePlayers().size());
        four.setScore(2);
        Score five = obj.getScore("  ");
        five.setScore(1);
        Score six = obj.getScore("§6DylanoStore.buycraft.net");
        six.setScore(0);
        p.setScoreboard(scoreboard);
    }

    @EventHandler
    public void join(PlayerJoinEvent e)
    {
        sb(e.getPlayer());
    }
}

