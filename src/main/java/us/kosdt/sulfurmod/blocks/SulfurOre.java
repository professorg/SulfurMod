package us.kosdt.sulfurmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class SulfurOre extends Block {

    public SulfurOre() {
        super(
                Properties.create(Material.ROCK)
                        .sound(SoundType.STONE)
                        .hardnessAndResistance(3.0f,0.4f)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(2)
        );
        setRegistryName("sulfur_ore");
    }

    @Override
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.0F, Explosion.Mode.BREAK);
    }
}
