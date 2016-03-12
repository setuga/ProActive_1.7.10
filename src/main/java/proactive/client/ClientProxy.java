package proactive.client;

import proactive.CommonProxy;
import proactive.EntityProActive;
import proactive.EntityWaruActive;
import proactive.ProActive;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class ClientProxy extends CommonProxy
{

    @Override
    public void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityProActive.class, new RenderSnowball(ProActive.proActive));
        RenderingRegistry.registerEntityRenderingHandler(EntityWaruActive.class, new RenderSnowball(ProActive.waruActive));
    }

}
