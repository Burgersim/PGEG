package org.burgersim.pgeg.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.burgersim.pgeg.tileentity.TileEntitySpellCauldron;

import java.util.Iterator;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

public class RecipesSpellCauldron implements IRecipe {

    private final ResourceLocation id;
    private final String group;
    private final ItemStack recipeOutput;
    private final NonNullList<Ingredient> recipeItems;
    private final NonNullList<Ingredient> wandItems;

    public RecipesSpellCauldron(ResourceLocation id, String group, ItemStack recipeOutput, NonNullList<Ingredient> recipeItems, NonNullList<Ingredient> wandItems) {
        this.id = id;
        this.group = group;
        this.recipeOutput = recipeOutput;
        this.recipeItems = recipeItems;
        this.wandItems = wandItems;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public boolean matches(IInventory iInventory, World world) {
        if (!(iInventory instanceof TileEntitySpellCauldron)) {
            return false;
        } else {
            RecipeItemHelper helper = new RecipeItemHelper();
            int inputCount = 0;
            for (int i = 0; i < 10; i++) {
                ItemStack stack = iInventory.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    inputCount++;
                    helper.accountStack(stack);
                }
            }
            return inputCount == recipeItems.size() && helper.canCraft(this, null);
        }

    }

    @Override
    public ItemStack getCraftingResult(IInventory iInventory) {
        return this.recipeOutput.copy();
    }

    @Override
    public boolean canFit(int i, int i1) {
        return false;
    }

    public boolean isRightWand(ItemStack stack){
        for(Ingredient ingredient : wandItems){
            if (ingredient.test(stack)){
                return true;
            }
        }
        return false;
    }
    public NonNullList<Ingredient> getWandItems() {
        return wandItems;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }


    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Serializer implements IRecipeSerializer<RecipesSpellCauldron> {
        public static final Serializer INSTANCE = new RecipesSpellCauldron.Serializer();

        private Serializer() {
        }

        public RecipesSpellCauldron read(ResourceLocation resourceLocation, JsonObject jsonObject) {
            String group = JsonUtils.getString(jsonObject, "group", "");
            NonNullList<Ingredient> ingredients = getIngredients(JsonUtils.getJsonArray(jsonObject, "ingredients"));
            NonNullList<Ingredient> wandItems = getIngredients(JsonUtils.getJsonArray(jsonObject, "wands"));
            if (ingredients.isEmpty()) {
                throw new JsonParseException("No ingredients for spell cauldron recipe");
            } else if (ingredients.size() > 10) {
                throw new JsonParseException("Too many ingredients for spell cauldron recipe");
            } else {
                ItemStack stack = ShapedRecipe.deserializeItem(JsonUtils.getJsonObject(jsonObject, "result"));
                return new RecipesSpellCauldron(resourceLocation, group, stack, ingredients, wandItems);
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

        public String getId() {
            return MOD_ID + ":spell_cauldron";
        }

        public RecipesSpellCauldron read(ResourceLocation resourceLocation, PacketBuffer buffer) {
            String group = buffer.readString(32767);
            int ingredientsSize = buffer.readVarInt();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(ingredientsSize, Ingredient.EMPTY);
            for (int i = 0; i < ingredients.size(); ++i) {
                ingredients.set(i, Ingredient.fromBuffer(buffer));
            }
            int wandsSize = buffer.readVarInt();
            NonNullList<Ingredient> wandItems = NonNullList.withSize(wandsSize, Ingredient.EMPTY);
            for (int i = 0; i < wandItems.size(); ++i) {
                wandItems.set(i, Ingredient.fromBuffer(buffer));
            }
            ItemStack output = buffer.readItemStack();
            return new RecipesSpellCauldron(resourceLocation, group, output, ingredients, wandItems);
        }

        public void write(PacketBuffer buffer, RecipesSpellCauldron recipesSpellCauldron) {
            buffer.writeString(recipesSpellCauldron.group);
            buffer.writeVarInt(recipesSpellCauldron.recipeItems.size());
            Iterator var3 = recipesSpellCauldron.recipeItems.iterator();

            while (var3.hasNext()) {
                Ingredient ingredient = (Ingredient) var3.next();
                ingredient.writeToBuffer(buffer);
            }
            buffer.writeVarInt(recipesSpellCauldron.wandItems.size());
            Iterator it = recipesSpellCauldron.wandItems.iterator();

            while (it.hasNext()) {
                Ingredient ingredient = (Ingredient) it.next();
                ingredient.writeToBuffer(buffer);
            }

            buffer.writeItemStack(recipesSpellCauldron.recipeOutput);
        }
    }
}
