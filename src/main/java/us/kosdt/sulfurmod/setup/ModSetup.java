package us.kosdt.sulfurmod.setup;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.NetherBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import us.kosdt.sulfurmod.blocks.ModBlocks;
import us.kosdt.sulfurmod.items.ModItems;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("sulfurmod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.SULFUR);
        }
    };

    public void init() {
        Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, NetherBiome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.SULFURORE.getDefaultState(), 14), Placement.COUNT_RANGE, new CountRangeConfig(16, 10, 20, 128)));
    }

}
