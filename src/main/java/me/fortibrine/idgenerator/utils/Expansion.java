package me.fortibrine.idgenerator.utils;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.fortibrine.idgenerator.Main;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class Expansion extends PlaceholderExpansion {

    private Main plugin;
    public Expansion() {
        plugin = Main.getPlugin();
    }

    @Override
    public String getIdentifier() {
        return "idgenerator";
    }

    @Override
    public String getAuthor() {
        return "IJustFortiLive";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {

        if (params.equalsIgnoreCase("id")) {
            FileConfiguration config = plugin.getConfig();

            List<Player> players = plugin.getPlayers();

            Player onlinePlayer = (Player) player;

            int id = players.indexOf(player);
            id += config.getInt("command.start");

            String message = String.valueOf(id);

            return message;
        }

        return null;
    }
}
