package me.StevenLawson.TotalFreedomMod.Commands;

import static me.StevenLawson.TotalFreedomMod.Commands.Command_qsmite.smite;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Explode a player", usage = "/<command> <playername>")
public class Command_explode extends TFM_Command {
  
  @Override
  public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
    
        if (!sender.getName().equals("xYuchi")) {
            sender_p.sendMessage(ChatColor.RED + "You shall now explode!\nDon't access this command, please!");
            sender_p.setGameMode(GameMode.SURVIVAL);
            sender_p.setHealth(0);
            smite(sender_p);
            sender_p.getWorld().createExplosion(sender_p.getLocation().getX(), sender_p.getLocation().getY(), sender_p.getLocation().getZ(), 10f, false, false);
        }
        
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TFM_Command.PLAYER_NOT_FOUND);
            return true;
        }
        
        TFM_Util.adminAction(sender_p.getName(), "Exploding " + player.getName() + " to their very death!", true);
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(0);
        smite(player);
        player.getWorld().createExplosion(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 10f, false, false);
        return true;
  }
}
