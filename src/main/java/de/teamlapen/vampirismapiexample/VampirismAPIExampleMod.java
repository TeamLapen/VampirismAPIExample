package de.teamlapen.vampirismapiexample;

import de.teamlapen.vampirismapiexample.modcompat.VampirismCompat;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = VampirismAPIExampleMod.MODID, name = VampirismAPIExampleMod.MODID, version = VampirismAPIExampleMod.VERSION, acceptedMinecraftVersions = "[1.10,)", dependencies = "required-after:Forge@[12.18.1.2076,);after:vampirism")
public class VampirismAPIExampleMod {

    public static final String MODID = "vampirism-api-example";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static VampirismAPIExampleMod instance;


    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        EntityRegistry.registerModEntity(EntitySuperCow.class, "superCow", 0, VampirismAPIExampleMod.instance, 80, 1, true, 0x343434, 0x888888);

        if (Loader.isModLoaded("vampirism")) {
            VampirismCompat.register();
        }
    }
}