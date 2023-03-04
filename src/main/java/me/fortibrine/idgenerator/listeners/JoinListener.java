package me.fortibrine.idgenerator.listeners;

import me.fortibrine.idgenerator.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class JoinListener implements Listener {

    private Main plugin;
    public JoinListener() {
        this.plugin = Main.getPlugin();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        List<Player> players = plugin.getPlayers();

        if (!players.contains(null)) {
            players.add(player);
        } else {
            int i = players.indexOf(null);
            players.set(i, player);
        }

        plugin.setPlayers(players);

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        List<Player> players = plugin.getPlayers();

        if (players.contains(player)) {
            players.set(players.indexOf(player), null);
        }

        plugin.setPlayers(players);
    }

}
