public class Main {
    public static void main(String[] args){
        CardLoader.load("res/cards.json");
        for(int i = 0; i < 50; i++){
            System.out.println(CardLoader.cardHeap.roll());
        }
    }
}
