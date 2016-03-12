package proactive;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = ProActive.ID, name = ProActive.NAME)
public class ProActive
{

    static final String ID = "proactive";
    static final String NAME = "ProActive";

    @SidedProxy(clientSide=ID + ".client.ClientProxy", serverSide=ID + ".CommonProxy")
    private static CommonProxy proxy;

    public static Item proActive = new ItemProActive();
    public static Item waruActive = new ItemWaruActive();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        event.getModMetadata().version = event.getVersionProperties().getProperty(ID + ".version");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        GameRegistry.registerItem(proActive, "proActive");
        GameRegistry.registerItem(waruActive, "waruActive");

        EntityRegistry.registerModEntity(EntityProActive.class, "ProActive", 0, this, 80, 3, true);
        EntityRegistry.registerModEntity(EntityWaruActive.class, "WaruActive", 1, this, 80, 3, true);

        GameRegistry.addRecipe(new ItemStack(proActive, 1),
                "LM",
                'L', Items.leather, 'M', Items.milk_bucket);
        GameRegistry.addRecipe(new ItemStack(waruActive, 1),
                "GGG",
                "GPG",
                "GGG",
                'G', Items.gunpowder, 'P', proActive);

        proxy.registerRenderers();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

}