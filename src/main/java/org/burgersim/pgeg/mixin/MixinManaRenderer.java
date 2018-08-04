package org.burgersim.pgeg.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import org.burgersim.pgeg.mana.IManaHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static org.burgersim.pgeg.utils.Reference.MOD_ID;

@Mixin(GuiIngame.class)
public abstract class MixinManaRenderer extends Gui {
    @Shadow
    private int field_194811_H;
    @Shadow
    @Final
    private Random rand;
    @Shadow
    private int field_194812_I;
    @Shadow
    private int playerHealth;
    private static final ResourceLocation MANA_ICONS = new ResourceLocation(MOD_ID, "textures/gui/icons.png");
    @Final
    private Minecraft mc;

    @Inject(method = "renderPlayerStats", at = @At("RETURN"))
    private void renderManaBar(CallbackInfo ci) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) this.mc.getRenderViewEntity();
            IManaHandler handler = (IManaHandler) player;
            int mana = MathHelper.ceil(handler.getMana());
            float maxMana = handler.getMaxMana();
            if (maxMana > 0) {
                int barX = this.field_194811_H / 2 - 91;
                int barY = this.field_194812_I - 39;
                int manaPerStar = (int) handler.getMaxMana() / 10;

                this.mc.getTextureManager().bindTexture(MANA_ICONS);
                int x;
                for (x = 9; x >= 0; --x) {
                    int drawX = barX + x * 8;
                    int drawY = barY - playerHealth / 20 * 9;
                    if (player.getTotalArmorValue() > 0) {
                        drawY -= 10;
                    }
                    if (MathHelper.ceil(mana) <= 2 * manaPerStar) {
                        drawY += this.rand.nextInt(2);
                    }
                    this.drawTexturedModalRect(drawX, drawY, 17, 0, 9, 9);
                    if (x * manaPerStar + 1 < mana) {
                        this.drawTexturedModalRect(drawX, drawY, 35, 0, 9, 9);
                    } else if (x * manaPerStar + 1 == mana) {
                        this.drawTexturedModalRect(drawX, drawY, 44, 0, 9, 9);
                    }
                }
            }
        }
    }
}
