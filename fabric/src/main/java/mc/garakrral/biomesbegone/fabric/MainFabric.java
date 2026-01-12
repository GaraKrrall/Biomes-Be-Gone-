package mc.garakrral.biomesbegone.fabric;

import mc.garakrral.biomesbegone.MainClient;
import mc.garakrral.biomesbegone.block.Blocks;
import mc.garakrral.biomesbegone.block.FlammableBlocks;
import mc.garakrral.biomesbegone.block.StrippableBlocks;
import mc.garakrral.biomesbegone.item.group.ItemGroup;
import mc.garakrral.biomesbegone.item.Items;
import mc.garakrral.biomesbegone.worldgen.biome.BiomeTerraBlenderAPI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import terrablender.api.TerraBlenderApi;

public class MainFabric implements ClientModInitializer, ModInitializer, TerraBlenderApi {
    
    @Override
    public void onInitialize() {
        ItemGroup.registerItemGroups();
        Blocks.registerModBlocks();
        Items.registerItems();
        FlammableBlocks.registerFlammableBlocks();
        StrippableBlocks.addStrippableBlocks();
    }

    @Override
    public void onInitializeClient() {
        MainClient.registerBlockLayers();
        MainClient.registerEntityRenderers(EntityRendererRegistry::register);
        MainClient.registerLayerDefinitions((a, b) -> EntityModelLayerRegistry.registerModelLayer(a, b::get));
    }

    @Override
    public void onTerraBlenderInitialized() {
        BiomeTerraBlenderAPI.initTerrablender();
    }
}
