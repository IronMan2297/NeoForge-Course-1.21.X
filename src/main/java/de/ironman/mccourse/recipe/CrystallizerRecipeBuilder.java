package de.ironman.mccourse.recipe;

import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class CrystallizerRecipeBuilder implements RecipeBuilder {

    private final Ingredient ingredient;
    private final ItemStack result;
    private int count = 1;

    public CrystallizerRecipeBuilder(Ingredient ingredient, ItemStack result) {
        this.ingredient = ingredient;
        this.result = result;
    }

    public static CrystallizerRecipeBuilder crystallizing(
            Ingredient ingredient,
            ItemStack result
    ) {
        return new CrystallizerRecipeBuilder(ingredient, result);
    }

    @Override
    public CrystallizerRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        return this;
    }

    @Override
    public CrystallizerRecipeBuilder group(String groupName) {
        return this;
    }

    public CrystallizerRecipeBuilder count(int count) {
        this.count = count;
        return this;
    }

    @Override
    public Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        ItemStack resultStack = result.copy();
        resultStack.setCount(count);

        CrystallizerRecipe recipe = new CrystallizerRecipe(
                ingredient,
                resultStack
        );

        recipeOutput.accept(id, recipe, null);
    }
}