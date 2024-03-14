package org.figuramc.figura.utils.fabric;

import net.fabricmc.fabric.impl.client.rendering.ArmorRendererRegistryImpl;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import org.figuramc.figura.mixin.render.layers.HumanoidArmorLayerAccessor;

public class RenderUtilsImpl {
    public static <T extends LivingEntity, A extends HumanoidModel<T>> A getCustomArmorModel(T entity, ItemStack stack, EquipmentSlot slot, A _default) {
        if (ArmorRendererRegistryImpl.get(stack.getItem()) != null) {
            return null;
        }
        return _default;
    }

    public static <T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> ResourceLocation getArmorResource(HumanoidArmorLayer<T, M, A> armorLayer, Entity entity, ItemStack stack, ArmorItem armorItem, EquipmentSlot slot, boolean isInner, String type) {
        return ((HumanoidArmorLayerAccessor<T, M, A>) armorLayer).invokeGetArmorLocation(armorItem, isInner, type);
    }
}
