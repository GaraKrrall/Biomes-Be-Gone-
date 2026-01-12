package mc.garakrral.biomesbegone.neoforge.data;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.block.Blocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ItemTagGen extends ItemTagsProvider {
    public ItemTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, Main.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(ItemTags.PLANKS)
                .add(Blocks.MAPLE_PLANKS.asItem());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(Blocks.MAPLE_LOG.asItem())
                .add(Blocks.MAPLE_WOOD.asItem())
                .add(Blocks.STRIPPED_MAPLE_LOG.asItem())
                .add(Blocks.STRIPPED_MAPLE_WOOD.asItem());
        tag(ItemTags.LEAVES)
                .add(Blocks.MAPLE_LEAVES.asItem());

    }
}
