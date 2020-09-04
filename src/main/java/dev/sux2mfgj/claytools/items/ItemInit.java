package dev.sux2mfgj.claytools.items;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.block.BlockInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ClayTools.mod_id);

    public static final RegistryObject<BlockItem> CLAYWORKBENCH_ITEM = ITEMS.register("clayworkbench", 
            () -> new BlockItem(BlockInit.CLAYWORKBENCH_BLOCK.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    );
}
