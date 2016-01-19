/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop;

import org.bukkit.entity.Player;
import pl.panryba.mc.permissions.PermissionsManager;

import java.util.Date;
import java.util.Set;

public class VipShopItem extends ShopItem {
    private String group;
    private int days;
    
    public VipShopItem(String group, int days, int price, String key, String description) {
        super(key, price, description);
        this.days = days;
        this.group = group;
    }
    
    @Override
    public void process(Player player) {
        Date validity = new Date(new Date().getTime() + this.days * 24 * 60 * 60 * 1000);
        PermissionsManager.getInstance().addPlayerToGroup(player.getName(), this.group, validity);

        player.sendMessage("Od teraz posiadasz status " + this.group);
    }
    
    @Override
    public boolean preProcess(Player player) {
        Set<String> groups = PermissionsManager.getInstance().getPlayerGroups(player.getName());
        if(groups.contains(this.group.toLowerCase())) {
            player.sendMessage("Juz posiadasz status " + this.group.toUpperCase() + " wiec nie musisz go kupowac");
            return false;
        }
        
        return true;
    }
}
