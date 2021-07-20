package net.dries007.tfc.client.screen.button;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

import net.minecraftforge.fml.network.PacketDistributor;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.dries007.tfc.network.PacketHandler;
import net.dries007.tfc.network.ScreenButtonPacket;

public class KnappingButton extends Button
{
    public int id;
    private final ResourceLocation texture;

    public KnappingButton(int id, int x, int y, int width, int height, ResourceLocation texture)
    {
        super(x, y, width, height, StringTextComponent.EMPTY, KnappingButton::doPress);
        this.id = id;
        this.texture = texture;
    }

    public static void doPress(Button widget)
    {
        if (widget instanceof KnappingButton)
        {
            KnappingButton button = (KnappingButton) widget;
            if (button.active)
            {
                button.visible = false;
                PacketHandler.send(PacketDistributor.SERVER.noArg(), new ScreenButtonPacket(button.id, null));
                button.playDownSound(Minecraft.getInstance().getSoundManager());
            }
        }
    }

    @Override
    public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        if (visible)
        {
            Minecraft.getInstance().getTextureManager().bind(texture);
            isHovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;

            matrixStack.pushPose();
            blit(matrixStack, x, y, 0, 0, 16, 16, 16, 16);
            matrixStack.popPose();
            onDrag(mouseX, mouseY, 0, 0); // ?
        }
    }
}
