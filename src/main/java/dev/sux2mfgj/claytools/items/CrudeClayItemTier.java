package dev.sux2mfgj.claytools.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.client.model.ItemTextureQuadConverter;

import java.util.function.Supplier;

public enum CrudeClayItemTier implements IItemTier {

    CRUDE_CLAY(() -> {
       return Ingredient.fromItems(ItemInit.CRUDE_CLAY_TOOL_UNIT_ITEM.get());
    });

    private final LazyValue<Ingredient> repairMaterial;

    CrudeClayItemTier(Supplier<Ingredient> repairMateria) {
        this.repairMaterial = new LazyValue<>(repairMateria);
    }

    @Override
    public int getMaxUses() {
        return ItemTier.IRON.getMaxUses();
    }

    @Override
    public float getEfficiency() {
        return ItemTier.IRON.getEfficiency();
    }

    @Override
    public float getAttackDamage() {
        return ItemTier.IRON.getAttackDamage();
    }

    @Override
    public int getHarvestLevel() {
        return ItemTier.IRON.getHarvestLevel();
    }

    @Override
    public int getEnchantability() {
        return ItemTier.IRON.getEnchantability();
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}
