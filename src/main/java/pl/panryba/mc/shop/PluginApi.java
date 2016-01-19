/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PanRyba.pl
 */
public class PluginApi {
    private Map<String, ShopItem> items;
    
    public PluginApi(List<ShopItem> items) {
        this.items = new LinkedHashMap<>();
        for(ShopItem item : items) {
            this.items.put(item.getKey().toUpperCase(), item);
        }
    }
    
    public Collection<ShopItem> getItems() {
        return this.items.values();
    }

    public ShopItem getItem(String key) {
        return this.items.get(key.toUpperCase());
    }

    public void broadcastToOther(Player player, String string) {
        for(Player other : Bukkit.getServer().getOnlinePlayers()) {
            if(other.getName().equals(player.getName())) {
                continue;
            }
            
            other.sendMessage(string);
        }
    }
}
