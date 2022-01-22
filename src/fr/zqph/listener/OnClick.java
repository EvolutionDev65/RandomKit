package fr.zqph.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.zqph.Main;

public class OnClick implements org.bukkit.event.Listener {
	
	private Main main;
	
	public OnClick(Main main) {
		this.main = main;
	}

	@EventHandler
	public void ClickOnSakuBag(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();	
		Action action = event.getAction();
		
		Set<String> list = main.getConfig().getConfigurationSection("kits").getKeys(false);
		List<String> targetList = new ArrayList<>(list);
	
		int randomIndex = (int) (Math.random() * targetList.size());
		
		if(player.getItemInHand() != null && player.getItemInHand().getType() == Material.SAKU_BAG && (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)) {
			player.getInventory().removeItem(new ItemStack(Material.SAKU_BAG, 1));
			player.chat("/kit " + targetList.get( randomIndex ));
		}
	}

}
