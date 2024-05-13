
import java.util.LinkedList;
import java.util.Random;

public class Deck {
    private LinkedList<Card> m_cards;

    // Default constructor
    public Deck() {
        this.m_cards = new LinkedList<>();
        reset();
    }

    // Copy constructor
    public Deck(Deck other) {
        this.m_cards = new LinkedList<>();
        for (Card card : other.m_cards) {
            this.m_cards.add(new Card(card.getSuit(), card.getRank()));
        }
    }

    // Initialize the deck with cards
    public void reset() {
        m_cards.clear();
        for (int suit = Card.HEARTS; suit <= Card.DIAMONDS; suit++) {
            for (int rank = 2; rank <= Card.ACE; rank++) {
                m_cards.add(new Card(suit, rank));
            }
        }
    }

    // Convert the deck to a String 
    @Override
    public String toString() {
        return m_cards.toString();
    }

    // Get the size of the deck
    public int size() {
        return m_cards.size();
    }

    // Deal a random card
    public Card deal() {
        Random rand = new Random();
        return m_cards.remove(rand.nextInt(m_cards.size()));
    }
}