package mc.garakrral.biomesbegone.worldgen.feature;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.block.Blocks;

public class PlacedFeatures {

    public static final ResourceKey<PlacedFeature> BASIC_TREE_PLACED =
            registerKey("basic_tree");
    public static final ResourceKey<PlacedFeature> DENSE_GRASS_PLACED =
            registerKey("dense_grass");
    public static final ResourceKey<PlacedFeature> ROCK_PATCH_PLACED =
            registerKey("rock_patch");
    public static final ResourceKey<PlacedFeature> DENSE_GRASS_2_PLACED =
            registerKey("dense_grass_2");
    public static final ResourceKey<PlacedFeature> FIREFLY_BUSH_PLACED =
            registerKey("firefly_bush");
    public static final ResourceKey<PlacedFeature> BASIC_TREE_2_PLACED =
            registerKey("basic_tree_2");
    public static final ResourceKey<PlacedFeature> BIG_SPRUCE_PLACED =
            registerKey("big_spruce");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        //basic tree
        register(context, BASIC_TREE_PLACED, configuredFeatureHolderGetter.getOrThrow(ConfiguredFeatures.BASIC_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.25f, 1)
                        , (Blocks.MAPLE_SAPLING)));

        //a lot of grass
        context.register(
                DENSE_GRASS_PLACED,
                new PlacedFeature(
                        configuredFeatureHolderGetter.getOrThrow(ConfiguredFeatures.DENSE_GRASS),
                        List.of(
                                CountPlacement.of(26),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );

        //rock
        context.register(
                ROCK_PATCH_PLACED,
                new PlacedFeature(
                        configuredFeatureHolderGetter.getOrThrow(ConfiguredFeatures.ROCK_PATCH),
                        List.of(
                                RarityFilter.onAverageOnceEvery(20),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );

        //a lot of grass
        context.register(
                DENSE_GRASS_2_PLACED,
                new PlacedFeature(
                        configuredFeatureHolderGetter.getOrThrow(ConfiguredFeatures.DENSE_GRASS),
                        List.of(
                                CountPlacement.of(26),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );

        context.register(
                FIREFLY_BUSH_PLACED,
                new PlacedFeature(
                        configuredFeatureHolderGetter.getOrThrow(ConfiguredFeatures.FIREFLY_BUSH),
                        List.of(
                                RarityFilter.onAverageOnceEvery(20),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );

        //basic tree
        register(context,
                BASIC_TREE_2_PLACED,
                configuredFeatureHolderGetter.getOrThrow(ConfiguredFeatures.BASIC_TREE),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(0, 0.2f, 1)
                        ,(Blocks.MAPLE_SAPLING)
                ));

        //big spruce
        register(context,
                BIG_SPRUCE_PLACED,
                configuredFeatureHolderGetter.getOrThrow(ConfiguredFeatures.BIG_SPRUCE),
                List.of(
                        CountPlacement.of(7), // SIKLIK (6–8 ideal)
                        InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.wouldSurvive(Blocks.MAPLE_DOOR.defaultBlockState(), BlockPos.ZERO)
                        )
                )
        );
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Main.MOD_ID, name));
    }


    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
