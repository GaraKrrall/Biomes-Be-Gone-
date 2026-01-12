package mc.garakrral.biomesbegone.neoforge.data;

import mc.garakrral.biomesbegone.block.Blocks;
import mc.garakrral.biomesbegone.item.Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends RecipeProvider {
    public RecipeGen(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {
        shapeless(RecipeCategory.MISC, Blocks.MAPLE_BUTTON, 1).requires(Blocks.MAPLE_PLANKS).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_BUTTON)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_SLAB, 6).pattern("PPP").define('P', Blocks.MAPLE_PLANKS).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_STAIRS, 4).pattern("P  ").pattern("PP ").pattern("PPP").define('P', Blocks.MAPLE_PLANKS).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_PRESSURE_PLATE, 1).pattern(" PP").define('P', Blocks.MAPLE_PLANKS).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_FENCE, 3).pattern("PSP").pattern("PSP").define('P', Blocks.MAPLE_PLANKS).define('S', net.minecraft.world.item.Items.STICK).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).unlockedBy(getHasName(net.minecraft.world.item.Items.STICK), has(net.minecraft.world.item.Items.STICK)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_FENCE_GATE, 1).pattern("SPS").pattern("SPS").define('P', Blocks.MAPLE_PLANKS).define('S', net.minecraft.world.item.Items.STICK).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).unlockedBy(getHasName(net.minecraft.world.item.Items.STICK), has(net.minecraft.world.item.Items.STICK)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_DOOR, 3).pattern(" PP").pattern(" PP").pattern(" PP").define('P', Blocks.MAPLE_PLANKS).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_TRAPDOOR, 2).pattern("PPP").pattern("PPP").define('P', Blocks.MAPLE_PLANKS).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).save(output);
        shaped(RecipeCategory.MISC, Blocks.MAPLE_WOOD, 3).pattern("LL ").pattern("LL ").define('L', Blocks.MAPLE_LOG).unlockedBy(getHasName(Blocks.MAPLE_LOG), has(Blocks.MAPLE_LOG)).save(output);
        shaped(RecipeCategory.TRANSPORTATION, Items.MAPLE_BOAT, 1).pattern("P P").pattern("PPP").define('P', Blocks.MAPLE_PLANKS).unlockedBy(getHasName(Blocks.MAPLE_PLANKS),has(Blocks.MAPLE_PLANKS)).save(output);
        shaped(RecipeCategory.TRANSPORTATION, Items.MAPLE_CHEST_BOAT, 1).pattern(" C ").pattern(" B ").define('B', Items.MAPLE_BOAT).define('C', net.minecraft.world.level.block.Blocks.CHEST).unlockedBy(getHasName(Blocks.MAPLE_PLANKS), has(Blocks.MAPLE_PLANKS)).unlockedBy(getHasName(net.minecraft.world.level.block.Blocks.CHEST), has(net.minecraft.world.level.block.Blocks.CHEST)).save(output);
        shaped(RecipeCategory.TRANSPORTATION, Items.MAPLE_SIGN, 3).pattern("PPP").pattern("PPP").pattern(" S ").define('P', Blocks.MAPLE_PLANKS).define('S', net.minecraft.world.item.Items.STICK).unlockedBy(getHasName(Blocks.MAPLE_PLANKS),has(Blocks.MAPLE_PLANKS)).unlockedBy(getHasName(net.minecraft.world.item.Items.STICK), has(net.minecraft.world.item.Items.STICK)).save(output);
        shaped(RecipeCategory.TRANSPORTATION, Items.HANGING_MAPLE_SIGN, 6).pattern("C C").pattern("LLL").pattern("LLL").define('L', Blocks.STRIPPED_MAPLE_LOG).define('C', net.minecraft.world.level.block.Blocks.IRON_CHAIN).unlockedBy(getHasName(Blocks.STRIPPED_MAPLE_LOG),has(Blocks.STRIPPED_MAPLE_LOG)).unlockedBy(getHasName(net.minecraft.world.level.block.Blocks.IRON_CHAIN), has(net.minecraft.world.level.block.Blocks.IRON_CHAIN)).save(output);
        shaped(RecipeCategory.MISC, Items.UNCURED_MAPLE_SYRUP, 4).pattern(" G ").pattern("GBG").pattern(" G ").define('G', net.minecraft.world.item.Items.GLASS_BOTTLE).define('B', Items.TAPPED_MAPLE_SAP_BUCKET).unlockedBy(getHasName(net.minecraft.world.item.Items.GLASS_BOTTLE), has(net.minecraft.world.item.Items.GLASS_BOTTLE)).unlockedBy(getHasName(Items.TAPPED_MAPLE_SAP_BUCKET), has(Items.TAPPED_MAPLE_SAP_BUCKET)).save(output);
        shapeless(RecipeCategory.MISC, Blocks.TAPPED_BUCKET, 1).requires(net.minecraft.world.item.Items.BUCKET).requires(net.minecraft.world.item.Items.IRON_INGOT).unlockedBy(getHasName(net.minecraft.world.item.Items.BUCKET), has(net.minecraft.world.item.Items.BUCKET)).unlockedBy(getHasName(net.minecraft.world.item.Items.IRON_INGOT), has(net.minecraft.world.item.Items.IRON_INGOT)).save(output);
        shaped(RecipeCategory.FOOD, Items.PANCAKE ,3).pattern("WMW").pattern(" E ").pattern("WSW").define('W', net.minecraft.world.item.Items.WHEAT).define('E', net.minecraft.world.item.Items.EGG).define('S', net.minecraft.world.item.Items.SUGAR).define('M', net.minecraft.world.item.Items.MILK_BUCKET).unlockedBy(getHasName(net.minecraft.world.item.Items.WHEAT), has(net.minecraft.world.item.Items.WHEAT)).unlockedBy(getHasName(net.minecraft.world.item.Items.EGG), has(net.minecraft.world.item.Items.EGG)).unlockedBy(getHasName(net.minecraft.world.item.Items.SUGAR), has(net.minecraft.world.item.Items.SUGAR)).unlockedBy(getHasName(net.minecraft.world.item.Items.MILK_BUCKET), has(net.minecraft.world.item.Items.MILK_BUCKET)).save(output);
        shaped(RecipeCategory.FOOD, Items.PANCAKE_STACK, 1).pattern("PPP").pattern("PPP").pattern("PPP").define('P', Items.PANCAKE).unlockedBy(getHasName(Items.PANCAKE), has(Items.PANCAKE)).save(output);
        shaped(RecipeCategory.FOOD, Items.MAPLE_PANCAKE_STACK, 1).pattern("PPP").pattern("PPP").pattern("PPP").define('P', Items.MAPLE_PANCAKE).unlockedBy(getHasName(Items.MAPLE_PANCAKE), has(Items.MAPLE_PANCAKE)).save(output);
        shaped(RecipeCategory.FOOD, Items.CHOCOLATE_PANCAKE_STACK, 1).pattern("PPP").pattern("PPP").pattern("PPP").define('P', Items.CHOCOLATE_PANCAKE).unlockedBy(getHasName(Items.CHOCOLATE_PANCAKE), has(Items.CHOCOLATE_PANCAKE)).save(output);
        shapeless(RecipeCategory.FOOD, Items.MAPLE_PANCAKE, 1).requires(Items.PANCAKE).requires(Items.TAPPED_MAPLE_SAP_BUCKET).unlockedBy(getHasName(Items.PANCAKE), has(Items.PANCAKE)).unlockedBy(getHasName(Items.TAPPED_MAPLE_SAP_BUCKET), has(Items.TAPPED_MAPLE_SAP_BUCKET)).save(output);
        shapeless(RecipeCategory.FOOD, Items.CHOCOLATE_PANCAKE, 1).requires(Items.PANCAKE).requires(net.minecraft.world.item.Items.COCOA_BEANS).unlockedBy(getHasName(Items.PANCAKE), has(Items.PANCAKE)).unlockedBy(getHasName(net.minecraft.world.item.Items.COCOA_BEANS), has(net.minecraft.world.item.Items.COCOA_BEANS)).save(output);
        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.MAPLE_PLANKS, 4).requires(Blocks.MAPLE_LOG).unlockedBy(getHasName(Blocks.MAPLE_LOG), has(Blocks.MAPLE_LOG)).save(output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
            super(output, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new RecipeGen(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Better Biomes Recipes";
        }
    }
}
