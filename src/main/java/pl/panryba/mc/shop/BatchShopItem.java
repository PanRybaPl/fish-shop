/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop;

import org.bukkit.entity.Player;

/**
 *
 * @author PanRyba.pl
 */
public class BatchShopItem extends ShopItem {
    
    private ShopItem[] items;

    public BatchShopItem(ShopItem[] items, String key, int price, String description) {
        super(key, price, description);
        this.items = items;
    }
    
    @Override
    public void process(Player player) {
        for(ShopItem item : this.items) {
            item.process(player);
        }
    }

    @Override
    public boolean preProcess(Player player) {
        for(ShopItem item : this.items) {
            if(!item.preProcess(player)) {
                return false;
            }
        }
        
        return true;
    }
    
}
