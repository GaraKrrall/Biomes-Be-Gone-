package mc.garakrral.biomesbegone.item.group;

import com.google.common.collect.ImmutableList;
import mc.garakrral.biomesbegone.block.Blocks;
import mc.garakrral.biomesbegone.Main;
import mc.garakrral.biomesbegone.item.Items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.lang.reflect.Field;
import java.util.List;

public class ItemGroup {
    public static final List<Block> BLOCK_BLACKLIST = ImmutableList.of(
            Blocks.STANDING_MAPLE_SIGN,
            Blocks.HANGING_MAPLE_SIGN,
            Blocks.WALL_HANGING_MAPLE_SIGN,
            Blocks.WALL_MAPLE_SIGN,
            Blocks.TAPPED_BUCKET);

    public static final List<Item> ITEM_BLACKLIST = ImmutableList.of(
            Items.PANCAKE,
            Items.CHOCOLATE_PANCAKE,
            Items.MAPLE_PANCAKE,
            Items.CHOCOLATE_PANCAKE_STACK,
            Items.PANCAKE_STACK,
            Items.TAPPED_BUCKET,
            Items.TAPPED_MAPLE_SAP_BUCKET,
            Items.UNCURED_MAPLE_SYRUP,
            Items.MAPLE_PANCAKE_STACK
    );


    public static final CreativeModeTab BETTER_BIOMES_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Main.MOD_ID, "biomesbegone"),
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).icon(() -> new ItemStack(Blocks.MAPLE_PLANKS))
                    .title(Component.translatable("itemgroup.biomesbegone"))
                    .displayItems((displayContext, entries) -> {
                        for (Field field : Blocks.class.getFields()) {
                            try {
                                Block block = (Block) field.get(null);

                                if (block == null) {
                                    throw new IllegalStateException("Field " + field.getName() + " cannot be null");
                                }

                                if (!BLOCK_BLACKLIST.contains(block)) {
                                    entries.accept(new ItemStack(block));
                                }
                            } catch (IllegalAccessException ignored) {}
                        }
                        for (Field field : Items.class.getFields()) {
                            if (field.getType() != Item.class) continue;
                            try {
                                Item item = (Item) field.get(null);

                                if (item == null) {
                                    throw new IllegalStateException("Field " + field.getName() + " cannot be null");
                                }
                                if (!ITEM_BLACKLIST.contains(item)) {
                                    entries.accept(new ItemStack(item));
                                }
                            } catch (IllegalAccessException ignored) {}
                        }
                    }).build());


    public static void registerItemGroups() {
        Main.LOGGER.info("Registering Item Groups for " + Main.MOD_ID);
    }

    private static void registerItems() {

    }
}