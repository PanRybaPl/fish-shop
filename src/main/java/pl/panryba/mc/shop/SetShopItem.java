/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import pl.panryba.mc.sets.api.ItemSet;
import pl.panryba.mc.sets.api.SetsManager;

/**
 *
 * @author PanRyba.pl
 */
public class SetShopItem extends ShopItem {
    private ItemSet set;
    
    public SetShopItem(ItemSet set, String key, int price, String description) {
        super(key, price, description);
        this.set = set;
    }

    @Override
    public void process(Player player) {
        SetsManager.give(this.set, player);
    }

    @Override
    public boolean preProcess(Player player) {
        boolean result = SetsManager.hasEnoughSlots(set, player);
        if(!result) {
            player.sendMessage(ChatColor.YELLOW + "Masz za malo miejsca w plecaku aby to kupic");
        }

        return result;
    }
    
}
