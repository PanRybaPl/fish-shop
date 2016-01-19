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
public class LevelShopItem extends ShopItem {
    
    private int levels;
    
    public LevelShopItem(int levels, int price, String key, String description)
    {
        super(key, price, description);
        this.levels = levels;
    }

    @Override
    public void process(Player player) {
        int level = player.getLevel();
        int targetLevel = level + this.levels;
        
        player.setLevel(targetLevel);
        player.sendMessage("Zwiekszyles swoj poziom z " + level + " do " + targetLevel);
    }

    @Override
    public boolean preProcess(Player player) {
        return true;
    }
    
}
