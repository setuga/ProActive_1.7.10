package proactive;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

abstract class EntityProActiveBase extends EntityThrowable
{

    EntityProActiveBase(World world)
    {
        super(world);
    }

    EntityProActiveBase(World world, EntityLivingBase entityLivingBase)
    {
        super(world, entityLivingBase);
    }

    EntityProActiveBase(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    List<int[]> removableBlocks(World world, double min_d)
    {
        int minx = MathHelper.floor_double(this.posX) - 8;
        int maxy = 256;
        int minz = MathHelper.floor_double(this.posZ) - 8;
        int miny = MathHelper.floor_double(min_d);
        List list = new ArrayList();
        for (int x = minx; x < minx + 16; x++)
        {
            for (int y = miny; y < maxy; y++)
            {
                for (int z = minz; z < minz + 16; z++)
                {
                    if (world.blockExists(x, y, z))
                    {
                        Block block = world.getBlock(x, y, z);
                        if (block != null)
                        {
                            list.add(new int[]{x, y, z});
                        }
                    }
                }
            }
        }
        return list;
    }

    List<int[]> removableBlocks(World world)
    {
        return null;
    }

    @Override
    protected void onImpact(MovingObjectPosition movingobjectposition)
    {
        for (int j = 0; j < 8; j++)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        if (!this.worldObj.isRemote)
        {
            setDead();
            removeBlocks();
        }
    }

    private void removeBlocks()
    {
        EntityPlayerMP player = (EntityPlayerMP)getThrower();

        List<int[]> blocks = removableBlocks(this.worldObj);
        for (int[] pos : blocks)
        {
            int x = pos[0];
            int y = pos[1];
            int z = pos[2];
            Block block = worldObj.getBlock(x, y, z);
            if (block != null)
            {
                if (!player.theItemInWorldManager.tryHarvestBlock(x, y, z))
                {
                    this.worldObj.setBlockToAir(x, y, z);
                }
            }
        }
    }

}
