package dev.sux2mfgj.claytools.block;

import dev.sux2mfgj.claytools.ClayTools;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ClayTools.mod_id);

    // blocks
    public static final RegistryObject<Block> CLAYWORKBENCH_BLOCK = BLOCKS.register("clayworkbench",
            ClayWorkbenchBlock::new);
}
