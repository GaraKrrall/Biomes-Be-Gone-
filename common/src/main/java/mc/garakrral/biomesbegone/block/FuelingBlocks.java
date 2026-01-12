package mc.garakrral.biomesbegone.block;

import net.minecraft.world.level.block.entity.FuelValues;

public class FuelingBlocks {
    public static void registerFuelingBlocks(FuelValues.Builder registry) {
        registry.add(Blocks.MAPLE_LOG, 300);
        registry.add(Blocks.MAPLE_WOOD, 300);
        registry.add(Blocks.STRIPPED_MAPLE_LOG, 300);
        registry.add(Blocks.STRIPPED_MAPLE_WOOD, 300);
        registry.add(Blocks.MAPLE_PLANKS, 300);
        registry.add(Blocks.MAPLE_PRESSURE_PLATE, 300);
        registry.add(Blocks.MAPLE_FENCE,  300);
        registry.add(Blocks.MAPLE_FENCE_GATE, 300);
        registry.add(Blocks.MAPLE_STAIRS, 300);
        registry.add(Blocks.MAPLE_TRAPDOOR, 300);
        registry.add(Blocks.MAPLE_DOOR, 300);
        registry.add(Blocks.MAPLE_SLAB, 150);
        registry.add(Blocks.MAPLE_BUTTON, 100);
        registry.add(Blocks.STANDING_MAPLE_SIGN, 200);
        registry.add(Blocks.HANGING_MAPLE_SIGN, 200);
    }
}
