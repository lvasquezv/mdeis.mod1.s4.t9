package edu.alenasoft.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

  public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
  public static final String AGED_BRIE = "Aged Brie";
  public static List<Item> items = new ArrayList<>();

  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    items.add(new Item("+5 Dexterity Vest", 10, 20));
    items.add(new Item(AGED_BRIE, 2, 0));
    items.add(new Item("Elixir of the Mongoose", 5, 7));
    items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80));
    items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 15, 20));
    items.add(new Item(CONJURED_MANA_CAKE, 3, 6));

    updateQuality();

    System.out.println(items);
  }
  public static void updateQuality() {
    for (Item item : items) {
      getStrategy(item).updateQuality(item);
    }
  }
  public static UpdateQualityStrategy getStrategy(Item item){
    switch (item.getName().toString()){
      case AGED_BRIE:{return new AgedBrieStrategy();}
      case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT: return new BackstagePassesStrategy();
      case SULFURAS_HAND_OF_RAGNAROS: return new SulfurasStrategy();
      case CONJURED_MANA_CAKE: return new ConjuredStrategy();
      default:
          return new DefaultStrategy();
    }
  }
  public static void updateQuality01() {
    for (int i = 0; i < items.size(); i++) {
      if ((!"Aged Brie".equals(items.get(i).getName()))
          && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
        if (items.get(i).getQuality() > 0) {
          if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
            items.get(i).setQuality(items.get(i).getQuality() - 1);
          }
        }
      } else {
        if (items.get(i).getQuality() < 50) {
          items.get(i).setQuality(items.get(i).getQuality() + 1);

          if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
            if (items.get(i).getSellIn() < 11) {
              if (items.get(i).getQuality() < 50) {
                items.get(i).setQuality(items.get(i).getQuality() + 1);
              }
            }

            if (items.get(i).getSellIn() < 6) {
              if (items.get(i).getQuality() < 50) {
                items.get(i).setQuality(items.get(i).getQuality() + 1);
              }
            }
          }
        }
      }

      if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
      }

      if (items.get(i).getSellIn() < 0) {
        if (!"Aged Brie".equals(items.get(i).getName())) {
          if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
            if (items.get(i).getQuality() > 0) {
              if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
                items.get(i).setQuality(items.get(i).getQuality() - 1);
              }
            }
          } else {
            items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
          }
        } else {
          if (items.get(i).getQuality() < 50) {
            items.get(i).setQuality(items.get(i).getQuality() + 1);
          }
        }
      }
    }
  }

}
