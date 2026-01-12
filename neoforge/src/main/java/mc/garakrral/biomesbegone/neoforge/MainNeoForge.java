package mc.garakrral.biomesbegone.neoforge;

import net.minecraft.core.registries.Registries;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.MainClient;
import mc.garakrral.biomesbegone.block.Blocks;
import mc.garakrral.biomesbegone.item.Items;
import mc.garakrral.biomesbegone.item.group.ItemGroup;
import mc.garakrral.biomesbegone.worldgen.biome.BiomeTerraBlenderAPI;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Main.MOD_ID)
public class MainNeoForge {

    public MainNeoForge(IEventBus eventBus) {
        eventBus.addListener(this::registry);
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);

        eventBus.addListener((EntityRenderersEvent.RegisterRenderers event) -> MainClient.registerEntityRenderers(event::registerEntityRenderer));
        eventBus.addListener((EntityRenderersEvent.RegisterLayerDefinitions event) -> MainClient.registerLayerDefinitions(event::registerLayerDefinition));

    }

    private void registry(RegisterEvent event) {
        event.register(Registries.BLOCK, handler -> Blocks.registerModBlocks());
        event.register(Registries.CREATIVE_MODE_TAB, handler -> ItemGroup.registerItemGroups());
        event.register(Registries.ITEM, handler -> Items.registerItems());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(BiomeTerraBlenderAPI::initTerrablender);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(MainClient::registerBlockLayers);
    }
}