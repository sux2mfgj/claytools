package dev.sux2mfgj.claytools.items;

import dev.sux2mfgj.claytools.ClayTools;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CrudeClayShovel extends ShovelItem {
    CrudeClayShovel(ItemGroup itemGroup) {
        super(ItemTier.STONE, 1.0F, -3.0F, new Item.Properties().group(itemGroup));
    }

    //TODO override for repair, etc.
}
