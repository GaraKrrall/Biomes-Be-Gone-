package mc.garakrral.biomesbegone.block;

import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;

public class StrippableBlocks {
    public static void addStrippableBlocks() {
        registerStrippable(Blocks.MAPLE_LOG, Blocks.STRIPPED_MAPLE_LOG);
        registerStrippable(Blocks.MAPLE_WOOD, Blocks.STRIPPED_MAPLE_WOOD);
    }
    public static void registerStrippable(Block log, Block strippedLog) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(log, strippedLog);
    }
}
