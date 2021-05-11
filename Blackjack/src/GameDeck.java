import java.util.*;
public class GameDeck {
    public static String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
    public static String[] values = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    public static ArrayList<String> deck = new ArrayList<String>();
    
    public static void create(){
        for(String suit:suits){
            for(String value : values){
                deck.add(value + " of " + suit);
            }
        }
        Collections.shuffle(deck);
    }
    public static String getTopCard(){
        String card = deck.get(0);
        deck.remove(0);
        return (card);
    }
    public static void reset(){
        deck.clear();
        create();
    }
    
}
