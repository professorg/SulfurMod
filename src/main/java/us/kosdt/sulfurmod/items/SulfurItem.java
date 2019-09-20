package us.kosdt.sulfurmod.items;

import net.minecraft.item.Item;
import us.kosdt.sulfurmod.SulfurMod;

public class SulfurItem extends Item {

    public SulfurItem() {
        super(
                new Item.Properties()
                        .maxStackSize(64)
                        .group(SulfurMod.setup.itemGroup)
        );
        setRegistryName("sulfur");
    }
}
