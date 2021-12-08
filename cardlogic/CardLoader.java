import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.*;

public class CardLoader {
    private final static float
        COMMON = 1.0f,
        UNCOMMON = 0.75f,
        RARE = 0.5f,
        EPIC = 0.25f,
        LEGENDARY = 0.1f;
    
    private final static float[] WEIGHTS = {COMMON, UNCOMMON, RARE, EPIC, LEGENDARY};
    
    public static RandomCollection<Card> cardHeap = new RandomCollection<Card>();

    public static void load(String filepath){
        String jsonstring = "";
        try (BufferedReader r = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = r.readLine()) != null){
                jsonstring += line.strip();
            }
        } catch (IOException e) {e.printStackTrace();}
        
        JSONObject jsonobject = new JSONObject(jsonstring);
        jsonobject.getJSONArray("cards").forEach(cardobj -> {
            JSONObject jo = (JSONObject)cardobj;
            Card card = new Card(jo.getString("name"), jo.getString("description"), jo.getInt("rarity"));
            cardHeap.add(card, WEIGHTS[card.rarity]);
        });
    }
}
