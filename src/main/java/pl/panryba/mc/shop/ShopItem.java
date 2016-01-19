/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop;

import org.bukkit.entity.Player;

public abstract class ShopItem {
    
    private String key;
    private int price;
    private String description;
    
    public abstract void process(Player player);
    public abstract boolean preProcess(Player player);
    
    public ShopItem(String key, int price, String description) {
        this.key = key;
        this.price = price;
        this.description = description;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public String getDescription() {
        return this.description;
    }
}
