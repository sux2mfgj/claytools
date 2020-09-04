package dev.sux2mfgj.claytools.block;

import dev.sux2mfgj.claytools.ClayTools;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

public class ClayWorkbenchBlock extends Block {
    public ClayWorkbenchBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(1.5f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)
                .sound(SoundType.STONE)
        );

    }
}
