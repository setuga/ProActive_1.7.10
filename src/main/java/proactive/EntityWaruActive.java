package proactive;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

import java.util.List;

public class EntityWaruActive extends EntityProActiveBase
{

    public EntityWaruActive(World world)
    {
        super(world);
    }

    public EntityWaruActive(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
    }

    public EntityWaruActive(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected List<int[]> removableBlocks(World world)
    {
        return super.removableBlocks(world, 0.0D);
    }

    @Override
    public void onUpdate()
    {
        if (this.rand.nextInt(2) == 0)
        {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        super.onUpdate();
    }

}
