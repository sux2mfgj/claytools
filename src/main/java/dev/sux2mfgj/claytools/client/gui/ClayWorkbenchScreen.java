package dev.sux2mfgj.claytools.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.sux2mfgj.claytools.ClayTools;
import dev.sux2mfgj.claytools.container.ClayWorkbenchContainer;
import dev.sux2mfgj.claytools.tileentity.ClayWorkbenchTileEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class ClayWorkbenchScreen extends ContainerScreen<ClayWorkbenchContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(ClayTools.mod_id,
            "textures/gui/clayworkbench.png");

    private Button startButton;
    ClayWorkbenchContainer container;

    public ClayWorkbenchScreen(ClayWorkbenchContainer container, PlayerInventory playerInventory, ITextComponent title)
    {
        super(container, playerInventory, title);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 176;
        this.ySize = 166;
        
        this.container = container;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.blit(x, y, 0, 0, this.xSize, this.ySize);

        this.startButton = new Button(x + 79, y + 66, 20, 10, "", this.container);
        this.addButton(this.startButton);
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
