package me.repizestaffchat;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.repizestaffchat.cmd.StaffchatCMD;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
	public static void setInstance(Main instance) {
		Main.instance = instance;
	}
	
	@Override
	public void onEnable() {
		setInstance(this);
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"[REPIZE] Staffchat");
		saveDefaultConfig();
		getCommand("sc").setExecutor(new StaffchatCMD());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new StaffchatCMD(), this);
		
	}
	
	@Override
	public void onDisable() {
		setInstance(null);
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"[REPIZE] Staffchat");
	}
}
