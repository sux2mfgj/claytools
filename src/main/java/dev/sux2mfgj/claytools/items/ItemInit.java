package dev.sux2mfgj.claytools.items;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.block.BlockInit;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.graalvm.compiler.core.amd64.AMD64NodeLIRBuilder_OptionDescriptors;
import org.lwjgl.system.CallbackI;

public class ItemInit {

    private static ItemGroup modGroup = ItemGroup.MISC;
    static private Item clayToolsItemBuilder() {
        return new Item(new Item.Properties().group(modGroup));
    }

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ClayTools.mod_id);

    // Blocks
    public static final RegistryObject<BlockItem> CLAYWORKBENCH_ITEM = ITEMS.register("clay_workbench",
            () -> new BlockItem(BlockInit.CLAYWORKBENCH.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    // Tools
    public static final RegistryObject<ShovelItem> CRUDE_CLAY_SHOVEL_ITEM = ITEMS.register("crude_clay_shovel",
            () -> new CrudeClayShovel(modGroup));
    public static final RegistryObject<PickaxeItem> CRUDE_CLAY_PICKAXE_ITME = ITEMS.register("crude_clay_pickaxe",
            () -> new CrudeClayPickaxe(modGroup));

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
    public static final RegistryObject<Item> RAW_CRUDE_CLAY_TOOL_UNIT_ITEM = ITEMS.register(
            "raw_crude_clay_tool_unit",
            ItemInit::clayToolsItemBuilder);
}
