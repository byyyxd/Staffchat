package me.repizestaffchat.cmd;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.repizestaffchat.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffchatCMD implements CommandExecutor, Listener{
	
	public static ArrayList<String> staffchat = new ArrayList<>();
	
	public static Main main;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player) {
			
			if(cmd.getName().equalsIgnoreCase("sc")) {
				Player p = (Player)sender;
				if(p.hasPermission("free.sc")) {
					
					if(!staffchat.contains(p.getName())) {
						staffchat.add(p.getName());
						p.sendMessage(ChatColor.GREEN+"Voce esta no staffchat.");
						return true;
					} else {
						p.sendMessage(ChatColor.RED+"Voce saiu do staffchat.");
						staffchat.remove(p.getName());
						return true;
					}
					
				} else {
					p.sendMessage(ChatColor.RED+"Sem Permissao");
					return true;
				}
			}
			
		} else {
			return true;
		}
		return false;
	}
	
	@EventHandler
	private void staffchat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(staffchat.contains(p.getName())) {
			
			for(Player staffs : Bukkit.getOnlinePlayers()) {
				if(staffs.hasPermission("free.sc")) {
					staffs.sendMessage("§7[§e§lSTAFFCHAT§7] §c" + p.getName() + "§f: §e" + e.getMessage());
					e.setCancelled(true);
				} else {
					return;
				}
			}
			
		} else {
			return;
		}
	}
	
}
