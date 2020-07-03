package com.misterspalding.spaldingsadditions.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import com.misterspalding.spaldingsadditions.SpaldingsAdditions.ModItemGroup;
import com.misterspalding.spaldingsadditions.inits.DamagesDec;
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

public class ModNetherGaze extends Item {

	public ModNetherGaze() {
		super(new Item.Properties().group(ModItemGroup.instance));
		
	}
	
	@OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
		list.add(TextUtils.translate("tooltip", "nether_gaze").applyTextStyle(TextFormatting.YELLOW));  
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

	      itemHeld.shrink(1);
	      player.setFire(3 + diff * 2);
	      player.attackEntityFrom(DamagesDec.NETHER_GAZE, (float)(4 + diff * 2));
	      if (!worldIn.isRemote) {
	         worldIn.createExplosion(player, (double)player.getPosition().getX(), (double)player.getPosition().getY(), (double)player.getPosition().getZ(), 5.0F, true, null);
	      }
	      return ActionResult.resultPass(player.getHeldItem(hand));
	   }
	
}
