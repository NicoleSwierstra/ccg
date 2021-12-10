import IO.Terminal;

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

    public void print(){
        Terminal.setCol(Terminal.COLOR_WHITE, true);
        Terminal.setCol(Terminal.COLOR_BLACK, false);
        Terminal.printWithWidth(name, 20);
        Terminal.setCol(Terminal.COLOR_WHITE, false);
        Terminal.setCol(Terminal.COLOR_BLACK, true);
        Terminal.printWithWidth(description, 20);
    }
}