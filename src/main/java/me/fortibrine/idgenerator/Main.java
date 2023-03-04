package me.fortibrine.idgenerator;

import me.fortibrine.idgenerator.commands.IDCommand;
import me.fortibrine.idgenerator.listeners.JoinListener;
import me.fortibrine.idgenerator.utils.Expansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    private List<Player> players = new ArrayList<>();
    private static Main plugin;

    public static Main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        File config = new File(this.getDataFolder() + File.separator + "config.yml");
        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveDefaultConfig();
        }

        this.getLogger().log(Level.INFO, "Plugin IDGenerator by RP Studio");

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        this.getCommand("id").setExecutor(new IDCommand());

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Expansion().register();
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
