/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.panryba.mc.shop.PluginApi;
import pl.panryba.mc.shop.ShopItem;

/**
 *
 * @author PanRyba.pl
 */
public class ShopCommand implements CommandExecutor {
    
    private PluginApi api;    
    
    public ShopCommand(PluginApi api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(!cmnd.getName().equalsIgnoreCase("sklep"))
            return false;
        
        if(!(cs instanceof Player))
            return false;
        
        Player player = (Player)cs;        
        Collection<ShopItem> items = api.getItems();
        
        if(items.isEmpty()) {
            player.sendMessage("Obecnie w sklepie nie ma niczego.");
            return true;
        }
        
        List<String> msgs = new ArrayList<>();
        
        msgs.add(ChatColor.GREEN + "-- Cennik sklepu --");
        
        for(ShopItem item : items) {
            msgs.add(ChatColor.RED + item.getKey() + ChatColor.RESET + " - " + ChatColor.YELLOW + item.getDescription() + " (" + ChatColor.RED + "cena: " + ChatColor.GREEN + item.getPrice()+ " monet" + ChatColor.YELLOW + ")");
        }
        
        msgs.add("");
        msgs.add("Aby dokonac zakupu, uzyj polecenia /kup");
        
        String[] msgsArr = new String[msgs.size()];
        msgs.toArray(msgsArr);
        
        player.sendMessage(msgsArr);
        return true;
    }
    
}
