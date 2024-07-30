package com.soytutta.mynethersdelight.core.mixin;

import com.soytutta.mynethersdelight.common.entity.ia.EatMagmaCakeGoal;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.animal.frog.Frog;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.logging.Level;

@Mixin(Frog.class)
public abstract class FrogEntityMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(EntityType<? extends Frog> entityType, Level level, CallbackInfo ci) {
        Frog frog = (Frog) (Object) this;
        GoalSelector goalSelector = frog.goalSelector;
        goalSelector.addGoal(1, new EatMagmaCakeGoal(frog));
    }
}