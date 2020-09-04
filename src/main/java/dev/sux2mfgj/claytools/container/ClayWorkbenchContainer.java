package dev.sux2mfgj.claytools.container;

import dev.sux2mfgj.claytools.tileentity.ClayWorkbenchTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

public class ClayWorkbenchContainer extends Container {

    // for server
    public ClayWorkbenchContainer(final int windowId, final PlayerInventory playerInventory, final ClayWorkbenchTileEntity tile)
    {
        super(ContainerInit.CLAYWORKBENCH.get(), windowId);

        //TODO
    }
    
    // for client
    public ClayWorkbenchContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data)
    {
        this(windowId, playerInventory,
                (ClayWorkbenchTileEntity)playerInventory.player.world.getTileEntity(data.readBlockPos()));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerEntity) {
        return true;
    }
}
