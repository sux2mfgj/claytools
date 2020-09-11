package dev.sux2mfgj.claytools.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;

public class CrudeClayPickaxe extends PickaxeItem {
    CrudeClayPickaxe(ItemGroup itemGroup) {
        super(ItemTier.IRON, 2, -3.0F,  new Item.Properties().group(itemGroup));
    }
}