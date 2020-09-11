package dev.sux2mfgj.claytools.container;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.network.NetworkManager;
import dev.sux2mfgj.claytools.tileentity.ClayWorkbenchTileEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.SlotItemHandler;
import org.graalvm.compiler.api.replacements.Snippet;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ClayWorkbenchContainer extends Container implements Button.IPressable {

    ClayWorkbenchTileEntity tileEntity;

    // for server
    public ClayWorkbenchContainer(final int windowId, final PlayerInventory playerInventory, final ClayWorkbenchTileEntity tile)
    {
        super(ContainerInit.CLAYWORKBENCH.get(), windowId);
        tileEntity = tile;

        final int startX = 8;
        final int slotSizePlus2 = 18;
        final int hotbarY = 142;

        // setup hot bar
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

        // setup Clayworkbench slot
        final int box_start_y = 32;
        final int left_box_start_x = 32;
        final int right_box_start_x = 120;
        
        // input slot
        this.addSlot(new SlotItemHandler(tile.getInventory(), 0, left_box_start_x + 4, box_start_y + 4));
        // output slot
        this.addSlot(new SlotItemHandler(tile.getInventory(), 1, right_box_start_x + 4, box_start_y + 4));
        // tool slot
        this.addSlot(new SlotItemHandler(tile.getInventory(), 2, 80, 10));
    }
    
    // for client
    public ClayWorkbenchContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data)
    {
        this(windowId, playerInventory,
                (ClayWorkbenchTileEntity)playerInventory.player.world.getTileEntity(data.readBlockPos()));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerEntity) {
        //TODO
        return true;
    }

    @Override
    public void onPress(Button button) {
        // send msg to server
        NetworkManager.pressClayWorkbenchButton();
    }
    
    public void onPressServer() {
        this.tileEntity.onPressServer();
    }


    //TODO maybe this function is something wrong.
    @Nonnull
    @Override
    public ItemStack transferStackInSlot(PlayerEntity player, int index) {
        ClayTools.LOGGER.info("transferStackInSlot " + String.format("index: %d", index));

        final Slot slot = this.inventorySlots.get(index);
        ItemStack returnStack = ItemStack.EMPTY;

        if(slot != null && slot.getHasStack())
        {
            final ItemStack slotStack = slot.getStack();
            returnStack = slotStack.copy();
            //TODO
            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(slotStack, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(slotStack, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (slotStack.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (slotStack.getCount() == returnStack.getCount()) {
                ClayTools.LOGGER.info("transferStackInSlot 6");

                return ItemStack.EMPTY;
            }

            ClayTools.LOGGER.info("transferStackInSlot 7");

            slot.onTake(player, slotStack);
        }

        return returnStack;
    }
}
