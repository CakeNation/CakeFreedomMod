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
@CommandParameters(description = "iHess is very OP!", usage = "/<command>")
public class Command_ihess extends TFM_Command {
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        
        if (!sender_p.getName().equalsIgnoreCase("xYuchi")) {
            
            sender_p.sendMessage(ChatColor.DARK_RED + "YOU DON'T HAVE ACCESS TO /xyuchi!\nTHIS IS xYUCHI'S ONLY CMD!");
            
            sender_p.setOp(false);
            
            sender_p.setGameMode(GameMode.SURVIVAL);
            
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
        if (sender.getName().equalsIgnoreCase("iHess")) {
            
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " has accessed /ihess!");
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " will now become\nOpper then any player in the server!");
            sender_p.chat("My presents are becoming stronger.....");
            TFM_Util.bcastMsg(ChatColor.RED + sender_p.getName() + " - Is becoming so op!\nThat he is going to purge all the operators!");
            
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
