package org.figuramc.figura.utils.forge;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import org.jetbrains.annotations.Nullable;

public class RenderUtilsImpl {
    @SuppressWarnings({"UnstableApiUsage", "unchecked"})
    public static <T extends LivingEntity, A extends HumanoidModel<T>> A getCustomArmorModel(T entity, ItemStack stack, EquipmentSlot slot, A _default) {
        Model model = ForgeHooksClient.getArmorModel(entity, stack, slot, _default);

        if (model instanceof HumanoidModel<?> humanoidModel) {
            return (A) humanoidModel;
        }

        return null;
    }

    public static <T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> ResourceLocation getArmorResource(HumanoidArmorLayer<T, M, A> armorLayer, Entity entity, ItemStack stack, ArmorItem item, EquipmentSlot slot, boolean isInner, String type) {
        return armorLayer.getArmorResource(entity, stack, slot, type);
    }
}
