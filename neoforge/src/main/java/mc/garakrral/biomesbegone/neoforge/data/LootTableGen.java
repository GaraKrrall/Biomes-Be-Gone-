package mc.garakrral.biomesbegone.neoforge.data;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.block.Blocks;
import mc.garakrral.biomesbegone.item.Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class LootTableGen extends BlockLootSubProvider {
    public LootTableGen(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        dropSelf(Blocks.MAPLE_SAPLING);
        dropSelf(Blocks.MAPLE_PLANKS);
        add(Blocks.MAPLE_LEAVES, createLeavesDrops(Blocks.MAPLE_LEAVES, Blocks.MAPLE_SAPLING, 0.0025f));
        dropSelf(Blocks.STRIPPED_MAPLE_LOG);
        dropSelf(Blocks.STRIPPED_MAPLE_WOOD);
        dropSelf(Blocks.MAPLE_LOG);
        dropSelf(Blocks.MAPLE_WOOD);
        dropOther(Blocks.TAPPED_BUCKET, Items.TAPPED_MAPLE_SAP_BUCKET);

        dropSelf(Blocks.MAPLE_STAIRS);
        dropSelf(Blocks.MAPLE_TRAPDOOR);
        dropSelf(Blocks.MAPLE_FENCE);
        dropSelf(Blocks.MAPLE_FENCE_GATE);
        dropSelf(Blocks.MAPLE_BUTTON);
        dropSelf(Blocks.MAPLE_PRESSURE_PLATE);
        dropSelf(Blocks.STANDING_MAPLE_SIGN);
        dropSelf(Blocks.WALL_MAPLE_SIGN);
        dropSelf(Blocks.HANGING_MAPLE_SIGN);
        dropSelf(Blocks.WALL_HANGING_MAPLE_SIGN);

        add(Blocks.MAPLE_SLAB, createSlabItemTable(Blocks.MAPLE_SLAB));
        add(Blocks.MAPLE_DOOR, createDoorTable(Blocks.MAPLE_DOOR));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.entrySet().stream().filter(e -> e.getKey().identifier().getNamespace().equals(Main.MOD_ID)).map(Map.Entry::getValue).toList();
    }

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(LootTableGen::new, LootContextParamSets.BLOCK)), provider);
    }
}
