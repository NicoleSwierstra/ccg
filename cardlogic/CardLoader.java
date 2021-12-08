import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.*;

public class CardLoader {
    final static float
        COMMON = 1.0f,
        UNCOMMON = 0.75f,
        RARE = 0.5f,
        EPIC = 0.25f,
        LEGENDARY = 0.1f;
    
    public RandomCollection<Card> cardHeap;

    public static void load(String filepath){
        String jsonstring = "";
        try (BufferedReader r = new BufferedReader(new FileReader(filepath))) {
            while((jsonstring += r.readLine()) != null);
        } catch (IOException e) {e.printStackTrace();}
        System.out.print(jsonstring);
    }
}
