package org.burgersim.pgeg.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Iterator;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RecipesWand implements IRecipe {
    private final ResourceLocation id;
    private final String group;
    private final ItemStack recipeOutput;
    private final Ingredient recipeInput;
    private final NonNullList<Ingredient> wandItems;
    private final float manaCost;

    public RecipesWand(ResourceLocation id, String group, ItemStack recipeOutput, Ingredient recipeInput, NonNullList<Ingredient> wandItems, float manaCost) {
        this.id = id;
        this.group = group;
        this.recipeOutput = recipeOutput;
        this.recipeInput = recipeInput;
        this.wandItems = wandItems;
        this.manaCost = manaCost;
    }

    @Override
    public boolean matches(IInventory iInventory, World world) {
        if (iInventory instanceof InWorldCrafting) {
            return recipeInput.test(((InWorldCrafting) iInventory).input);
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(0, recipeInput);
        return ingredients;
    }

    @Override
    public ItemStack getCraftingResult(IInventory iInventory) {
        return this.recipeOutput.copy();
    }

    @Override
    public boolean canFit(int i, int i1) {
        return false;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    public NonNullList<Ingredient> getWandItems() {
        return wandItems;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public boolean isRightWand(ItemStack stack) {
        for (Ingredient ingredient : wandItems) {
            if (ingredient.test(stack)) {
                return true;
            }
        }
        return false;
    }

    public float getManaCost() {
        return manaCost;
    }

    public static class Serializer implements IRecipeSerializer<RecipesWand> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
        }

        @Override
        public RecipesWand read(ResourceLocation resourceLocation, JsonObject jsonObject) {
            String recipeGroup = JsonUtils.getString(jsonObject, "group", "");
            Ingredient input = Ingredient.fromJson(JsonUtils.getJsonObject(jsonObject, "input"));
            String registryName = JsonUtils.getString(jsonObject, "result");
            NonNullList<Ingredient> wandItems = getIngredients(JsonUtils.getJsonArray(jsonObject, "wands"));
            float manaCost = JsonUtils.getFloat(jsonObject, "mana_cost");
            Item item = Item.REGISTRY.get(new ResourceLocation(registryName));
            ItemStack stack;
            if (item != null) {
                stack = new ItemStack(item);
            } else {
                throw new IllegalStateException(item + " did not exist");
            }
            return new RecipesWand(resourceLocation, recipeGroup, stack, input, wandItems, manaCost);

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
        public RecipesWand read(ResourceLocation resourceLocation, PacketBuffer buffer) {
            String recipeGroup = buffer.readString(32767);
            Ingredient input = Ingredient.fromBuffer(buffer);
            int wandsSize = buffer.readVarInt();
            NonNullList<Ingredient> wandItems = NonNullList.withSize(wandsSize, Ingredient.EMPTY);
            for (int i = 0; i < wandItems.size(); ++i) {
                wandItems.set(i, Ingredient.fromBuffer(buffer));
            }
            float manaCost = buffer.readFloat();
            ItemStack output = buffer.readItemStack();
            return new RecipesWand(resourceLocation, recipeGroup, output, input, wandItems, manaCost);
        }

        @Override
        public void write(PacketBuffer buffer, RecipesWand recipesWand) {
            buffer.writeString(recipesWand.group);
            recipesWand.recipeInput.writeToBuffer(buffer);
            buffer.writeVarInt(recipesWand.wandItems.size());
            Iterator it = recipesWand.wandItems.iterator();

            while (it.hasNext()) {
                Ingredient ingredient = (Ingredient) it.next();
                ingredient.writeToBuffer(buffer);
            }
            buffer.writeFloat(recipesWand.manaCost);
            buffer.writeItemStack(recipesWand.recipeOutput);
        }

        @Override
        public String getId() {
            return MOD_ID + ":crafting_wand";
        }
    }
}
