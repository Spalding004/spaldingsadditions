package com.misterspalding.spaldingsadditions.client.gui;

import java.awt.Color;
import java.awt.Rectangle;

import com.misterspalding.spaldingsadditions.client.gui.widget.FuelBar;
import com.misterspalding.spaldingsadditions.containers.FabricatorContainer;
import com.misterspalding.spaldingsadditions.objects.items.ModDimensionalCard;
import com.misterspalding.spaldingsadditions.utils.TextUtils;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FabricatorScreen extends MachineScreenCommon<FabricatorContainer> {

    public static final ResourceLocation TEXTURES = new ResourceLocation("spaldingsadditions:textures/gui/lapal_infuser.png");
    

    public FabricatorScreen(FabricatorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
       this.fuelBar = new FuelBar(40, 26, 96, 8);
    }

    @Override
    protected void init() {
        super.init();

    
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(TEXTURES);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);

        // Render Energy Bar
        if (this.container.getCurrentFuel() > 0.0D) {
            double k = this.container.getFuelScaled(96);
            this.blit(guiLeft + 40, this.guiTop + 26, 0, 168, (int)k, 8);
         }

        // Render arrow
        int l = this.container.getProgressScaled(22);
        this.blit(75 + i, 45 + j, 0, 177, l, 16);

    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    	
    	String s = this.title.getFormattedText();
        this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F,
                (float) (this.ySize - 96 + 2), 4210752);
       
    }

    @Override
    protected void renderHoveredToolTip(int mouseX, int mouseY) {
    	Rectangle bar = this.fuelBar.rect;
        if (isPointInRegion(bar.x, bar.y, bar.width, bar.height, mouseX, mouseY)) {
           this.renderTooltip(TextUtils.fuelPercent(this.container.getFuelScaled(100)).getFormattedText(), mouseX, mouseY);
        }
        
        super.renderHoveredToolTip(mouseX, mouseY);
    }
}