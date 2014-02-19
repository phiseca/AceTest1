package io.github.phiseca;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;



public final class AceTest1 extends JavaPlugin {
	@Override
	public void onEnable()
	{
		new ExampleListener(this);
	
	}
	
	@Override
	public void onDisable(){
		
		
		
	}
	
	
	
	
	
	public boolean onCommand(CommandSender sender, Command cmd,String label,String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("box"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("This command can only be run by a player.");
				
			}
			else
			{
				Player player = (Player) sender;
				Location loc= player.getLocation();
				generateBox(loc);
				
				
			}
			
			return true;
		}
		return false;
		
		
	}



void generateBox(Location loc)
{
	int x= loc.getBlockX();
	int y= loc.getBlockY();
	int z= loc.getBlockZ();
	
	World world = loc.getWorld();
	Block currentBlock;
	
	currentBlock = world.getBlockAt(x+1, y, z);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x+1, y+1, z);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x-1, y, z);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x-1, y+1, z);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x, y, z+1);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x, y+1, z+1);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x, y, z-1);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x, y+1, z-1);
	currentBlock.setTypeId(20);
	currentBlock = world.getBlockAt(x, y+2, z);
	currentBlock.setTypeId(20);
}
}



class ExampleListener implements Listener
{
private final AceTest1 plugin;

public ExampleListener(AceTest1 plugin)
{
	this.plugin=plugin;
	plugin.getServer().getPluginManager().registerEvents(this, plugin);
	

}

@EventHandler
public void onJoin(PlayerJoinEvent event)
{
	
	BukkitTask task = new ExampleTask(this.plugin).runTaskLater(this.plugin,20);
}





}


