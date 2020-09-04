package dev.sux2mfgj.claytools;

import dev.sux2mfgj.claytools.block.BlockInit;
import dev.sux2mfgj.claytools.block.ClayWorkbenchBlock;
import dev.sux2mfgj.claytools.items.ItemInit;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod("claytools")
public class ClayTools
{
    public static final String mod_id = "claytools";
    public static final Logger LOGGER = LogManager.getLogger();

    public ClayTools() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
    }

    private void setup(FMLCommonSetupEvent event) {

    }

}