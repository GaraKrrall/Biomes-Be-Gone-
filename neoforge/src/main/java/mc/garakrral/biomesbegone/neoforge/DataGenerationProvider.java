package mc.garakrral.biomesbegone.neoforge;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.neoforge.data.BlockTagGen;
import mc.garakrral.biomesbegone.neoforge.data.ItemTagGen;
import mc.garakrral.biomesbegone.neoforge.data.LootTableGen;
import mc.garakrral.biomesbegone.neoforge.data.ModelGen;
import mc.garakrral.biomesbegone.neoforge.data.RecipeGen;
import mc.garakrral.biomesbegone.worldgen.biome.Biomes;
import mc.garakrral.biomesbegone.worldgen.feature.ConfiguredFeatures;
import mc.garakrral.biomesbegone.worldgen.feature.PlacedFeatures;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Main.MOD_ID)
public class DataGenerationProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacedFeatures::bootstrap)
            .add(Registries.BIOME, Biomes::bootstrap);

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new DatapackBuiltinEntriesProvider(output, lookupProvider, BUILDER, Set.of(Main.MOD_ID)));

        generator.addProvider(true, new RecipeGen.Runner(output, lookupProvider));

        generator.addProvider(true, LootTableGen.create(output, lookupProvider));

        generator.addProvider(true, new BlockTagGen(output, lookupProvider));
        generator.addProvider(true, new ItemTagGen(output, lookupProvider));
        generator.addProvider(true, new ModelGen(output));
    }
}
