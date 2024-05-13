
import java.util.LinkedList;

public class Dealer {
    private Deck m_deck;

    // Default constructor
    public Dealer() {
        this.m_deck = new Deck();
    }

    // Deal cards
    public LinkedList<Card> deals(int n) {
        LinkedList<Card> dealtCards = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (m_deck.size() > 0) {
                dealtCards.add(m_deck.deal());
            } else {
                break;
            }
        }
        return dealtCards;
    }

    // Get the size of the deck
    public int size() {
        return m_deck.size();
    }

    // Convert the deck to a String 
    @Override
    public String toString() {
        return m_deck.toString();
    }
}