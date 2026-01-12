package mc.garakrral.biomesbegone.worldgen.tree;

import mc.garakrral.biomesbegone.worldgen.feature.ConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class SaplingGen {
    public static final TreeGrower MAPLE =
            new TreeGrower("maple", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ConfiguredFeatures.BASIC_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());

}