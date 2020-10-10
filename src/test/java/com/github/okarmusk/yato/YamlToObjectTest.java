package com.github.okarmusk.yato;

import com.github.okarmusk.model.KeyValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YamlToObjectTest {
    private final YamlToObject yamlToObject = YamlToObject.getInstance();

    @Test
    @DisplayName("Should be able to convert file into object")
    void convertYamlToObject() {
        final var keyValue = yamlToObject.fromFile(KeyValue.class, "key-value.yaml");
        assertNotNull(keyValue.key0);
        assertNotEquals("", keyValue.key0);
        assertEquals("value0", keyValue.key0);
    }
}
