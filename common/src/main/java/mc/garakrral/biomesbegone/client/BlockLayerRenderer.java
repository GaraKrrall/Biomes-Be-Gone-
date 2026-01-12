package mc.garakrral.biomesbegone.client;

import com.google.common.collect.Maps;
import mc.garakrral.biomesbegone.block.Blocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.level.block.Block;

public class BlockLayerRenderer {
    public static void renderLayerClient() {
        registerRenderLayer(Blocks.MAPLE_LEAVES, ChunkSectionLayer.CUTOUT);
        registerRenderLayer(Blocks.MAPLE_SAPLING, ChunkSectionLayer.CUTOUT);
        registerRenderLayer(Blocks.MAPLE_TRAPDOOR, ChunkSectionLayer.CUTOUT);
        registerRenderLayer(Blocks.MAPLE_DOOR, ChunkSectionLayer.CUTOUT);
        registerRenderLayer(Blocks.TAPPED_BUCKET, ChunkSectionLayer.CUTOUT);
    }

    public static void registerRenderLayer(Block block, ChunkSectionLayer type) {
        ItemBlockRenderTypes.TYPE_BY_BLOCK = Maps.newHashMap(ItemBlockRenderTypes.TYPE_BY_BLOCK);
        ItemBlockRenderTypes.TYPE_BY_BLOCK.put(block, type);
    }
}
