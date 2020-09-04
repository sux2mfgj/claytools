package dev.sux2mfgj.claytools.tileentity;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.container.ClayWorkbenchContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class ClayWorkbenchTileEntity extends TileEntity implements INamedContainerProvider {

    public ClayWorkbenchTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    
    public ClayWorkbenchTileEntity() {
        this(TileEntityInit.CLAYWORKBENCH.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        // TODO why the name is started from "container."?
        return new TranslationTextComponent("container." + ClayTools.mod_id + ".clayworkbench");
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ClayWorkbenchContainer(windowId, playerInventory, this);
    }
}
