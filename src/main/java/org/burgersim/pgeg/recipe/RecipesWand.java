package org.burgersim.pgeg.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecipesWand implements IRecipe {
    private final ResourceLocation id;
    private final String group;
    private final ItemStack recipeOutput;
    private final String outputType;
    private final Ingredient recipeInput;
    private final int wandLevel;
    private final float manaCost;

    public RecipesWand(ResourceLocation id, String group, ItemStack recipeOutput, String outputType, Ingredient recipeInput,
                       int wandLevel, float manaCost) {
        this.id = id;
        this.group = group;
        this.recipeOutput = recipeOutput;
        this.outputType = outputType;
        this.recipeInput = recipeInput;
        this.wandLevel = wandLevel;
        this.manaCost = manaCost;
    }

    @Override
    public boolean matches(IInventory iInventory, World world) {
        if (iInventory instanceof ModRecipes.InWorldCrafting) {
            for (ItemStack stack : recipeInput.getMatchingStacks()) {
                if (((ModRecipes.InWorldCrafting) iInventory).input.asItem() == stack.getItem()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(IInventory iInventory) {
        return this.recipeOutput.copy();
    }

    @Override
    public boolean canFit(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    public String getOutputType() {
        return outputType;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.RECIPE_WAND;
    }

    public int getWandLevel() {
        return wandLevel;
    }

    public float getManaCost() {
        return manaCost;
    }

    public static class Serizalizer implements IRecipeSerializer<RecipesWand> {
        public Serizalizer() {
        }

        @Override
        public RecipesWand read(ResourceLocation resourceLocation, JsonObject jsonObject) {
            String recipeGroup = JsonUtils.getString(jsonObject, "group", "");
            Ingredient ingredient = Ingredient.fromJson(JsonUtils.getJsonObject(jsonObject, "input"));
            String registryName = JsonUtils.getString(jsonObject, "result");
            String resultType = JsonUtils.getString(jsonObject, "result_type");
            int wandLevel = JsonUtils.getInt(jsonObject, "wand_level");
            float manaCost = JsonUtils.getFloat(jsonObject, "mana_cost");
            Item item = Item.REGISTRY.getObject(new ResourceLocation(registryName));
            ItemStack stack;
            if (item != null) {
                stack = new ItemStack(item);
            } else {
                throw new IllegalStateException(item + " did not exist");
            }
            return new RecipesWand(resourceLocation, recipeGroup, stack, resultType, ingredient, wandLevel, manaCost);

        }

        @Override
        public RecipesWand read(ResourceLocation resourceLocation, PacketBuffer packetBuffer) {
            String recipeGroup = packetBuffer.readString(32767);
            Ingredient input = Ingredient.fromBuffer(packetBuffer);
            int wandLevel = packetBuffer.readInt();
            float manaCost = packetBuffer.readFloat();
            ItemStack output = packetBuffer.readItemStack();
            String outputType = packetBuffer.readString(32767);
            return new RecipesWand(resourceLocation, recipeGroup, output, outputType, input, wandLevel, manaCost);
        }

        @Override
        public void write(PacketBuffer packetBuffer, RecipesWand recipesWand) {
            packetBuffer.writeString(recipesWand.group);
            recipesWand.recipeInput.writeToBuffer(packetBuffer);
            packetBuffer.writeInt(recipesWand.wandLevel);
            packetBuffer.writeFloat(recipesWand.manaCost);
            packetBuffer.writeItemStack(recipesWand.recipeOutput);
            packetBuffer.writeString(recipesWand.outputType);
        }

        @Override
        public String getId() {
            return "crafting_wand";
        }
    }
}
