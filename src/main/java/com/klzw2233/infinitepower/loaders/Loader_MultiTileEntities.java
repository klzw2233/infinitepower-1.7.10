package com.klzw2233.infinitepower.loaders;

import static gregapi.data.CS.*;

import gregapi.block.MaterialScoopable;
import gregapi.oredict.OreDictMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

import com.klzw2233.infinitepower.tileentity.TileInfinitePower;
import com.klzw2233.infinitepower.core.ModConstants;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.*;
import gregapi.util.UT;

public class Loader_MultiTileEntities implements Runnable {

    @Override
    public void run() {
        MultiTileEntityRegistry aRegistry = MultiTileEntityRegistry.getRegistry("ip.multitileentity");

        MultiTileEntityBlock
            aMetal      = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "iron"         , Material.iron             , Block.soundTypeMetal, TOOL_pickaxe, 0, 0, 15, F, F)
        , aMetalChips = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "iron"         , Material.iron             , Block.soundTypeMetal, TOOL_shovel , 0, 0, 15, F, F)
        , aMetalWires = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "machine"      , MaterialMachines.instance , Block.soundTypeMetal, TOOL_cutter , 0, 0, 15, F, F)
        , aMachine    = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "machine"      , MaterialMachines.instance , Block.soundTypeMetal, TOOL_wrench , 0, 0, 15, F, F)
        , aWooden     = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "wood"         , Material.wood             , Block.soundTypeWood , TOOL_axe    , 0, 0, 15, F, F)
        , aBush       = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "leaves"       , Material.leaves           , Block.soundTypeGrass, TOOL_axe    , 0, 0, 15, F, F)
        , aStone      = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "rock"         , Material.rock             , Block.soundTypeStone, TOOL_pickaxe, 0, 0, 15, F, F)
        , aWool       = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "cloth"        , Material.cloth            , Block.soundTypeCloth, TOOL_shears , 0, 0, 15, F, F)
        , aTNT        = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "tnt"          , Material.tnt              , Block.soundTypeGrass, TOOL_pickaxe, 0, 0, 15, F, F)
        , aUtilMetal  = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight    , Block.soundTypeMetal, TOOL_pickaxe, 0, 0, 15, F, F)
        , aUtilStone  = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight    , Block.soundTypeStone, TOOL_pickaxe, 0, 0, 15, F, F)
        , aUtilWood   = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight    , Block.soundTypeWood , TOOL_axe    , 0, 0, 15, F, F)
        , aUtilWool   = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "redstoneLight", Material.redstoneLight    , Block.soundTypeCloth, TOOL_shears , 0, 0, 15, F, F)
        , aHive       = MultiTileEntityBlock.getOrCreate(MD.GT.mID, "rock"         , MaterialScoopable.instance, Block.soundTypeWood , TOOL_scoop  , 0, 0, 15, F, F)
        ;

        registerDynamos(aRegistry, aMetal, aMetalChips, aMetalWires, aMachine, aWooden, aBush, aStone, aWool, aTNT, aHive, aUtilMetal, aUtilStone, aUtilWood, aUtilWool, MT.NULL, null);

    }

    /**
     * 注册发电机类机器
     * Dynamos
     */
    private static void registerDynamos(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMetal, MultiTileEntityBlock aMetalChips, MultiTileEntityBlock aMetalWires, MultiTileEntityBlock aMachine, MultiTileEntityBlock aWooden, MultiTileEntityBlock aBush, MultiTileEntityBlock aStone, MultiTileEntityBlock aWool, MultiTileEntityBlock aTNT, MultiTileEntityBlock aHive, MultiTileEntityBlock aUtilMetal, MultiTileEntityBlock aUtilStone, MultiTileEntityBlock aUtilWood, MultiTileEntityBlock aUtilWool, OreDictMaterial aMat, Class<? extends TileEntity> aClass) {

        aClass = TileInfinitePower.class;
        aMat = MT.DATA.Electric_T[0];  aRegistry.add("Infinite Power ("+VN[0]+")", "Dynamos", 11450, 11450, aClass, aMat.mToolQuality, 16, aMachine, UT.NBT.make(NBT_MATERIAL, aMat, NBT_HARDNESS,   4.0F, NBT_RESISTANCE,   4.0F, NBT_INPUT,   ModConstants.MInput[0], NBT_OUTPUT,   ModConstants.MOutput[0], NBT_WASTE_ENERGY, T, NBT_ENERGY_ACCEPTED, TD.Energy.RU, NBT_ENERGY_EMITTED, TD.Energy.EU), "TGT", "CMC", "TId", 'M', OP.casingMachineDouble.dat(aMat), 'T', OP.screw.dat(aMat), 'G', OP.gearGt.dat(aMat), 'I', OP.stickLong.dat(MT.IronMagnetic), 'C', OP.wireGt01.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[1];  aRegistry.add("Infinite Power ("+VN[1]+")", "Dynamos", 11451, 11451, aClass, aMat.mToolQuality, 16, aMachine, UT.NBT.make(NBT_MATERIAL, aMat, NBT_HARDNESS,   4.0F, NBT_RESISTANCE,   4.0F, NBT_INPUT,   ModConstants.MInput[1], NBT_OUTPUT,   ModConstants.MOutput[1], NBT_WASTE_ENERGY, T, NBT_ENERGY_ACCEPTED, TD.Energy.RU, NBT_ENERGY_EMITTED, TD.Energy.EU), "TGT", "CMC", "TId", 'M', OP.casingMachineDouble.dat(aMat), 'T', OP.screw.dat(aMat), 'G', OP.gearGt.dat(aMat), 'I', OP.stickLong.dat(MT.IronMagnetic), 'C', OP.wireGt01.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[2];  aRegistry.add("Infinite Power ("+VN[2]+")", "Dynamos", 11452, 11452, aClass, aMat.mToolQuality, 16, aMachine, UT.NBT.make(NBT_MATERIAL, aMat, NBT_HARDNESS,   4.0F, NBT_RESISTANCE,   4.0F, NBT_INPUT,   ModConstants.MInput[2], NBT_OUTPUT,   ModConstants.MOutput[2], NBT_WASTE_ENERGY, T, NBT_ENERGY_ACCEPTED, TD.Energy.RU, NBT_ENERGY_EMITTED, TD.Energy.EU), "TGT", "CMC", "TId", 'M', OP.casingMachineDouble.dat(aMat), 'T', OP.screw.dat(aMat), 'G', OP.gearGt.dat(aMat), 'I', OP.stickLong.dat(MT.IronMagnetic), 'C', OP.wireGt01.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[3];  aRegistry.add("Infinite Power ("+VN[3]+")", "Dynamos", 11453, 11453, aClass, aMat.mToolQuality, 16, aMachine, UT.NBT.make(NBT_MATERIAL, aMat, NBT_HARDNESS,   4.0F, NBT_RESISTANCE,   4.0F, NBT_INPUT,   ModConstants.MInput[3], NBT_OUTPUT,   ModConstants.MOutput[3], NBT_WASTE_ENERGY, T, NBT_ENERGY_ACCEPTED, TD.Energy.RU, NBT_ENERGY_EMITTED, TD.Energy.EU), "TGT", "CMC", "TId", 'M', OP.casingMachineDouble.dat(aMat), 'T', OP.screw.dat(aMat), 'G', OP.gearGt.dat(aMat), 'I', OP.stickLong.dat(MT.IronMagnetic), 'C', OP.wireGt01.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[4];  aRegistry.add("Infinite Power ("+VN[4]+")", "Dynamos", 11454, 11454, aClass, aMat.mToolQuality, 16, aMachine, UT.NBT.make(NBT_MATERIAL, aMat, NBT_HARDNESS,   4.0F, NBT_RESISTANCE,   4.0F, NBT_INPUT,   ModConstants.MInput[4], NBT_OUTPUT,   ModConstants.MOutput[4], NBT_WASTE_ENERGY, T, NBT_ENERGY_ACCEPTED, TD.Energy.RU, NBT_ENERGY_EMITTED, TD.Energy.EU), "TGT", "CMC", "TId", 'M', OP.casingMachineDouble.dat(aMat), 'T', OP.screw.dat(aMat), 'G', OP.gearGt.dat(aMat), 'I', OP.stickLong.dat(MT.IronMagnetic), 'C', OP.wireGt01.dat(ANY.Cu));
        aMat = MT.DATA.Electric_T[5];  aRegistry.add("Infinite Power ("+VN[5]+")", "Dynamos", 11455, 11455, aClass, aMat.mToolQuality, 16, aMachine, UT.NBT.make(NBT_MATERIAL, aMat, NBT_HARDNESS,   4.0F, NBT_RESISTANCE,   4.0F, NBT_INPUT,   ModConstants.MInput[5], NBT_OUTPUT,   ModConstants.MOutput[5], NBT_WASTE_ENERGY, T, NBT_ENERGY_ACCEPTED, TD.Energy.RU, NBT_ENERGY_EMITTED, TD.Energy.EU), "TGT", "CMC", "TId", 'M', OP.casingMachineDouble.dat(aMat), 'T', OP.screw.dat(aMat), 'G', OP.gearGt.dat(aMat), 'I', OP.stickLong.dat(MT.IronMagnetic), 'C', OP.wireGt01.dat(ANY.Cu));
    }
}
