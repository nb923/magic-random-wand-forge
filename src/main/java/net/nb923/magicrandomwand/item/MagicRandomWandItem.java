package net.nb923.magicrandomwand.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MagicRandomWandItem extends Item
{
    public MagicRandomWandItem(Item.Properties properties)
    {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        pPlayer.swing(pUsedHand);

        if (!pLevel.isClientSide())
        {
            int randNum = pPlayer.getRandom().nextInt(10) + 1;

            switch (randNum)
            {
                case 1:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
                    break;
                case 2:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 100, 1));
                    break;
                case 3:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 1));
                    break;
                case 4:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.LUCK, 100, 1));
                    break;
                case 5:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 1));
                    break;
                case 6:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 1));
                    break;
                case 7:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1));
                    break;
                case 8:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1));
                    break;
                case 9:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
                    break;
                case 10:
                    pPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1));
                    break;
            }
        }
        else
        {
            double x = pPlayer.getX();
            double y = pPlayer.getY();
            double z = pPlayer.getZ();

            for (int i = 0; i < 10; i++)
            {
                double offsetX = pLevel.random.nextGaussian() * 0.2;
                double offsetY = pLevel.random.nextGaussian() * 0.2;
                double offsetZ = pLevel.random.nextGaussian() * 0.2;

                pLevel.addParticle(
                        ParticleTypes.FIREWORK,
                        x, y, z,
                        offsetX, offsetY, offsetZ
                );
            }
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
