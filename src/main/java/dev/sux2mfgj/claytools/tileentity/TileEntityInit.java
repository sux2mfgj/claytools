package dev.sux2mfgj.claytools.tileentity;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.block.BlockInit;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
    
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(
            ForgeRegistries.TILE_ENTITIES,
            ClayTools.mod_id);

    public static final RegistryObject<TileEntityType<ClayWorkbenchTileEntity>> CLAYWORKBENCH =
            TILE_ENTITIES.register("clayworkbench",
                    () -> TileEntityType.Builder.create(
                            ClayWorkbenchTileEntity::new,
                            BlockInit.CLAYWORKBENCH.get()).build(null));
}
