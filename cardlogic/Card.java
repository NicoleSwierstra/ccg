public class Card {
    public String name, description;
    public final int rarity;

    Card(String n, String d, int r){
        name = n;
        description = d;
        rarity = r;
    }

    @Override
    public String toString(){
        return name + "\n" + description;
    }
}