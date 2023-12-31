package io.github.cattslmao.bedrockparity;

public class ParityConfig {
    public static final ParityConfigHandler config = new ParityConfigHandler("server");
    public static final ParityConfigHandler.Setting CAKE_STACKING = config.register(new ParityConfigHandler.Setting("cakeStacking").setDefault(true));
    public static final ParityConfigHandler.Setting PARROT_STAY_ON = config.register(new ParityConfigHandler.Setting("parrotStayOn").setDefault(true));
    public static final ParityConfigHandler.Setting FOX_LONGER_WINDUP = config.register(new ParityConfigHandler.Setting("foxLongerWindup").setDefault(true));
    public static final ParityConfigHandler.Setting LIGHT_FILTERING = config.register(new ParityConfigHandler.Setting("lightFiltering").setDefault(true));

    public static void initializeConfig() {
        config.load();
        config.save();
    }
}
