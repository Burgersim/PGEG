package org.burgersim.pgeg.recipe;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.RecipeSerializers;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public class ModRecipes {
    public ModRecipes(){}
    public static final IRecipeSerializer<RecipesWand> RECIPE_WAND;

    static {
        RECIPE_WAND = RecipeSerializers.register(new RecipesWand.Serizalizer());
    }
    public static class InWorldCrafting implements IInventory {

        public Block input;

        public InWorldCrafting(Block input) {
            this.input = input;
        }

        @Override
        public int getSizeInventory() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public ItemStack getStackInSlot(int i) {
            return null;
        }

        @Override
        public ItemStack decrStackSize(int i, int i1) {
            return null;
        }

        @Override
        public ItemStack removeStackFromSlot(int i) {
            return null;
        }

        @Override
        public void setInventorySlotContents(int i, ItemStack itemStack) {

        }

        @Override
        public int getInventoryStackLimit() {
            return 0;
        }

        @Override
        public void markDirty() {

        }

        @Override
        public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
            return false;
        }

        @Override
        public void openInventory(EntityPlayer entityPlayer) {

        }

        @Override
        public void closeInventory(EntityPlayer entityPlayer) {

        }

        @Override
        public boolean isItemValidForSlot(int i, ItemStack itemStack) {
            return false;
        }

        @Override
        public int getField(int i) {
            return 0;
        }

        @Override
        public void setField(int i, int i1) {

        }

        @Override
        public int getFieldCount() {
            return 0;
        }

        @Override
        public void clear() {

        }

        @Override
        public ITextComponent getName() {
            return null;
        }

        @Override
        public boolean hasCustomName() {
            return false;
        }

        @Nullable
        @Override
        public ITextComponent getCustomName() {
            return null;
        }
    }
}