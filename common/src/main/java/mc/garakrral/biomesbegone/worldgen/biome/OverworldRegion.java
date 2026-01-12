package mc.garakrral.biomesbegone.worldgen.biome;

import java.util.function.Consumer;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

import com.mojang.datafixers.util.Pair;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class OverworldRegion extends Region {
    public OverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(net.minecraft.world.level.biome.Biomes.FOREST, Biomes.MAPLE_FOREST);
            modifiedVanillaOverworldBuilder.replaceBiome(net.minecraft.world.level.biome.Biomes.SAVANNA, Biomes.STEPPE);
            modifiedVanillaOverworldBuilder.replaceBiome(net.minecraft.world.level.biome.Biomes.TAIGA, Biomes.DENSE_SPRUCE_FOREST);
        });
    }
}