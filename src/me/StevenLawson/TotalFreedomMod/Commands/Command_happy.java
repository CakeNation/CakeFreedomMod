package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "happydude0000 is an OP Builder", usage = "/<command>")
public class Command_happy extends TFM_Command {
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
        if (!sender_p.getName().equalsIgnoreCase("happydude0000")) {
            
            sender_p.sendMessage(ChatColor.DARK_RED + "STOP, YOU CANT BUILD! ONLY happydude0000 CAN DO /happy!");
            
            sender_p.setOp(true);
            
            sender_p.setGameMode(GameMode.CREATIVE);
            
            final Location targetPos = sender_p.getLocation();
            final World world = sender_p.getWorld();
            for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
            
        }
            sender_p.setHealth(0.0);
        }
        if (sender.getName().equalsIgnoreCase("happydude0000")) {
            
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " has accessed /happy!");
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " will now build the best SPAWN ever!");
            sender_p.chat("Just a little diamonds there and.....DONE");
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " just got all building credit to himself!");
            sender_p.chat("Heh you think im done?");
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " Just smited all");
            sender_p.chat("IM THE REAL DEAL HERE");
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " just finished building his last words");
            sender_p.chat("Im done....");
            TFM_Util.bcastMsg(ChatColor.YELLOW + sender_p.getName() + " left the game");
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    for (int i = 0; i <= 100; i++)
                    {
                        player.getWorld().strikeLightning(player.getLocation());
                    }
                }            
              
        for (Player player : server.getOnlinePlayers())
        {
            player.setOp(false);
        }
            sender_p.setOp(true);
            
            
            
            return true;
        
        }
        return true;
    }
}
