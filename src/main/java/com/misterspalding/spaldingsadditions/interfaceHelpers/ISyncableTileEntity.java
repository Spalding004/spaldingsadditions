package com.misterspalding.spaldingsadditions.interfaceHelpers;

import java.util.Iterator;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ISyncableTileEntity {

	 default void handleSync() {
	      if (!this.getWorld().isRemote) {
	         if (this.getWorld().getGameTime() % (long)this.getSyncFrequency() == 0L) {
	            this.syncToClients();
	            return;
	         }

	         Iterator<? extends ServerPlayerEntity> var1 = 
	        		 /*this.getWorld().getEntitiesWithinAABB(ServerPlayerEntity.class, 
	        		 (new AxisAlignedBB((double)(-this.getInstaSyncRange()), 
	        				 (double)(-this.getInstaSyncRange()), 
	        				 (double)(-this.getInstaSyncRange()), 
	        				 (double)(this.getInstaSyncRange() - 1), 
	        				 (double)(this.getInstaSyncRange() - 1), 
	        			 (double)(this.getInstaSyncRange(offset(this.getPosition())*/	
	        				this.getWorld().getEntitiesWithinAABB(ServerPlayerEntity.class, new AxisAlignedBB((double)-this.getInstaSyncRange(), 
	        						(double)-this.getInstaSyncRange(), (double)-this.getInstaSyncRange(), (double)this.getInstaSyncRange()-1, (double)this.getInstaSyncRange()-1,
	        						(double)this.getInstaSyncRange())).iterator();

	         while(var1.hasNext()) {
	            ServerPlayerEntity player = (ServerPlayerEntity)var1.next();
	            this.syncToClient(player);
	         }
	      }

	   }

	   @Nonnull
	   BlockPos getPosition();

	   default int getSyncFrequency() {
	      return 20;
	   }

	   @Nonnull
	   World getWorld();

	   default int getInstaSyncRange() {
	      return 6;
	   }

	   default void syncToClients() {
	      Iterator<? extends PlayerEntity> var1 = this.getWorld().getPlayers().listIterator();

	      while(var1.hasNext()) {
	    	  PlayerEntity player = (PlayerEntity)var1.next();
	         if (player instanceof ServerPlayerEntity) {
	            this.syncToClient((ServerPlayerEntity)player);
	         }
	      }

	   }

	   default void syncToClient(ServerPlayerEntity player) {
	      if (this.shouldSyncToPlayer(player)) {
	         this.writeToNBT(new CompoundNBT());
	         player.connection.sendPacket(this.getUpdatePacket());
	      }

	   }

	   SUpdateTileEntityPacket  getUpdatePacket();

	   void readFromNBT(CompoundNBT var1);

	   CompoundNBT writeToNBT(CompoundNBT var1);

	   default boolean shouldSyncToPlayer(ServerPlayerEntity player) {
	      return player.getDistanceSq(this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getZ()) <= (double)this.getMaxSyncDistanceSquared();
		  
	   }

	   default void syncToServer() {
	      this.writeToNBT(new CompoundNBT());
	      (new NoSuchMethodError()).printStackTrace();
	   }

	   default int getMaxSyncDistanceSquared() {
	      return 64;
	   }
	
}
