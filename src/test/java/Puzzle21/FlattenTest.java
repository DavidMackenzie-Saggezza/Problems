package Puzzle21;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static Puzzle21.Flatten.flatten;
import static Puzzle21.Flatten.flattenFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlattenTest {

    @Test
    void example() {
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("baz", 8);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("a", 5);
        jsonObject2.put("bar", jsonObject1);
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("key", 3);
        jsonObject3.put("foo", jsonObject2);
        JSONObject flattened = flatten(jsonObject3);

        assertEquals(3, flattened.keySet().size());
        assertTrue(flattened.keySet().contains("key"));
        assertTrue(flattened.keySet().contains("foo.a"));
        assertTrue(flattened.keySet().contains("foo.bar.baz"));
        assertEquals(3, flattened.get("key"));
        assertEquals(5, flattened.get("foo.a"));
        assertEquals(8, flattened.get("foo.bar.baz"));
    }

    @Test
    void fileFlattens() {
        try {
            flattenFile("src/main/resources/example.json", "src/main/resources/exampleOutput.json");
        } catch (IOException e) {
            System.out.println("File not Found");
        }
    }
}