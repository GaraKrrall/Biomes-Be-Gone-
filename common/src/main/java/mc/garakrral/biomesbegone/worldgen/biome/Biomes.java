package mc.garakrral.biomesbegone.worldgen.biome;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.worldgen.feature.PlacedFeatures;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.attribute.AmbientSounds;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Biomes {
    public static final ResourceKey<Biome> MAPLE_FOREST =
            createKey("drywood_uplands");
    public static final ResourceKey<Biome> STEPPE =
            createKey("steppe");
    public static final ResourceKey<Biome> DENSE_SPRUCE_FOREST =
            createKey("dense_spruce_forest");

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(MAPLE_FOREST, mapleForest(context));
        context.register(STEPPE, steppe(context));
        context.register(DENSE_SPRUCE_FOREST, denseSpruceForest(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome denseSpruceForest(BootstrapContext<Biome> ctx) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, 4, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(ctx.lookup(Registries.PLACED_FEATURE),
                        ctx.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.DENSE_GRASS_2_PLACED
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.BIG_SPRUCE_PLACED
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.ROCK_PATCH_PLACED
        );

        return buildBiome(
                biomeBuilder.build(),
                spawnBuilder.build(),
                true,
                0.25f,
                0.8f,
                0x3F5D3B,
                0x2E4F2C,
                0x2F4E67
        );
    }

    public static Biome steppe(BootstrapContext<Biome> ctx) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, 4, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(ctx.lookup(Registries.PLACED_FEATURE),
                        ctx.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.DENSE_GRASS_2_PLACED
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.BASIC_TREE_2_PLACED
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.FIREFLY_BUSH_PLACED
        );

        return buildBiome(
                biomeBuilder.build(),
                spawnBuilder.build(),
                true,
                0.82f,
                0.06f,
                0xD6C45A,
                0xA5A45B,
                0x3F76E4
        );
    }

    public static Biome mapleForest(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, 4, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        //we need a lot of grass
        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.DENSE_GRASS_PLACED
        );

        //rock
        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.ROCK_PATCH_PLACED
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                VegetationPlacements.PATCH_GRASS_FOREST
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                VegetationPlacements.PATCH_TALL_GRASS
        );

        biomeBuilder.addFeature(
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacedFeatures.BASIC_TREE_PLACED
        );

        return buildBiome(
                biomeBuilder.build(),
                spawnBuilder.build(),
                true,
                0.9f,
                0.0f,
                0x9FB36A,
                0x7FA35A,
                4159204
        );
    }

    private static Biome buildBiome(
            BiomeGenerationSettings generationSettings, MobSpawnSettings mobSpawnSettings,
            boolean precipitation, float temp, float downfall, @Nullable Integer grassColor, @NotNull Integer foliageColorOverride, @NotNull Integer waterColor
    ) {
        BiomeSpecialEffects.Builder specialEffects = new BiomeSpecialEffects.Builder()
                .waterColor(waterColor)
                .foliageColorOverride(foliageColorOverride)
                .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                .grassColorOverride(grassColor);

        if (grassColor != null) {
            specialEffects.grassColorOverride(grassColor);
        }

        return new Biome.BiomeBuilder()
                .hasPrecipitation(precipitation).temperature(temp)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 329011)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 12638463)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, skyColorCalc(temp))
                .setAttribute(EnvironmentAttributes.AMBIENT_SOUNDS, AmbientSounds.LEGACY_CAVE_SETTINGS)
                .downfall(downfall).specialEffects(specialEffects.build())
                .mobSpawnSettings(mobSpawnSettings).generationSettings(generationSettings)
                .build();
    }

    private static int skyColorCalc(float temp) {
        float f = temp / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    private static ResourceKey<Biome> createKey(String key) {
        return ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Main.MOD_ID, key));
    }
}