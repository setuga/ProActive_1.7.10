package proactive;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

import java.util.List;

public class EntityProActive extends EntityProActiveBase
{

    public EntityProActive(World world)
    {
        super(world);
    }

    public EntityProActive(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
    }

    public EntityProActive(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected List<int[]> removableBlocks(World world)
    {
        return super.removableBlocks(world, this.posY);
    }

}
