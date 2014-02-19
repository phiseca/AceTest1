package io.github.phiseca;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ExampleTask extends BukkitRunnable
{
	private final JavaPlugin plugin;
	
	public ExampleTask(JavaPlugin plugin){
	
		this.plugin=plugin;
	}
	
	
	@Override
	public void run()
	{
		
		plugin.getServer().broadcastMessage("Test");
		
	}
	
	
	
	

}
