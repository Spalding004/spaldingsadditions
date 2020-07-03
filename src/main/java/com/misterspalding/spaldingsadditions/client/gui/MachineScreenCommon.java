package com.misterspalding.spaldingsadditions.client.gui;

import com.misterspalding.spaldingsadditions.client.gui.widget.FuelBar;
import com.misterspalding.spaldingsadditions.containers.CommonContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public abstract class MachineScreenCommon<T extends CommonContainer> extends ContainerScreen<T> {

	protected FuelBar fuelBar = null;

    MachineScreenCommon(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    protected void init() {
        super.init();

       
    }

    @Override
    public void render(int x, int y, float ticks) {
        this.renderBackground();
        super.render(x, y, ticks);
        this.renderHoveredToolTip(x, y);
    }

    @SuppressWarnings("unused")
	@Override
    protected void renderHoveredToolTip(int mouseX, int mouseY) {
        super.renderHoveredToolTip(mouseX, mouseY);
        for (Widget widget : this.buttons) {
           
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.title.getFormattedText();
        this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F,
                (float) (this.ySize - 96 + 2), 4210752);
    }

}