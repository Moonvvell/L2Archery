package dev.xkmc.l2archery.foundation.item;

import dev.xkmc.l2archery.init.registrate.ArcheryItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WindBottle extends Item {

	public WindBottle(Properties properties) {
		super(properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean select) {
		if (!level.isClientSide() && entity instanceof Player player) {
			if (entity.getDeltaMovement().length() >= 10) {
				stack.shrink(1);
				player.getInventory().placeItemBackInInventory(ArcheryItems.CAPTURED_WIND.asStack());
			}
		}
	}
}