package edu.alenasoft.gildedrose;

public class SulfurasStrategy implements UpdateQualityStrategy {
    @Override
    public void updateQuality(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

}
