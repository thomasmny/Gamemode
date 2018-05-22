package de.eintosti.gamemode.commands;

import de.eintosti.gamemode.misc.Utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author einTosti
 */
public class GamemodeSurvival implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.getInstance().getString("not_a_player"));
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            GamemodeCommand.getInstance().setPlayerGamemode(player, "gm.survival", GameMode.SURVIVAL, Utils.getInstance().getString("gamemode_survival"));
        } else if (args.length == 1) {
            GamemodeCommand.getInstance().setTargetGamemode(player, args, 0, GameMode.SURVIVAL, Utils.getInstance().getString("gamemode_survival"));
        } else {
            player.sendMessage(Utils.getInstance().getString("gms_usage"));
        }
        return true;
    }
}