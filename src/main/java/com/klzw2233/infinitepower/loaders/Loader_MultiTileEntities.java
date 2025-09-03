package com.klzw2233.infinitepower.loaders;

import static gregapi.data.CS.*;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import com.klzw2233.infinitepower.tileentity.TileInfinitePower;

import gregapi.block.MaterialMachines;
import gregapi.block.multitileentity.MultiTileEntityBlock;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.*;
import gregapi.util.UT;

public class Loader_MultiTileEntities implements Runnable {

    // 外壳方块引用（实际项目中应在初始化时用 MultiTileEntityBlock.getOrCreate 创建）
    MultiTileEntityBlock aMachine = MultiTileEntityBlock.getOrCreate(
        MD.GT.mID,
        "machine",
        MaterialMachines.instance,
        Block.soundTypeMetal,
        TOOL_wrench,
        0,
        0,
        15,
        F,
        F);

    @Override
    public void run() {
        // 获取或创建注册表（命名空间建议用你的modid）
        MultiTileEntityRegistry aRegistry = MultiTileEntityRegistry.getRegistry("ip.multitileentity");

        // 调用注册方法
        registerDynamos(aRegistry, aMachine);
    }

    /**
     * 注册发电机类机器
     */
    private static void registerDynamos(MultiTileEntityRegistry aRegistry, MultiTileEntityBlock aMachine) {
        Class<? extends TileEntity> aClass;
        aClass = TileInfinitePower.class;

        // 这里用 LV 材质作为示例
        var aMat = MT.DATA.Electric_T[1];

        aRegistry.add(
            "Infinite Power Dynamo (" + VN[1] + ")", // 显示名称
            "Dynamos", // 分类
            101,
            101, // 图标索引
            aClass, // TileEntity 类
            aMat.mToolQuality, // 工具等级
            16, // 最大堆叠
            aMachine, // 外壳方块
            UT.NBT.make( // NBT 属性
                NBT_MATERIAL,
                aMat,
                NBT_HARDNESS,
                4.0F,
                NBT_RESISTANCE,
                4.0F,
                NBT_INPUT,
                32,
                NBT_OUTPUT,
                32768,
                NBT_WASTE_ENERGY,
                T,
                NBT_ENERGY_ACCEPTED,
                TD.Energy.RU,
                NBT_ENERGY_EMITTED,
                TD.Energy.EU),
            // 合成表
            "TGT",
            "CMC",
            "TId",
            'M',
            OP.casingMachineDouble.dat(aMat),
            'T',
            OP.screw.dat(aMat),
            'G',
            OP.gearGt.dat(aMat),
            'I',
            OP.stickLong.dat(MT.IronMagnetic),
            'C',
            OP.wireGt01.dat(ANY.Cu));
    }
}
