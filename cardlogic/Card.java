package cardLogic;

import IO.Terminal;

public class Card {
    private final static int[] raritycolors = {
        Terminal.COLOR_WHITE,
        Terminal.COLOR_BLUE,
        Terminal.COLOR_GREEN,
        Terminal.COLOR_MAGENTA,
        Terminal.COLOR_YELLOW
    };
    public String name, description;
    public int health;
    public float power;
    public final int rarity;

    Card(String n, String d, int r, float p, int h){
        name = n;
        description = d;
        rarity = r;
        power = p;
        health = h;
    }

    @Override
    public String toString(){
        return name + "\n" + description;
    }

    public void print(){
        Terminal.setStyleType(true, false, false, false);
        Terminal.setCol(raritycolors[rarity], false);
        Terminal.printWithWidth(name, 20);
        System.out.println();
        Terminal.setStyleType(false, false, false, false);
        Terminal.printWithWidth(description, 20);
        System.out.println();
    }
}