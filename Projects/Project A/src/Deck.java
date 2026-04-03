
import java.util.ArrayList;

public class Deck {
    
    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>(52);
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 13; j++){
                cards.add(new Card(j, i));
            }
        }
    }

    /**
     * Formats a Deck object into a string
     */
    public String toString(){
        String output = "";
        for (Card c : cards){
            output += c.toString() + "\n";
        }
        return output;
    }

    public Card deal(Card card){
        for(Card c : cards){
            if(c.equals(card)) {
                cards.remove(card);
                return card;
            }
        }
        return null;
    }
}
