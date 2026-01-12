package mc.garakrral.biomesbegone.worldgen.biome;

import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.worldgen.biome.surface.BetterBiomesMaterialRules;
import net.minecraft.resources.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class BiomeTerraBlenderAPI {
    public static void initTerrablender() {
        Regions.register(new OverworldRegion(Identifier.fromNamespaceAndPath(Main.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD , Main.MOD_ID, BetterBiomesMaterialRules.makeRules());
    }
}
