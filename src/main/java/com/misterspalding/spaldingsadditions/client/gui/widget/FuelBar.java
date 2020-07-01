package com.misterspalding.spaldingsadditions.client.gui.widget;

import java.awt.Rectangle;

public class FuelBar {

    public final Rectangle rect;

    public FuelBar(int x, int y, int width, int height) {
        this.rect = new Rectangle(x, y, width, height);
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return rect.contains(mouseX, mouseY);
    }

}