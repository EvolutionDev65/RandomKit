package fr.zqph;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.zqph.listener.OnClick;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		System.out.println("Plugin for Lineria by Zqph_");
		Bukkit.getServer().getPluginManager().registerEvents(new OnClick(this), this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin for Lineria by Zqph_");
	}
}
