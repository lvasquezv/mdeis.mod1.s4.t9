package edu.alenasoft.gildedrose;

public class ConjuredStrategy implements UpdateQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        item.setQuality(item.getQuality() - 2);
        item.setSellIn(item.getSellIn() - 1);

        if (item.getSellIn() < 0)
            item.setQuality(item.getQuality() - 2);
        if (item.getQuality()<0)
            item.setQuality(0);
    }
}
