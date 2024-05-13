import java.util.LinkedList;

public class Player {
    private LinkedList<Card> hand;  // Using LinkedList for consistency with Dealer's methods
    private boolean isStanding;

    // Initialize Player
    public Player() {
        this.hand = new LinkedList<>();
        this.isStanding = false;
    }

    // Draw a card using the Dealer class
    public void drawCard(Dealer dealer) {
        if (!isStanding && dealer.size() > 0) {
            this.hand.add(dealer.deals(1).getFirst());
        }
    }

    // Calculate the total value of the player's hand
    public int getHandTotal() {
        int totalValue = 0;
        int aceCount = 0;

        for (Card card : hand) {
            int rank = card.getRank();
            if (rank == Card.ACE) { // Assuming Ace can be 1 or 11
                aceCount++;
                totalValue += 11;
            } else if (rank >= Card.JACK && rank <= Card.KING) { // Face cards are worth 10
                totalValue += 10;
            } else {
                totalValue += rank; // Numeric cards are worth their face value
            }
        }

        // Adjust for Aces if total is over 21
        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10; // Turn an Ace from 11 into 1
            aceCount--;
        }

        return totalValue;
    }

    // Stand method to stop drawing cards
    public void stand() {
        this.isStanding = true;
    }

    // Getter for the player's hand
    public LinkedList<Card> getHand() {
        return hand;
    }

    // Check if the player is standing
    public boolean isStanding() {
        return isStanding;
    }

    // Represent the player's hand as a String
    @Override
    public String toString() {
        return "Player's hand: " + hand.toString() + " | Total: " + getHandTotal();
    }
}
