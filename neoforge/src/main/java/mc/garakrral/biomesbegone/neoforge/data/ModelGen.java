package mc.garakrral.biomesbegone.neoforge.data;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.block.Blocks;
import mc.garakrral.biomesbegone.item.Items;
import mc.garakrral.biomesbegone.util.BiomeBlockFamilies;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModelGen extends ModelProvider {
    public ModelGen(PackOutput output) {
        super(output, Main.MOD_ID);
    }

    @Override
    public void registerModels(BlockModelGenerators blockStateModelGenerator, ItemModelGenerators itemModelGenerator) {
        blockStateModelGenerator.woodProvider(Blocks.MAPLE_LOG).log(Blocks.MAPLE_LOG).wood(Blocks.MAPLE_WOOD);
        blockStateModelGenerator.woodProvider(Blocks.STRIPPED_MAPLE_LOG).log(Blocks.STRIPPED_MAPLE_LOG).wood(Blocks.STRIPPED_MAPLE_WOOD);
        blockStateModelGenerator.createTrivialCube(Blocks.MAPLE_LEAVES);
        blockStateModelGenerator.createCrossBlock(Blocks.MAPLE_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        BlockModelGenerators.BlockFamilyProvider maple_pool = blockStateModelGenerator.family(Blocks.MAPLE_PLANKS);
        maple_pool.generateFor(BiomeBlockFamilies.MAPLE_SIGN);
        maple_pool.generateFor(BiomeBlockFamilies.MAPLE_HANGING_SIGN);

        maple_pool.slab(Blocks.MAPLE_SLAB);
        maple_pool.stairs(Blocks.MAPLE_STAIRS);
        maple_pool.fence(Blocks.MAPLE_FENCE);
        maple_pool.fenceGate(Blocks.MAPLE_FENCE_GATE);
        maple_pool.button(Blocks.MAPLE_BUTTON);
        maple_pool.pressurePlate(Blocks.MAPLE_PRESSURE_PLATE);

        blockStateModelGenerator.createDoor(Blocks.MAPLE_DOOR);
        blockStateModelGenerator.createTrapdoor(Blocks.MAPLE_TRAPDOOR);

        itemModelGenerator.generateFlatItem(Items.MAPLE_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.MAPLE_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.TAPPED_BUCKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.TAPPED_MAPLE_SAP_BUCKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.UNCURED_MAPLE_SYRUP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.PANCAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.MAPLE_PANCAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.CHOCOLATE_PANCAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.PANCAKE_STACK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.MAPLE_PANCAKE_STACK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(Items.CHOCOLATE_PANCAKE_STACK, ModelTemplates.FLAT_ITEM);
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        List<Block> excluded = List.of(Blocks.TAPPED_BUCKET);

        return super.getKnownBlocks().filter(entry -> !excluded.contains(entry.value()));
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        List<Item> excluded = new ArrayList<>();

        return super.getKnownItems();
    }
}
