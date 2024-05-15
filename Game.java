import java.util.LinkedList;

public class Game {
    private LinkedList<Player> players;
    private Dealer dealer;
    private LinkedList<Card> dealerHand;

    public Game(int numPlayers) {
        this.players = new LinkedList<>();
        this.dealer = new Dealer();
        this.dealerHand = new LinkedList<>();

        // Create players
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
        }
    }

    public void play() {
        // Deal two cards to each player and the dealer
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.drawCard(dealer);
            }
            dealerHand.add(dealer.deal());
        }

        // Display initial hands
        System.out.println("Dealer's hand: [Hidden], " + dealerHand.get(1));
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + (i + 1) + "'s hand: " + players.get(i).getHand());
        }

        // Players' turn
        for (Player player : players) {
            while (player.getHandTotal() < 21 && player.wantsToHit()) {
                player.drawCard(dealer);
                System.out.println("Player's hand: " + player.getHand());
            }
        }

        // Dealer's turn
        while (dealer.getHandTotal() < 17) {
            dealerHand.add(dealer.deal());
        }
        System.out.println("Dealer's hand: " + dealerHand);

        // Determine winners
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (!player.isBusted()) {
                if (dealer.isBusted() || player.getHandTotal() > dealer.getHandTotal()) {
                    System.out.println("Player " + (i + 1) + " wins!");
                } else if (player.getHandTotal() < dealer.getHandTotal()) {
                    System.out.println("Player " + (i + 1) + " loses!");
                } else {
                    System.out.println("Player " + (i + 1) + " ties with dealer!");
                }
            } else {
                System.out.println("Player " + (i + 1) + " busts!");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(2); // Create a game with 2 players
        game.play(); // Start the game
    }
}
