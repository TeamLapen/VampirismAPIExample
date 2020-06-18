package de.teamlapen.vampirismapiexample;

import de.teamlapen.vampirismapiexample.modcompat.VampirismCompat;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value = VampirismAPIExampleMod.MODID)
public class VampirismAPIExampleMod {

    public static final String MODID = "vampirism-api-example";

    private static VampirismAPIExampleMod instance;

    public VampirismAPIExampleMod() {
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }


    @SubscribeEvent
    public void init(FMLCommonSetupEvent event) {
        if (ModList.get().isLoaded("vampirism")) {
            VampirismCompat.register();
        }
    }

    @SubscribeEvent
    public void onEntityRegistry(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().register(EntityType.Builder.create(SuperCowEntity::new, EntityClassification.CREATURE).size(0.9f, 1.4f).build(MODID + ":supercow").setRegistryName(MODID, "supercow"));
    }


}