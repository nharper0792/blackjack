import java.util.*;
public class Blackjack extends GameDeck {

    
    private static HashMap<String,Integer> key = new HashMap<String, Integer>();
    public static ArrayList<String> playerHand = new ArrayList<String>();
    public static ArrayList<String> dealerHand = new ArrayList<String>();
    public Blackjack()
    {
        key.put("Ace",11);
        key.put("Two",2);
        key.put("Three",3);
        key.put("Four",4);
        key.put("Five",5);
        key.put("Six",6);
        key.put("Seven",7);
        key.put("Eight",8);
        key.put("Nine",9);
        key.put("Ten", 10);
        key.put("Jack", 10);
        key.put("Queen",10);
        key.put("King",10);
        reset();
        playerHand.clear();
        dealerHand.clear();
        for(int i = 0;i<2;i++){
            deal(playerHand);
            deal(dealerHand);
        }
    }
    public static String displayPlayer(){
        String temp = "";
        for(String card : playerHand)
            temp += card +", ";
        return temp;
    }
    public static int score(ArrayList<String> hand){
        int score = 0;
        boolean hasAce = false;
        for(String card : hand){
            String value = card.substring(0,card.indexOf(" "));
            if(value=="Ace"){
                hasAce = true;
            }
            score += key.get(value);
            
        }
        if((score>21) && hasAce){
            score-=10;
        }
        return score;
    }
    public static void deal(ArrayList<String> hand){
        hand.add(getTopCard());
    }
    public static void setup(){

        
        key.put("Ace",11);
        key.put("Two",2);
        key.put("Three",3);
        key.put("Four",4);
        key.put("Five",5);
        key.put("Six",6);
        key.put("Seven",7);
        key.put("Eight",8);
        key.put("Nine",9);
        key.put("Ten", 10);
        key.put("Jack", 10);
        key.put("Queen",10);
        key.put("King",10);
        
        System.out.println("the goal is to get to 21 points" 
        +"\n"+"you’ll be dealt two cards face up. From here you’ve got two options:" 
        +"\n"+"If you want another card to try and get you closer to 21, you ‘Hit’"
        +"\n"+"To stick with what you’ve got, you \"Stand\"");
        
    }
    public static void display(){
        System.out.println("Your hand is: " + playerHand + " and you have " + score(playerHand) + " points.");
        System.out.println(("The dealer is showing a " + dealerHand.get(dealerHand.size()-1)));
    }
    public static void newGame(){
        System.out.println("\n" + "*****NEW GAME*****" + "\n");
        reset();
        playerHand.clear();
        dealerHand.clear();
        for(int i = 0;i<2;i++){
            deal(playerHand);
            deal(dealerHand);
        }
        display();
    }
    public static void main(String[] args) throws Exception {
        boolean keepPlaying = true;
        Scanner scan = new Scanner(System.in);
        String hitOrStand = "h";
        setup();
        while(keepPlaying){
            newGame();
            while(score(playerHand)<21){
                System.out.print("Would you like to hit \"h\" or stand \"s\"? ");
                hitOrStand = scan.next();
                while("hs".indexOf(hitOrStand.toLowerCase()) == -1){
                    System.out.print("Would you like to hit \"h\" or stand \"s\"? ");
                    hitOrStand = scan.next().substring(0,1);
                }
                if((hitOrStand.equals("h"))){
                    deal(playerHand);
                    display();
                }
                else{
                    System.out.println((hitOrStand));
                    break;
                }

                
            }
            if(score(playerHand) == 21){
                System.out.println("Congratulations, you won");
            }
            else if(score(playerHand) > 21){
                System.out.println("You busted, the dealer won");
            }
            else{
                while(score(dealerHand) < 17){
                    deal(dealerHand);
                    System.out.println("the dealer drew another card");
                }
                if (score(dealerHand) == 21){
                    System.out.println("the dealer has blackjack, you have lost");
            }
                else if( score(dealerHand)> score(playerHand) &&  score(dealerHand)<=21){
                    System.out.println("the dealer has a score of "+(score(dealerHand))+", they have won");
                }
                else if( score(dealerHand)< score(playerHand) &&  score(dealerHand)<=21){
                    System.out.println("the dealer has a score of "+(score(dealerHand))+", you have won");
                }
                else if( score(dealerHand) == score(playerHand)){
                    System.out.println("It is a tie, the dealer has won");
                }
                else if( score(dealerHand) > 21){
                    System.out.println("the dealer busted, you win");
                }
            }
            System.out.print("Would you like to play again? (\"y\" or \"n\") ");
            if (scan.next().equals("n")){
                keepPlaying=false;
            }
        }
        scan.close();

    }

}

