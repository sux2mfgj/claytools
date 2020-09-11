package dev.sux2mfgj.claytools.items;

import net.minecraft.item.*;

public class CrudeClayShovel extends ShovelItem {
    CrudeClayShovel(ItemGroup itemGroup) {
        super(ItemTier.IRON, 1.0F, -3.0F, new Item.Properties().group(itemGroup));
    }

    //TODO override for repair, etc.
}
