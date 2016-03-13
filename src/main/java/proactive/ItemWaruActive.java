package proactive;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

class ItemWaruActive extends ItemProActive
{

    ItemWaruActive()
    {
        setUnlocalizedName("WaruActive");
        setTextureName(ProActive.ID + ":" + "WaruActive");
    }

    @Override
    void throwItem(World world, EntityPlayer entityPlayer, float f)
    {
        EntityWaruActive waruActive = new EntityWaruActive(world, entityPlayer);
        waruActive.setThrowableHeading(waruActive.motionX, waruActive.motionY, waruActive.motionZ, f * 2.0F, 1.0F);
        world.spawnEntityInWorld(waruActive);
    }

}
