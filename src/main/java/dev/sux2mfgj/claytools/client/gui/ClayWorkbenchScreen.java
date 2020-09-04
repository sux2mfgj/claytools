package dev.sux2mfgj.claytools.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.container.ClayWorkbenchContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ClayWorkbenchScreen extends ContainerScreen<ClayWorkbenchContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(ClayTools.mod_id, "textures/gui/clayworkbench.png");

    public ClayWorkbenchScreen(ClayWorkbenchContainer container, PlayerInventory playerInventory, ITextComponent title)
    {
        super(container, playerInventory, title);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.blit(x, y, 0, 0, this.xSize, this.ySize);
        //this.blit(this.guiLeft, this.guiTop + 35, 176, 0, this.container);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        //TODO
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
}
