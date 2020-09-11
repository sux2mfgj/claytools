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

    static private Item clayToolsItemBuilder() {
        return new Item(new Item.Properties().group(ItemGroup.MISC));
    }

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ClayTools.mod_id);

    // Blocks
    public static final RegistryObject<BlockItem> CLAYWORKBENCH_ITEM = ITEMS.register("clayworkbench", 
            () -> new BlockItem(BlockInit.CLAYWORKBENCH.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    // Items
    public static final RegistryObject<Item> RAW_CRUDE_CLAY_PLATE_ITEM = ITEMS.register("raw_crude_clay_plate",
            ItemInit::clayToolsItemBuilder);
    public static final RegistryObject<Item> CRUDE_CLAY_PLATE_ITEM = ITEMS.register("crude_clay_plate",
            ItemInit::clayToolsItemBuilder);
    public static final RegistryObject<Item> RAW_CRUDE_CLAY_SPATULA_ITEM = ITEMS.register(
            "raw_crude_clay_spatula",
            ItemInit::clayToolsItemBuilder);
    public static final RegistryObject<Item> CRUDE_CLAY_SPATULA_ITEM = ITEMS.register("crude_clay_spatula",
            ItemInit::clayToolsItemBuilder);
    public static final RegistryObject<Item> CLAY_TOOL_UNIT_ITEM = ITEMS.register("clay_tool_unit",
            ItemInit::clayToolsItemBuilder);
    public static final RegistryObject<Item> RAW_CLAY_TOOL_UNIT_ITEM = ITEMS.register("raw_clay_tool_unit",
            ItemInit::clayToolsItemBuilder);
    public static final RegistryObject<Item> CRUDE_CLAY_TOOL_UNIT_ITEM = ITEMS.register("crude_clay_tool_unit",
            ItemInit::clayToolsItemBuilder);
    public static final RegistryObject<Item> CRUDE_RAW_CLAY_TOOL_UNIT_ITEM = ITEMS.register(
            "raw_crude_clay_tool_unit",
            ItemInit::clayToolsItemBuilder);
}
