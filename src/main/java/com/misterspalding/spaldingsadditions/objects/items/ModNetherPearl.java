package com.misterspalding.spaldingsadditions.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;
import com.misterspalding.spaldingsadditions.utils.TextUtils;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModNetherPearl extends Item{

	public ModNetherPearl() {
		super(new Item.Properties().group(ModItemGroup.instance));
		
	}
	
	@OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
		list.add(TextUtils.translate("tooltip", "nether_pearl").applyTextStyle(TextFormatting.YELLOW));  
	   }
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity player, Hand hand) {
	      ItemStack itemHeld = player.getHeldItem(hand);
	      byte diff;
	      switch(worldIn.getDifficulty()) {
	      case HARD:
	         diff = 3;
	         break;
	      case NORMAL:
	         diff = 2;
	         break;
	      case EASY:
	         diff = 1;
	         break;
	      case PEACEFUL:
	         diff = 0;
	         break;
	      default:
	         diff = 1;
	      }

	      player.setFire(1 + diff * 2);
	      itemHeld.shrink(1);
	      player.getCooldownTracker().setCooldown(this, 20);
	      return ActionResult.resultPass(player.getHeldItem(hand));
	   }
	
}
