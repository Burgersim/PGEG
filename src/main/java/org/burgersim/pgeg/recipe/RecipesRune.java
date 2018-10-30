package org.burgersim.pgeg.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RecipesRune implements IRecipe {
    private final ResourceLocation id;
    private final String group;
    private final ResourceLocation rune;
    private final NonNullList<Ingredient> recipeItems;

    public RecipesRune(ResourceLocation id, String group, ResourceLocation rune, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.group = group;
        this.rune = rune;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(IInventory iInventory, World world) {
        if (iInventory instanceof RuneCrafting) {
            return rune.equals(((RuneCrafting) iInventory).getRune());
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(IInventory iInventory) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canFit(int i, int i1) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    public boolean tryCraft(EntityPlayer player) {
        if (player.capabilities.isCreativeMode) {
            return true;
        }
        List<ItemStack> stacks = new ArrayList<>();
        int itemCount = 0;
        for (Ingredient ingredient : recipeItems) {
            for (ItemStack stack : player.inventory.mainInventory) {
                if (ingredient.test(stack)) {
                    itemCount++;
                    stacks.add(stack);
                    break;
                }
            }
        }
        if (itemCount == recipeItems.size()) {
            stacks.forEach(stack -> stack.shrink(1));
            return true;
        }
        return false;
    }

    public static class Serializer implements IRecipeSerializer<RecipesRune> {
        public static final Serializer INSTANCE = new RecipesRune.Serializer();

        private Serializer() {
        }


        @Override
        public RecipesRune read(ResourceLocation resourceLocation, JsonObject jsonObject) {
            String group = JsonUtils.getString(jsonObject, "group", "");
            ResourceLocation rune = new ResourceLocation(JsonUtils.getString(jsonObject, "rune"));
            NonNullList<Ingredient> ingredients = getIngredients(JsonUtils.getJsonArray(jsonObject, "ingredients"));
            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for rune recipe");
            } else {
                return new RecipesRune(resourceLocation, group, rune, ingredients);
            }
        }

        private static NonNullList<Ingredient> getIngredients(JsonArray jsonArray) {
            NonNullList<Ingredient> ingredients = NonNullList.create();

            for (int i = 0; i < jsonArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(jsonArray.get(i));
                if (!ingredient.hasNoMatchingItems()) {
                    ingredients.add(ingredient);
                }
            }

            return ingredients;
        }

        @Override
        public RecipesRune read(ResourceLocation resourceLocation, PacketBuffer packetBuffer) {
            String group = packetBuffer.readString(32767);
            ResourceLocation rune = new ResourceLocation(packetBuffer.readString(32767));
            int ingredientsSize = packetBuffer.readVarInt();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(ingredientsSize, Ingredient.EMPTY);
            for (int i = 0; i < ingredients.size(); ++i) {
                ingredients.set(i, Ingredient.fromBuffer(packetBuffer));
            }
            return new RecipesRune(resourceLocation, group, rune, ingredients);
        }

        @Override
        public void write(PacketBuffer packetBuffer, RecipesRune recipesRune) {
            packetBuffer.writeString(recipesRune.group);
            packetBuffer.writeString(recipesRune.rune.toString());
            packetBuffer.writeVarInt(recipesRune.recipeItems.size());
            for (Ingredient ingredient : recipesRune.recipeItems) {
                ingredient.writeToBuffer(packetBuffer);
            }
        }

        @Override
        public String getId() {
            return MOD_ID + ":rune";
        }
    }

    public static class RuneCrafting implements IInventory {
        private final ResourceLocation rune;

        public RuneCrafting(ResourceLocation location) {
            rune = location;
        }

        public ResourceLocation getRune() {
            return rune;
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
