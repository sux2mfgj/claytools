package dev.sux2mfgj.claytools.items;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.block.BlockInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.system.CallbackI;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ClayTools.mod_id);

    public static final RegistryObject<BlockItem> CLAYWORKBENCH_ITEM = ITEMS.register("clayworkbench", 
            () -> new BlockItem(BlockInit.CLAYWORKBENCH.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
    );

    public static final RegistryObject<Item> RAW_CRUDE_CLAY_PLATE_ITEM = ITEMS.register("rawcrudeclayplate", 
            () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CRUDE_CLAY_PLATE_ITEM = ITEMS.register("crudeclayplate",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> RAW_CRUDE_CLAY_SPATULA_ITEM = ITEMS.register("rawcrudeclayspatula",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CRUDE_CLAY_SPATULA_ITEM = ITEMS.register("crudeclayspatula",
            () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
}
