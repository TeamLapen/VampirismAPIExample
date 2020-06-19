package de.teamlapen.vampirismapiexample;

import de.teamlapen.vampirismapiexample.modcompat.VampirismCompat;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

@Mod(value = VampirismAPIExampleMod.MODID)
public class VampirismAPIExampleMod {

    public static final String MODID = "vampirism-api-example";

    private static VampirismAPIExampleMod instance;

    @ObjectHolder("vampirism-api-example:supercow")
    public final static EntityType<SuperCowEntity> supercow = null;

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

    @SubscribeEvent
    public void registerRenderer(FMLClientSetupEvent event) {
        DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> {
            RenderingRegistry.registerEntityRenderingHandler(supercow, CowRenderer::new);
            return 4;
        });
    }


}