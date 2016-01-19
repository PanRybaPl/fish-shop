/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import pl.panryba.mc.sets.api.ItemSet;
import pl.panryba.mc.sets.api.ItemSetEnchantment;
import pl.panryba.mc.sets.api.ItemSetPart;
import pl.panryba.mc.shop.commands.BuyCommand;
import pl.panryba.mc.shop.commands.ShopCommand;

import java.util.ArrayList;
import java.util.List;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        List<ShopItem> items = new ArrayList<>();

        VipShopItem vip = new VipShopItem("VIP", 4, 1, "VIP", "VIP wazny 4 dni (szczegoly: http://panryba.pl/help/vip/)");
        SetShopItem vipItems = new SetShopItem(new ItemSet(
                new ItemSetPart[]{
                        new ItemSetPart(Material.DIAMOND_BOOTS, 1),
                        new ItemSetPart(Material.DIAMOND_LEGGINGS, 1),
                        new ItemSetPart(Material.DIAMOND_CHESTPLATE, 1),
                        new ItemSetPart(Material.DIAMOND_HELMET, 1),
                        new ItemSetPart(Material.DIAMOND_SWORD, 1),
                        new ItemSetPart(Material.DIAMOND_PICKAXE, 1),
                        new ItemSetPart(Material.BOW, 1),
                        new ItemSetPart(Material.ARROW, 64),
                        new ItemSetPart(Material.EXP_BOTTLE, 64),
                        new ItemSetPart(Material.EXP_BOTTLE, 64),
                        new ItemSetPart(Material.GOLD_BLOCK, 16)
                        }), "VIP", 1, "Zestaw VIP (szczegoly: http://panryba.pl/help/vip/)");

        VipShopItem svip = new VipShopItem("SVIP", 7, 3, "SVIP", "Super VIP wazny 7 dni (szczegoly: http://panryba.pl/help/vip/)");
        SetShopItem svipItems = new SetShopItem(new ItemSet(
                new ItemSetPart[]{
                        new ItemSetPart(Material.DIAMOND_SWORD, 1, new ItemSetEnchantment[]{new ItemSetEnchantment(Enchantment.DAMAGE_ALL, 5)}),
                        new ItemSetPart(Material.DIAMOND_PICKAXE, 1, new ItemSetEnchantment[]{
                                new ItemSetEnchantment(Enchantment.DURABILITY, 3),
                                new ItemSetEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3)
                        }),
                        new ItemSetPart(Material.DIAMOND_HELMET, 1, new ItemSetEnchantment[]{new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)}),
                        new ItemSetPart(Material.DIAMOND_CHESTPLATE, 1, new ItemSetEnchantment[]{new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)}),
                        new ItemSetPart(Material.DIAMOND_LEGGINGS, 1, new ItemSetEnchantment[]{new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)}),
                        new ItemSetPart(Material.DIAMOND_BOOTS, 1, new ItemSetEnchantment[]{new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)}),
                        new ItemSetPart(Material.FISHING_ROD, 1, new ItemSetEnchantment[]{
                                new ItemSetEnchantment(Enchantment.DURABILITY, 2),
                                new ItemSetEnchantment(Enchantment.LUCK, 2)
                        }),
                        new ItemSetPart(Material.GOLDEN_APPLE, 3, (short) 1),
                        new ItemSetPart(Material.NETHER_STALK, 3),
                        new ItemSetPart(Material.BLAZE_ROD, 3),
                        new ItemSetPart(Material.FERMENTED_SPIDER_EYE, 3),
                        new ItemSetPart(Material.MAGMA_CREAM, 3),
                        new ItemSetPart(Material.SPECKLED_MELON, 3)
                }
        ), "SVIP", 3, "Super VIP wazny 7 dni (szczegoly: http://panryba.pl/help/vip/)");

        items.add(new BatchShopItem(new ShopItem[]{ vip, vipItems }, "VIP", 2, "zestaw VIPa oraz ranga VIP wazna 4 dni (szczegoly: http://panryba.pl/help/vip/"));
        items.add(new BatchShopItem(new ShopItem[]{ svip, svipItems }, "SVIP", 5, "zestaw SVIPa oraz ranga SVIP wazna 7 dni (szczegoly: http://panryba.pl/help/vip/"));
        items.add(new LevelShopItem(100, 4, "100LVL", "100 poziomow doswiadczenia"));
        items.add(new LevelShopItem(200, 6, "200LVL", "200 poziomow doswiadczenia"));
        items.add(new SetShopItem(new ItemSet(new ItemSetPart[]{
                new ItemSetPart(Material.GOLDEN_APPLE, 10, (short) 1)
        }), "10KOX", 6, "10 koxow"));
        items.add(new ProtectionShopItem(7 /* days */ * 24 /* hours */ * 60 /* minutes */ * 60 /* seconds*/, 4, "OCHRONA7", "Ochrona przed banem za smierc na 7 dni"));

        /*
        items.add(new SetShopItem(
                new ItemSet(new ItemSetPart[] {
                    new ItemSetPart(Material.MONSTER_EGG, 1, (short)100),
                    new ItemSetPart(Material.LEASH, 1),
                    new ItemSetPart(Material.SADDLE, 1)
                })
                , "KONNY", 4, "Zestaw konny (jajko spawnujace konia, siodlo, lasso)"));
        
        items.add(new BatchShopItem(
                new ShopItem[] {
                    new SetShopItem(new ItemSet(new ItemSetPart[] {
                        new ItemSetPart(Material.SMOOTH_BRICK, 64),
                        new ItemSetPart(Material.SMOOTH_BRICK, 64),
                        new ItemSetPart(Material.SMOOTH_BRICK, 64),
                        new ItemSetPart(Material.SMOOTH_BRICK, 64),
                        new ItemSetPart(Material.OBSIDIAN, 64),
                        new ItemSetPart(Material.OBSIDIAN, 64),
                        new ItemSetPart(Material.OBSIDIAN, 64),
                        new ItemSetPart(Material.OBSIDIAN, 64),
                        new ItemSetPart(Material.OBSIDIAN, 64),
                        new ItemSetPart(Material.OBSIDIAN, 64)
                    }), null, 0, null),
                    new LevelShopItem(60, 0, null, null)
                }, "OBRONCA", 9, "Zestaw obroncy (4 * stak kamiennych cegiel, 6 * stak obsydianu, +60 poziom doswiadczenia)"));
        
        items.add(new BatchShopItem(
                    new ShopItem[] {
                        new SetShopItem(
                            new ItemSet(
                            new ItemSetPart[] {
                                new ItemSetPart(Material.DIAMOND_PICKAXE, 1, new ItemSetEnchantment[] {
                                    new ItemSetEnchantment(Enchantment.DIG_SPEED, 5),
                                    new ItemSetEnchantment(Enchantment.DURABILITY, 3),
                                    new ItemSetEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 3)
                                }),
                                new ItemSetPart(Material.DIAMOND_SWORD, 1, new ItemSetEnchantment[] {
                                    new ItemSetEnchantment(Enchantment.DAMAGE_ALL, 2),
                                    new ItemSetEnchantment(Enchantment.FIRE_ASPECT, 1)
                                }),
                                new ItemSetPart(Material.DIAMOND, 5),
                                new ItemSetPart(Material.IRON_INGOT, 10),
                                new ItemSetPart(Material.GOLD_INGOT, 10),
                            }), null, 0, null),
                        new LevelShopItem(90, 6, null, null)
                },
                "GORNIK", 6, "Zestaw gornika (dobry kilof, miecz, 5 diaxow, 10 zelaza, 10 zlota, +90 poziomow doswiadczenia)"));
        
        items.add(new SetShopItem(
                new ItemSet(new ItemSetPart[] {
                    new ItemSetPart(Material.DIAMOND_BOOTS, 1, new ItemSetEnchantment[] { new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4) }),
                    new ItemSetPart(Material.DIAMOND_CHESTPLATE, 1, new ItemSetEnchantment[] { new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4) }),
                    new ItemSetPart(Material.DIAMOND_HELMET, 1, new ItemSetEnchantment[] { new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4) }),
                    new ItemSetPart(Material.DIAMOND_LEGGINGS, 1, new ItemSetEnchantment[] { new ItemSetEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4) }),
                    new ItemSetPart(Material.DIAMOND_SWORD, 1, new ItemSetEnchantment[] {
                        new ItemSetEnchantment(Enchantment.DAMAGE_ALL, 5),
                        new ItemSetEnchantment(Enchantment.FIRE_ASPECT, 2)
                    }),
                    new ItemSetPart(Material.GOLDEN_APPLE, 3, (short)1) }),
                "WOJOWNIK", 20, "Zestaw wojownika (diax eq prot 4, dobry miecz, 3 koxy)"));
        
        items.add(new SetShopItem(
                new ItemSet(new ItemSetPart[] {
                  new ItemSetPart(Material.TNT, 64),
                  new ItemSetPart(Material.TNT, 64),
                  new ItemSetPart(Material.FLINT_AND_STEEL, 1),
                  new ItemSetPart(Material.FLINT_AND_STEEL, 1),
                  new ItemSetPart(Material.BOW, 1, new ItemSetEnchantment[] {
                      new ItemSetEnchantment(Enchantment.ARROW_DAMAGE, 3),
                      new ItemSetEnchantment(Enchantment.ARROW_FIRE, 1),
                      new ItemSetEnchantment(Enchantment.ARROW_INFINITE, 1),
                  })
                }), "PYRO", 6, "Zestaw Pyro (2 staki TNT, 2 zapaniczki, dobry luk)"));
        
        items.add(new SetShopItem(
                new ItemSet(new ItemSetPart[] {
                    new ItemSetPart(Material.DIAMOND_HOE, 1),
                    new ItemSetPart(Material.SEEDS, 16),
                    new ItemSetPart(Material.MELON_SEEDS, 16),
                    new ItemSetPart(Material.PUMPKIN_SEEDS, 16),
                    new ItemSetPart(Material.CARROT, 8),
                    new ItemSetPart(Material.POTATO, 8),
                }), "FARMER", 6, "Zestaw farmera (diamentowa motyka, 16 nasion zboza, melona, dyni, 8 nasion marchewki oraz ziemniaka"
                ));
        */

        PluginApi api = new PluginApi(items);
        getCommand("sklep").setExecutor(new ShopCommand(api));
        getCommand("kup").setExecutor(new BuyCommand(api));
    }

}
