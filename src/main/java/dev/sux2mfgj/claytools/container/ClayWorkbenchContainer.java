package dev.sux2mfgj.claytools.container;

import dev.sux2mfgj.claytools.tileentity.ClayWorkbenchTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

public class ClayWorkbenchContainer extends Container {

    // for server
    public ClayWorkbenchContainer(final int windowId, final PlayerInventory playerInventory, final ClayWorkbenchTileEntity tile)
    {
        super(ContainerInit.CLAYWORKBENCH.get(), windowId);

        final int startX = 8;
        final int slotSizePlus2 = 18;
        final int hotbarY = 142;

        // setup hotbar
        for (int column = 0; column < 9; column++)
        {
            this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), hotbarY));
        }

        // setup player inventory
        final int startY = 84;
        for(int row= 0 ;row < 3;row++) {
            for(int column = 0; column < 9; column++) {
                this.addSlot(new Slot(
                        playerInventory,
                        9 + (row * 9) + column,
                        startX + (column * slotSizePlus2),
                        startY + (row * slotSizePlus2)));
            }
        }

        //TODO setup Clayworkbench slot
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
