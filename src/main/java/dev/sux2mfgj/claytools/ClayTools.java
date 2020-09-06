package dev.sux2mfgj.claytools;

import dev.sux2mfgj.claytools.block.BlockInit;
import dev.sux2mfgj.claytools.block.ClayWorkbenchBlock;
import dev.sux2mfgj.claytools.container.ContainerInit;
import dev.sux2mfgj.claytools.items.ItemInit;
import dev.sux2mfgj.claytools.network.NetworkManager;
import dev.sux2mfgj.claytools.tileentity.TileEntityInit;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Mod("claytools")
@Mod.EventBusSubscriber(modid = ClayTools.mod_id, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClayTools
{
    public static final String mod_id = "claytools";
    public static final Logger LOGGER = LogManager.getLogger();

    public ClayTools() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        TileEntityInit.TILE_ENTITIES.register(modEventBus);
        ContainerInit.CONTAINERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        NetworkManager.init();
    }

    private void setup(FMLCommonSetupEvent event) {

    }

}