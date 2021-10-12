package Puzzle21;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Flatten {
    public static void flattenFile (String inputFilename, String outputFilename) throws IOException {
        String json = Files.readString(Path.of(inputFilename));
        Files.write( Path.of(outputFilename), flatten(new JSONObject(json)).toString(4).getBytes(StandardCharsets.UTF_8));
    }

    public static JSONObject flatten(JSONObject jsonObject) {
        JSONObject flattened = new JSONObject();
        flattenRecursive(jsonObject, flattened, "");
        return flattened;
    }

    private static void flattenRecursive(JSONObject jsonObject, JSONObject flattened, String prefix) {
        for (String key: jsonObject.keySet()) {
            if (!(jsonObject.get(key) instanceof JSONObject)) {
                if (prefix.equals("")) {
                    flattened.put(prefix.concat(key), jsonObject.get(key));
                }
                else {
                    flattened.put(prefix.concat(".").concat(key), jsonObject.get(key));
                }
            }
            else {
                if (prefix.equals("")) {
                    flattenRecursive(jsonObject.getJSONObject(key), flattened, prefix.concat(key));
                }
                else {
                    flattenRecursive(jsonObject.getJSONObject(key), flattened, prefix.concat(".").concat(key));
                }
            }
        }
    }
}
