package proactive;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

class ItemProActive extends Item
{

    ItemProActive()
    {
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("ProActive");
        setTextureName(ProActive.ID + ":" + "ProActive");
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int itemInUseCount)
    {
        if (!entityPlayer.capabilities.isCreativeMode)
        {
            itemStack.stackSize -= 1;
        }
        int j = getMaxItemUseDuration(itemStack) - itemInUseCount;
        float f = j / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f < 0.1F)
        {
            f = 0.1F;
        }
        if (f > 1.0F)
        {
            f = 1.0F;
        }
        world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (Item.itemRand.nextFloat() * 0.4F + 0.8F));
        if (!world.isRemote)
        {
            throwItem(world, entityPlayer, f);
        }
    }

    void throwItem(World world, EntityPlayer entityPlayer, float f)
    {
        EntityProActive proActive = new EntityProActive(world, entityPlayer);
        proActive.setThrowableHeading(proActive.motionX, proActive.motionY, proActive.motionZ, f * 2.0F, 1.0F);
        world.spawnEntityInWorld(proActive);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        entityPlayer.setItemInUse(itemStack, getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 72000;
    }

}
