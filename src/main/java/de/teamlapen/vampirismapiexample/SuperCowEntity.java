package de.teamlapen.vampirismapiexample;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.world.World;


public class SuperCowEntity extends CowEntity {
    public SuperCowEntity(EntityType<SuperCowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return true;
    }


    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100d);
    }

}
