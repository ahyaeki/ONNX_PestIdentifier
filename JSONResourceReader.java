package ai.onnxruntime.example.imageclassifier;

import static androidx.camera.core.CameraX.getContext;

import java.io.*;
import java.nio.Buffer;

import android.content.res.Resources;
import android.renderscript.ScriptGroup;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONResourceReader {

    private String jsonString;
    private static final String LOGTAG = JSONResourceReader.class.getSimpleName();

    public JSONResourceReader(Resources resources, int id) {
        InputStream resourceReader = resources.openRawResource(id);
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceReader, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            Log.e(LOGTAG, "Oh no it broke while using JSONResourceReader", e);
        } finally {
            try {
                resourceReader.close();
            } catch (Exception e) {
                Log.e(LOGTAG, "Oh no cringe while using JSONResourceReader", e);
            }
        }
        jsonString = writer.toString();
    }
    public <T> T constructUsingGson(Class<T> type) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, type);
    }

    public void executeReading(){
        JSONResourceReader reader = new JSONResourceReader(getContext().getResources(), R.raw.pestList);
        pestList jsonObj = reader.constructUsingGson(pestList.class);
    }
}
