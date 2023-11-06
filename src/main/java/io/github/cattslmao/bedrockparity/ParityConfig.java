package io.github.cattslmao.bedrockparity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParityConfig {
    private final Path path = Path.of("config", "bedrockparity.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final Map<String, Setting> registry = new HashMap<>();

    public static class Setting {
        String label;

        Object valueDefault;
        Object value;

        List<String> mixins;

        public Setting(String label) {
            this.label = label;
        }

        public Setting setDefault(Object value) {
            this.valueDefault = value;
            this.value = this.valueDefault;

            return this;
        }

        public Setting addMixin(String name) {
            this.mixins.add(name);

            return this;
        }

        public void set(Object value) {
            this.value = value;
        }

        public Object get() {
            return this.value;
        }

        public Boolean getBoolean() {
            return (boolean) this.get();
        }

        public int getInt() {
            return (int) this.get();
        }
    }

    public Setting register(Setting setting) {
        if (registry.containsKey(setting.label)) {
            BedrockParity.LOGGER.error("Parity Setting \"" + setting.label + "\" already in registry, overriding...");
        }

        registry.put(setting.label, setting);
        return setting;
    }

    public Setting get(String label) {
        if ( !registry.containsKey(label) ) {
            BedrockParity.LOGGER.error("Parity Setting \"" + label + "\" not found! Can't get!");
        }

        return registry.get(label);
    }

    public void load() {
        BedrockParity.LOGGER.info( "Loading config..." );

        if ( !Files.exists(path) ) {
            BedrockParity.LOGGER.info( "No config file found." );
            return;
        }

        try {
            String jsonString = Files.readString(path);
            Map<String, Object> loadedSettings = gson.fromJson(jsonString, new TypeToken<Map<String, Object>>(){}.getType());

            for (Map.Entry<String, Object> entry : loadedSettings.entrySet()) {
                String key = entry.getKey();

                if (!registry.containsKey(key)) {
                    BedrockParity.LOGGER.warn("Invalid setting \"" + key + "\", discarding...");
                    continue;
                }

                get(key).set(entry.getValue());
            }
        } catch (Exception e) {
            BedrockParity.LOGGER.error("Failed to load config!");
        }
    }

    private HashMap<String, Object> serialize() {
        HashMap<String, Object> out = new HashMap<>();

        for (Map.Entry<String, Setting> entry : registry.entrySet()) {
            String key = entry.getKey();
            Setting setting = entry.getValue();

            out.put(key, setting.get());
        }

        return out;
    }

    public void save() {
        BedrockParity.LOGGER.info( "Saving config..." );

        try {
            Files.deleteIfExists(path);

            Files.createFile(path);
            Files.writeString(path, gson.toJson(serialize()));
        } catch (Exception e) {
            BedrockParity.LOGGER.error("Failed to save config!");
        }
    }

    public void debugPrint() {
        System.out.println( gson.toJson(serialize()) );
    }
}
