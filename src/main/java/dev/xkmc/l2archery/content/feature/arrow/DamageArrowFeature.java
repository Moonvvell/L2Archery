package dev.xkmc.l2archery.content.feature.arrow;

import dev.xkmc.l2archery.content.entity.GenericArrowEntity;
import dev.xkmc.l2archery.content.feature.types.OnHitFeature;
import dev.xkmc.l2library.init.events.attack.CreateSourceEvent;
import net.minecraft.network.chat.MutableComponent;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public record DamageArrowFeature(
		BiConsumer<GenericArrowEntity, CreateSourceEvent> source,
		Supplier<MutableComponent> comp) implements OnHitFeature {

	@Override
	public void onHurtEntity(GenericArrowEntity genericArrow, CreateSourceEvent source) {
		this.source.accept(genericArrow, source);
	}

	@Override
	public void addTooltip(List<MutableComponent> list) {
		list.add(comp.get());
	}

	@Override
	public boolean allowDuplicate() {
		return true;
	}

}
