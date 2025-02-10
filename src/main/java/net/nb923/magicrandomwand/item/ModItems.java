package net.nb923.magicrandomwand.item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.nb923.magicrandomwand.MagicRandomWand;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MagicRandomWand.MOD_ID);

    public static final RegistryObject<Item> MAGICWAND = ITEMS.register("magic_wand",
            () -> new MagicRandomWandItem(new Item.Properties().durability(32)));



    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
