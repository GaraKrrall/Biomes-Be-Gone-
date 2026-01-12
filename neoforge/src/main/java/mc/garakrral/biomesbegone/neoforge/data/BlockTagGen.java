package mc.garakrral.biomesbegone.neoforge.data;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.block.Blocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class BlockTagGen extends BlockTagsProvider {
    public BlockTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, Main.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.LOGS)
                .add(Blocks.MAPLE_LOG)
                .add(Blocks.MAPLE_WOOD)
                .add(Blocks.STRIPPED_MAPLE_WOOD)
                .add(Blocks.STRIPPED_MAPLE_LOG);

        tag(BlockTags.LOGS_THAT_BURN)
                .add(Blocks.MAPLE_LOG)
                .add(Blocks.MAPLE_WOOD)
                .add(Blocks.STRIPPED_MAPLE_WOOD)
                .add(Blocks.STRIPPED_MAPLE_LOG);

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(Blocks.MAPLE_LEAVES);

        tag(BlockTags.LEAVES)
                .add(Blocks.MAPLE_LEAVES);

        tag(BlockTags.SAPLINGS)
                .add(Blocks.MAPLE_SAPLING);

        tag(BlockTags.FENCES)
                .add(Blocks.MAPLE_FENCE);

        tag(BlockTags.FENCE_GATES)
                .add(Blocks.MAPLE_FENCE_GATE);

        tag(BlockTags.PLANKS)
                .add(Blocks.MAPLE_PLANKS);
        tag(BlockTags.WOODEN_SLABS)
                .add(Blocks.MAPLE_SLAB);
        tag(BlockTags.WOODEN_STAIRS)
                .add(Blocks.MAPLE_STAIRS);
        tag(BlockTags.WOODEN_DOORS)
                .add(Blocks.MAPLE_DOOR);
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(Blocks.MAPLE_TRAPDOOR);
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(Blocks.MAPLE_PRESSURE_PLATE);
        tag(BlockTags.WOODEN_BUTTONS)
                .add(Blocks.MAPLE_BUTTON);
        tag(BlockTags.WOODEN_FENCES)
                .add(Blocks.MAPLE_FENCE)
                .add(Blocks.MAPLE_FENCE_GATE);
        tag(BlockTags.WALL_SIGNS)
                .add(Blocks.WALL_MAPLE_SIGN);
        tag(BlockTags.STANDING_SIGNS)
                .add(Blocks.STANDING_MAPLE_SIGN);
        tag(BlockTags.WALL_HANGING_SIGNS)
                .add(Blocks.WALL_HANGING_MAPLE_SIGN);
        tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(Blocks.HANGING_MAPLE_SIGN);
    }
}
