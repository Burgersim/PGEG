package org.burgersim.pgeg.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import org.burgersim.pgeg.mana.IManaHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static org.burgersim.pgeg.utils.Reference.MANA_ICONS;

@Mixin(GuiIngame.class)
public abstract class MixinManaBarOverlay extends Gui {

    @Shadow
    @Final
    private Random rand;
    @Shadow
    @Final
    private Minecraft mc;

    @Shadow private int scaledWidth;

    @Shadow private int scaledHeight;

    @Inject(method = "renderPlayerStats", at = @At("RETURN"))
    private void renderManaBar(CallbackInfo ci) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) this.mc.getRenderViewEntity();
            IManaHandler handler = (IManaHandler) player;
            int mana = MathHelper.ceil(handler.getMana());
            float maxMana = handler.getMaxMana();
            if (maxMana > 0) {
                int barX = this.scaledWidth / 2 - 91;
                int barY = this.scaledHeight - 39;
                int manaPerStar = (int) handler.getMaxMana() / 10;
                int maxHealth = MathHelper.ceil((player.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue()
                        + player.getAbsorptionAmount()) / 2.0F / 10.0F);
                this.mc.getTextureManager().bindTexture(MANA_ICONS);
                int x;

                for (x = 9; x >= 0; --x) {
                    int drawX = barX + x * 8;
                    int drawY = barY - (maxHealth - 1) * Math.max(10 - (maxHealth - 2), 3) - 10;
                    if (player.getTotalArmorValue() > 0) {
                        drawY -= 10;
                    }
                    if (MathHelper.ceil(mana) <= 2 * manaPerStar) {
                        drawY += this.rand.nextInt(2);
                    }
                    this.drawTexturedModalRect(drawX, drawY, 0, 0, 9, 9);
                    if (x * manaPerStar + 1 < mana) {
                        this.drawTexturedModalRect(drawX, drawY, 9, 0, 9, 9);
                    } else if (x * manaPerStar + 1 == mana) {
                        this.drawTexturedModalRect(drawX, drawY, 18, 0, 9, 9);
                    }
                }
            }
        }
    }
}
