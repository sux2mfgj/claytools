package dev.sux2mfgj.claytools.container;

import dev.sux2mfgj.claytools.ClayTools;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS =
            new DeferredRegister<>(ForgeRegistries.CONTAINERS, ClayTools.mod_id);

    public static final RegistryObject<ContainerType<ClayWorkbenchContainer>> CLAYWORKBENCH =
            CONTAINERS.register("clayworkbench", () -> IForgeContainerType.create(ClayWorkbenchContainer::new));
}
