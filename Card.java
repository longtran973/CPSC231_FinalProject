
public class Card {
    //Suit Int Value
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;
    //FaceCard Int Value 
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;
    private int suit; // The suit of the card (1: Hearts, 2: Spades, 3: Clubs, 4: Diamonds)
    private int rank; // The rank of the card (2-10: 2-10, 11: Jack, 12: Queen, 13: King, 14: Ace)

    // Overload Constructor
    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    // Default Constructor to Ace of Spades
    public Card() {
        this.suit = 1;
        this.rank = 14;
    }
    // Copy Construtor 
    public Card(Card other) {
        this.suit = other.suit;
        this.rank = other.rank;
    }
    //To String Method
    @Override
    public String toString() {
        String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};
        String[] ranks = {null, null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        return ranks[this.rank] + " of " + suits[this.suit];
    }
    //Equals Method
    //Begin AI Use - Model GPT-4
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return rank == card.rank;
    }
    //End AI use

    // Getters
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    // Setters
    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
