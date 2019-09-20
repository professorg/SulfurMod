package us.kosdt.sulfurmod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SulfurBlock extends Block {

    public SulfurBlock() {
        super(
                Properties.create(Material.SAND)
                        .sound(SoundType.SAND)
                        .hardnessAndResistance(0.5f, 2.5f)
                        .harvestTool(ToolType.SHOVEL)
                        .harvestLevel(0)
                        .tickRandomly()
        );
        setRegistryName("sulfur_block");
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        Item playerHeldItem = player.getHeldItem(handIn).getItem();
        if (playerHeldItem == Items.FLINT_AND_STEEL || playerHeldItem == Items.FIRE_CHARGE) {
            burn(worldIn, pos);
        }
        return false;
    }

    public void burn(World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState(), 4);
        for (Direction face : Direction.values()) {
            BlockPos newPos = pos.add(face.getDirectionVec());
            if (worldIn.getBlockState(newPos).getBlock() == ModBlocks.SULFURBLOCK) {
                burn(worldIn, newPos);
            }
        }
    }


}
