package dev.sux2mfgj.claytools.tileentity;

import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.container.ClayWorkbenchContainer;
import dev.sux2mfgj.claytools.items.ItemInit;
import dev.sux2mfgj.claytools.utli.ClayItemStackHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class ClayWorkbenchTileEntity extends TileEntity implements INamedContainerProvider {

    //private ItemStackHandler inventory;
    private ClayItemStackHandler inventory;
    private final int nItemSlots = 2;
    private final int input_slot_index = 0;
    private final int output_slot_index = 1;
    private int a;
    Map<Item, Item> recipeTable;

    public ClayWorkbenchTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        inventory = new ClayItemStackHandler(nItemSlots, output_slot_index);
        a = 0;
        recipeTable = new HashMap<>();
        setupRecipes();
    }
    
    private void setupRecipes() {
        registerRecipe(Items.CLAY_BALL, ItemInit.RAW_CRUDE_CLAY_PLATE_ITEM.get()); //TODO temporary recipe.
    }
    
    private boolean registerRecipe(Item src, Item dest) {
        if(recipeTable.containsKey(src)) {
            return false;
        }
        recipeTable.put(src, dest);
        return true;
    }
    
    public ItemStackHandler getInventory() {
        return this.inventory;
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

    public void onPressServer()
    {
        ItemStack srcStack = this.inventory.getStackInSlot(input_slot_index);
        ItemStack destStack = this.inventory.getStackInSlot(output_slot_index);
        //TODO add a code when the destStack is full.
        if(!recipeTable.containsKey(srcStack.getItem()) || destStack.getCount() == 64)
        {
            return;
        }
        
        Item destItem = recipeTable.get(srcStack.getItem());

        ItemStack output = new ItemStack(destItem, 1);
        srcStack.shrink(1);
        this.inventory.insertItem(output_slot_index, output.copy(), false);
    }

    // methods for NBT
    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        NonNullList<ItemStack> inv = NonNullList.<ItemStack>withSize(this.inventory.getSlots(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, inv);
        this.inventory.setNonNullList(inv);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
        return compound;
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);
        return new SUpdateTileEntityPacket(this.pos, 0, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.read(pkt.getNbtCompound());
    }

    //TODO
}
