package com.github.okarmusk.yato;

import org.yaml.snakeyaml.Yaml;

public class YamlToObject {
    private final Yaml yaml = new Yaml();
    private volatile static YamlToObject instance;

    private YamlToObject() {}

    public static YamlToObject getInstance() {
        if (instance == null) {
            synchronized (YamlToObject.class) {
                if (instance == null) {
                    instance = new YamlToObject();

                    return instance;
                }
            }
        }

        return instance;
    }

    public <T> T fromFile(Class<T> clazz, String path) {
        final var inputStream = this.getClass().getClassLoader().getResourceAsStream(path);

        return yaml.loadAs(inputStream, clazz);
    }
}
