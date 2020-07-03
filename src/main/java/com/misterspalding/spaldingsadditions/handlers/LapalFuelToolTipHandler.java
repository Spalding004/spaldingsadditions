package com.misterspalding.spaldingsadditions.handlers;

import com.misterspalding.spaldingsadditions.fuels.LapalFuels;
import com.misterspalding.spaldingsadditions.utils.TextUtils;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class LapalFuelToolTipHandler {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void addToolTips(ItemTooltipEvent event) {
        ItemStack item = event.getItemStack();
        int str = 0;
        ITextComponent tip = new TranslationTextComponent("+").applyTextStyle(TextFormatting.AQUA);
        if (LapalFuels.getFuelStr(item) > 0) {

            if (Screen.hasShiftDown()) {
                str = (int) LapalFuels.getFuelStr(item);
                tip = TextUtils.toolTipWithValue(str, "lapal_fuel").applyTextStyles(TextFormatting.AQUA);
               
            } 
            event.getToolTip().add(tip);
        }
    }
}