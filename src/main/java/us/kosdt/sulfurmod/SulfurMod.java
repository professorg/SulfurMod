package us.kosdt.sulfurmod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import us.kosdt.sulfurmod.blocks.ModBlocks;
import us.kosdt.sulfurmod.blocks.SulfurBlock;
import us.kosdt.sulfurmod.blocks.SulfurOre;
import us.kosdt.sulfurmod.items.SulfurItem;
import us.kosdt.sulfurmod.setup.ClientProxy;
import us.kosdt.sulfurmod.setup.IProxy;
import us.kosdt.sulfurmod.setup.ModSetup;
import us.kosdt.sulfurmod.setup.ServerProxy;

@Mod(SulfurMod.MODID)
public class SulfurMod {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "sulfurmod";

    public SulfurMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new SulfurBlock());
            event.getRegistry().register(new SulfurOre());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.SULFURBLOCK, properties).setRegistryName("sulfur_block"));
            ((FireBlock) Blocks.FIRE).setFireInfo(ModBlocks.SULFURBLOCK, 1000, 1000);
            event.getRegistry().register(new BlockItem(ModBlocks.SULFURORE, properties).setRegistryName("sulfur_ore"));
            event.getRegistry().register(new SulfurItem());
        }

    }
}
