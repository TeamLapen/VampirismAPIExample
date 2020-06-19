package de.teamlapen.vampirismapiexample.modcompat;

import de.teamlapen.vampirism.api.VampirismAPI;
import de.teamlapen.vampirismapiexample.SuperCowEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Handle Vampirism related things in a seperated package/class so no ClassNotFoundExceptions are thrown if Vampirism is not installed
 */
public class VampirismCompat {

    @ObjectHolder("vampirism-api-example:supercow")
    public final static EntityType<SuperCowEntity> supercow = null;

    public static void register() {
        //Register a blood value for our super cow
        Map<String, Integer> values = new HashMap<>();
        values.put("vampirism-api-example.superCow", 10);
        /*
        Mark the super cow as convertible using vampirism standard converting handler and vampirism's cow overlay
         You probably want to add a own overlay for you creature and maybe even a own {@link de.teamlapen.vampirism.api.entity.convertible.IConvertingHandler}
         */
        VampirismAPI.entityRegistry().addConvertible(supercow, new ResourceLocation("vampirism", "textures/entity/vanilla/cow_overlay.png"));
    }
}
