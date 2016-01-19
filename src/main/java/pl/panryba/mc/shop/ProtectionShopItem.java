package pl.panryba.mc.shop;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ProtectionShopItem extends ShopItem {

    private long seconds;

    public ProtectionShopItem(long seconds, int price, String key, String description) {
        super(key, price, description);
        this.seconds = seconds;
    }

    @Override
    public void process(Player player) {
        pl.panryba.mc.hardcore.PluginApi.getInstance().extendProtection(player, this.seconds);
        player.sendMessage(ChatColor.YELLOW + "Twoja ochrona przed banem zostala przedluzona. Wpisz /ochrona aby zobaczyc szczegoly");
    }

    @Override
    public boolean preProcess(Player player) {
        return true;
    }
}
