package com.abcdwater;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class Config {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.BooleanValue ENABLED;
    public static final ModConfigSpec.DoubleValue TRIGGER_HEIGHT;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.push("general");
        ENABLED = builder
            .comment("Whether auto water clutch is enabled.")
            .define("enabled", true);
        TRIGGER_HEIGHT = builder
            .comment("Minimum fall distance in blocks required to trigger auto clutch. Range: 1-64.")
            .defineInRange("triggerHeight", 6.0D, 1.0D, 64.0D);
        builder.pop();
        SPEC = builder.build();
    }

    private Config() {
    }
}
