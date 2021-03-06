package com.jacksonplayz.thinkingwithaperture.client.gui;

import com.jacksonplayz.thinkingwithaperture.tileentity.TileEntityTestChamberSign;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ThinkingWithApertureGuiHandler implements IGuiHandler
{
    public static final int TEST_CHAMBER_SIGN = 0;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (id == TEST_CHAMBER_SIGN && te instanceof TileEntityTestChamberSign)
            return new GuiTestChamberSign((TileEntityTestChamberSign) te);
        return null;
    }
}