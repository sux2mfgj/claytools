package dev.sux2mfgj.claytools.utli;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class ClayItemStackHandler extends ItemStackHandler {
    private int output_slot;
    
    public ClayItemStackHandler(final int slots, final int output_slot)
    {
        super(slots);
        this.output_slot = output_slot;
    }

    /*
    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {

        if(slot == output_slot) {
            //return stack;
        }

        return super.insertItem(slot, stack, simulate);
    }
    */

    public void setNonNullList(NonNullList<ItemStack> items)
    {
        this.stacks.set(0, items.get(0));
        this.stacks.set(1, items.get(1));
    }
    
    public NonNullList<ItemStack> toNonNullList()
    {
        NonNullList<ItemStack> items = NonNullList.create();
        for(ItemStack stack : this.stacks) {
            items.add(stack);
        }

        return items;
    }
}
