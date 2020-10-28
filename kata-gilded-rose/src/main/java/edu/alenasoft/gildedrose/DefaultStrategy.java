package edu.alenasoft.gildedrose;

public class DefaultStrategy implements UpdateQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        item.setQuality(item.getQuality() - 1);
        item.setSellIn(item.getSellIn() - 1);

        if (item.getSellIn() < 0)
            item.setQuality(item.getQuality() - 1);
    }
}
