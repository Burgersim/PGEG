package org.burgersim.pgeg.mixin.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.math.RayTraceFluidMode;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.burgersim.pgeg.item.ItemWand;
import org.burgersim.pgeg.listener.PgegBootstrap;
import org.burgersim.pgeg.mana.IManaHandler;
import org.burgersim.pgeg.recipe.InWorldCrafting;
import org.burgersim.pgeg.recipe.RecipesWand;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.burgersim.pgeg.utils.Reference.MANA_ICONS;

@Mixin(GuiIngame.class)
public abstract class MixinWandCraftingOverlay extends Gui {
    @Shadow
    @Final
    private Minecraft mc;

    @Shadow
    @Final
    private ItemRenderer itemRenderer;

    @Shadow
    private int scaledWidth;
    @Shadow
    private int scaledHeight;
    private Block lastBlock;
    private IRecipe lastRecipe;

    @Inject(method = "renderHotbar", at = @At("RETURN"))
    private void renderOverlay(float p_renderHotbar_1_, CallbackInfo ci) {
        RenderHelper.enableGUIStandardItemLighting();
        EntityPlayer player = (EntityPlayer) this.mc.getRenderViewEntity();
        Item mainhand = player.getHeldItemMainhand().getItem();
        Item offhand = player.getHeldItemOffhand().getItem();
        if (mainhand instanceof ItemWand
                || offhand instanceof ItemWand) {
            World world = player.world;

            RayTraceResult traceResult = player.rayTrace(20.0D, 0.0F, RayTraceFluidMode.NEVER);
            Block block = world.getBlockState(traceResult.getBlockPos()).getBlock();
            if (block == lastBlock) {
                if (lastRecipe != null) {
                    RecipesWand recipe = (RecipesWand) lastRecipe;
                    float manaCost = recipe.getManaCost();
                    this.itemRenderer.renderItemIntoGUI(lastRecipe.getRecipeOutput(),
                            this.scaledWidth / 2 - 25,
                            this.scaledHeight / 2 - 7);
                    GlStateManager.disableDepth();
                    if (mainhand.isIn(PgegBootstrap.wands) || offhand.isIn(PgegBootstrap.wands)) {
                        if (!recipe.isRightWand(player.getHeldItemMainhand()) && !recipe.isRightWand(player.getHeldItemOffhand())) {
                            this.itemRenderer.renderItemIntoGUI(
                                    new ItemStack(Item.BLOCK_TO_ITEM.get(Blocks.BARRIER)),
                                    this.scaledWidth / 2 - 25,
                                    this.scaledHeight / 2 - 7);
                        }
                    }
                    if (manaCost > 0 && !player.capabilities.isCreativeMode) {
                        IManaHandler handler = (IManaHandler) player;
                        String starsCost = String.format("%.2f",
                                manaCost / (handler.getMaxMana() / 10));
                        int stringWidth = this.mc.fontRenderer.getStringWidth(starsCost);
                        this.mc.fontRenderer.drawStringWithShadow(starsCost,
                                this.scaledWidth / 2 - 25 - (stringWidth + 1) / 2,
                                this.scaledHeight / 2 + 10,
                                manaCost > handler.getMana() ? 0xff0000 : 0xffffff);
                        this.mc.getTextureManager().bindTexture(MANA_ICONS);
                        this.drawTexturedModalRect(
                                this.scaledWidth / 2 - 25 - (stringWidth + 1) / 2 + stringWidth,
                                this.scaledHeight / 2 + 9,
                                9,
                                0,
                                9,
                                9);
                    }
                }
            } else {
                lastBlock = block;
                lastRecipe = world.getRecipeManager().getRecipe(new InWorldCrafting(new ItemStack(block.asItem())), world);
            }
        }
        GlStateManager.enableDepth();
        RenderHelper.disableStandardItemLighting();
    }
}
