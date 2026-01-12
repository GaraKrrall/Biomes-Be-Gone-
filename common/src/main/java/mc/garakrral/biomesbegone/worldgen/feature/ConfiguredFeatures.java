package mc.garakrral.biomesbegone.worldgen.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import mc.garakrral.biomesbegone.Main;


public class ConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BASIC_TREE =
            registerKey("basic_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DENSE_GRASS =
            registerKey("dense_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>>  ROCK_PATCH =
            registerKey("rock_patch");
    public static final ResourceKey<ConfiguredFeature<?,?>> DENSE_GRASS_2 =
            registerKey("dense_grass_2");
    public static final ResourceKey<ConfiguredFeature<?,?>> FIREFLY_BUSH =
            registerKey("firefly_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BASIC_TREE_2 =
            registerKey("basic_tree_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_SPRUCE =
            registerKey("big_spruce");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        //basic tree
        register(context, BASIC_TREE, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(2, 1, 0),
                        BlockStateProvider.simple(Blocks.OAK_LEAVES),
                        new BlobFoliagePlacer(
                                ConstantInt.of(2),
                                ConstantInt.of(0),
                                2
                        ),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build()
        );

        //a lot of grass
        context.register(
                DENSE_GRASS,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(
                                96, // tries
                                7,  // xz spread
                                3,  // y spread
                                PlacementUtils.onlyWhenEmpty(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                new WeightedStateProvider(
                                                        WeightedList.<BlockState>builder()
                                                                .add(Blocks.SHORT_GRASS.defaultBlockState(), 8)
                                                                .add(Blocks.TALL_GRASS.defaultBlockState(), 2)
                                                                .add(Blocks.BUSH.defaultBlockState(), 1)
                                                                .build()
                                                )
                                        )
                                )
                        )
                )
        );

        context.register(
                ROCK_PATCH,
                new ConfiguredFeature<>(
                        Feature.FOREST_ROCK,
                        new BlockStateConfiguration(
                                Blocks.ANDESITE.defaultBlockState()
                        )
                )
        );

        //a lot of grass
        context.register(
                DENSE_GRASS_2,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(
                                96, // tries
                                7,  // xz spread
                                3,  // y spread
                                PlacementUtils.onlyWhenEmpty(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                new WeightedStateProvider(
                                                        WeightedList.<BlockState>builder()
                                                                .add(Blocks.SHORT_GRASS.defaultBlockState(), 9)
                                                                .add(Blocks.TALL_GRASS.defaultBlockState(), 4)
                                                                .add(Blocks.LARGE_FERN.defaultBlockState(), 2)
                                                                .build()
                                                )
                                        )
                                )
                        )
                )
        );

        context.register(
                FIREFLY_BUSH,
                new ConfiguredFeature<>(
                        Feature.RANDOM_PATCH,
                        new RandomPatchConfiguration(
                                6,
                                3,
                                2,
                                PlacementUtils.onlyWhenEmpty(
                                        Feature.SIMPLE_BLOCK,
                                        new SimpleBlockConfiguration(
                                                new WeightedStateProvider(
                                                        WeightedList.<BlockState>builder()
                                                                .add(Blocks.LARGE_FERN.defaultBlockState(), 100)
                                                                .build()
                                                )
                                        )
                                )
                        )
                )
        );

        //basic tree
        register(context, BASIC_TREE_2, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(2, 2, 0),
                        BlockStateProvider.simple(Blocks.OAK_LEAVES),
                        new BlobFoliagePlacer(
                                ConstantInt.of(2),
                                ConstantInt.of(0),
                                2
                        ),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).ignoreVines().build()
        );

        register(context,
                BIG_SPRUCE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(

                        BlockStateProvider.simple(Blocks.SPRUCE_LOG),
                        new GiantTrunkPlacer(

                                10, // base height
                                2,  // height rand A
                                1   // height rand B
                        ),

                        BlockStateProvider.simple(Blocks.SPRUCE_LEAVES),

                        new SpruceFoliagePlacer(
                                ConstantInt.of(3), // radius
                                ConstantInt.of(2), // offset
                                ConstantInt.of(8)  // trunk height before foliage
                        ),

                        new TwoLayersFeatureSize(
                                2,  // lower size
                                0,
                                2
                        )
                )
                        .ignoreVines()
                        .build()
        );


    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Main.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
