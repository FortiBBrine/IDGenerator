package me.fortibrine.idgenerator.commands;

import me.fortibrine.idgenerator.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class IDCommand implements CommandExecutor {

    private Main plugin;
    public IDCommand() {
        this.plugin = Main.getPlugin();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        FileConfiguration config = plugin.getConfig();

        if (!(sender instanceof Player)) {
            sender.sendMessage(config.getString("command.console_result", "Ваш ID: 0"));
            return true;
        }

        List<Player> players = plugin.getPlayers();
        Player player = (Player) sender;

        String message = config.getString("command.result", "Ваш ID: %id");

        int id = players.indexOf(player);
        id += config.getInt("command.start");

        message = message.replace("%id", String.valueOf(id));

        player.sendMessage(message);
        return true;

    }
}
