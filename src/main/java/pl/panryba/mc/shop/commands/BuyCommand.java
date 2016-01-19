/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.panryba.mc.pl.Declination;
import pl.panryba.mc.pl.DeclinationManager;
import pl.panryba.mc.shop.PluginApi;
import pl.panryba.mc.shop.ShopItem;
import pl.panryba.mc.wallet.WalletManager;

/**
 *
 * @author PanRyba.pl
 */
public class BuyCommand implements CommandExecutor {
    
    private PluginApi api;
    
    public BuyCommand(PluginApi api) {
        this.api = api;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(!cmnd.getName().equalsIgnoreCase("kup"))
            return false;
        
        if(!(cs instanceof Player))
            return false;
        
        if(strings.length != 1)
            return false;
        
        Player player = (Player)cs;
        
        ShopItem item = api.getItem(strings[0]);
        if(item == null) {
            player.sendMessage("Sklep czegos takiego nie sprzedaje");
            return true;
        }
        
        if(!item.preProcess(player)) {
            return true;
        }
                
        int price = item.getPrice();
        WalletManager manager = WalletManager.getInstance();
        
        int currentCoins = manager.getPlayerCoins(player);
        
        if(currentCoins < price) {
            Declination single = new Declination("moneta", "monety", "monecie", "monete", "moneta", "monecie", "moneto");
            Declination plural = new Declination("monety", "monet", "monetom", "monety", "monetami", "monetach", "monety");
            
            String requiredStr = DeclinationManager.getInstance().getPossesiveCountDeclination(price, single, plural);
            
            player.sendMessage("Nie posiadasz wystarczajacej liczby monet aby dokonac zakupu. Potrzebujesz " + price + " " + requiredStr + ", a posiadasz tylko " + currentCoins + ".");
            return true;
        }
        
        if(!manager.charge(player, price, item.getDescription())) {
            player.sendMessage("Zakup nie powiodl sie");
            return true;
        }
        
        item.process(player);
        player.sendMessage("[" + ChatColor.RED + "Sklep" + ChatColor.RESET + "] " + ChatColor.YELLOW + "Kupiles " + ChatColor.RED + item.getDescription() + ". " + ChatColor.YELLOW + "Dziekujemy, za dokonanie zakupu!");
        api.broadcastToOther(player, "[" + ChatColor.RED + "Sklep" + ChatColor.RESET + "] " + ChatColor.RED + player.getName() + ChatColor.YELLOW + " kupil " + ChatColor.RED + item.getDescription() + ". " + ChatColor.YELLOW + "Uzyj polecenia /sklep aby zobaczyc przedmioty dostepne w naszym sklepie.");
        return true;
    }
    
}
