package dev.sux2mfgj.claytools.client;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.client.gui.ClayWorkbenchScreen;
import dev.sux2mfgj.claytools.container.ContainerInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ClayTools.mod_id, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        ClayTools.LOGGER.info("FMLClientSetupEvent");
        ScreenManager.registerFactory(ContainerInit.CLAYWORKBENCH.get(), ClayWorkbenchScreen::new);
    }
}
