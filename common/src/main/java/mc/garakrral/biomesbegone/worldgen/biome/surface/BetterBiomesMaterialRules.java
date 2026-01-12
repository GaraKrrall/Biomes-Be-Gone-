package mc.garakrral.biomesbegone.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

import mc.garakrral.biomesbegone.worldgen.biome.Biomes;

public class BetterBiomesMaterialRules {

    private static final SurfaceRules.RuleSource DIRT =
            makeStateRule(Blocks.DIRT);

    private static final SurfaceRules.RuleSource GRASS_BLOCK =
            makeStateRule(Blocks.GRASS_BLOCK);

    public static SurfaceRules.RuleSource makeRules() {

        SurfaceRules.ConditionSource isAtOrAboveWaterLevel =
                SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface =
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK),
                        DIRT
                );

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(
                                Biomes.MAPLE_FOREST,
                                Biomes.STEPPE,
                                Biomes.DENSE_SPRUCE_FOREST
                        ),
                        SurfaceRules.ifTrue(
                                SurfaceRules.ON_FLOOR,
                                grassSurface
                        )
                )
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
