package mc.garakrral.biomesbegone.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FireBlock;

public class FlammableBlocks {
    public static void registerFlammableBlocks() {

        flammableBlock(Blocks.MAPLE_LOG, 5, 5);
        flammableBlock(Blocks.MAPLE_WOOD, 5, 5);
        flammableBlock(Blocks.STRIPPED_MAPLE_LOG, 5, 5);
        flammableBlock(Blocks.STRIPPED_MAPLE_WOOD, 5, 5);

        flammableBlock(Blocks.MAPLE_LEAVES, 30, 60);
        flammableBlock(Blocks.MAPLE_PLANKS, 5, 20);
    }

    public static void flammableBlock(Block block, int burn, int spread) {
        FireBlock fireBlock = (FireBlock) net.minecraft.world.level.block.Blocks.FIRE;
        fireBlock.setFlammable(block, burn, spread);
    }
}
