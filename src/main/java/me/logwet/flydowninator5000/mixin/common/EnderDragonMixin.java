package me.logwet.flydowninator5000.mixin.common;

import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(EnderDragon.class)
public abstract class EnderDragonMixin {
    @Redirect(
            method = "aiStep",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;sqrt(D)F"),
            slice =
                    @Slice(
                            from =
                                    @At(
                                            value = "INVOKE",
                                            target =
                                                    "Lnet/minecraft/world/entity/boss/enderdragon/phases/DragonPhaseInstance;getFlySpeed()F"),
                            to =
                                    @At(
                                            value = "INVOKE",
                                            target = "Lnet/minecraft/util/Mth;clamp(DDD)D")))
    private float overrideHorizontalDistance(double d) {
        return 0.0F;
    }
}
