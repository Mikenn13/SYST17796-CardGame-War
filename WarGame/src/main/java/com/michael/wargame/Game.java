package com.michael.wargame;

/**
 * Game logic for War card game
 * @author Team
 */
public class Game {
    private Hand player1;
    private Hand player2;
    private Deck deck;

    public void startGame() {
        deck = new Deck();
        deck.shuffle();

        player1 = new Hand();
        player2 = new Hand();
        
        // Deal all cards to players
        while (!deck.isEmpty()) {
            player1.addCard(deck.dealCard());
            if (!deck.isEmpty()) {
                player2.addCard(deck.dealCard());
            }
        }
        
        System.out.println("=== WAR CARD GAME STARTED ===\n");
        playGame();
    }
    
    private void playGame() {
        int roundCount = 0;
        int maxRounds = 1000;
        
        while (!player1.isEmpty() && !player2.isEmpty() && roundCount < maxRounds) {
            System.out.println("---- Round " + (roundCount + 1) + " ----");
            playRound();
            roundCount++;
        }
        
        // Determine winner
        System.out.println("\n=== GAME ENDED ===");
        System.out.println("Total rounds played: " + roundCount);
        if (player1.isEmpty()) {
            System.out.println("🎉 PLAYER 2 WINS THE GAME! 🎉");
        } else if (player2.isEmpty()) {
            System.out.println("🎉 PLAYER 1 WINS THE GAME! 🎉");
        } else {
            System.out.println("❌ DRAW - Game exceeded max rounds (1000)");
        }
    }
    
    private void playRound() {
        Card c1 = player1.playCard();
        Card c2 = player2.playCard();
        
        System.out.println("Player 1 plays: " + c1 + " (Hand size: " + player1.getSize() + ")");
        System.out.println("Player 2 plays: " + c2 + " (Hand size: " + player2.getSize() + ")");
        
        if (c1.getRank() > c2.getRank()) {
            player1.addCard(c1);
            player1.addCard(c2);
            System.out.println("✓ Player 1 wins round!\n");
        } else if (c2.getRank() > c1.getRank()) {
            player2.addCard(c1);
            player2.addCard(c2);
            System.out.println("✓ Player 2 wins round!\n");
        } else {
            handleWar(c1, c2);
        }
    }
    
    private void handleWar(Card c1, Card c2) {
        System.out.println("⚔️  WAR! ⚔️ Cards are equal!");
        
        java.util.ArrayList<Card> warPile1 = new java.util.ArrayList<>();
        java.util.ArrayList<Card> warPile2 = new java.util.ArrayList<>();
        
        warPile1.add(c1);
        warPile2.add(c2);
        
        boolean warResolved = false;
        
        while (!warResolved && !player1.isEmpty() && !player2.isEmpty()) {
            // Each player puts 3 cards face down (or fewer if not enough cards)
            for (int i = 0; i < 3; i++) {
                if (!player1.isEmpty()) {
                    warPile1.add(player1.playCard());
                }
                if (!player2.isEmpty()) {
                    warPile2.add(player2.playCard());
                }
            }
            
            // Then one face up card
            if (player1.isEmpty() || player2.isEmpty()) {
                break;
            }
            
            Card warCard1 = player1.playCard();
            Card warCard2 = player2.playCard();
            warPile1.add(warCard1);
            warPile2.add(warCard2);
            
            System.out.println("  War card P1: " + warCard1);
            System.out.println("  War card P2: " + warCard2);
            
            if (warCard1.getRank() > warCard2.getRank()) {
                for (Card card : warPile1) {
                    player1.addCard(card);
                }
                for (Card card : warPile2) {
                    player1.addCard(card);
                }
                System.out.println("  ✓ Player 1 wins the war!\n");
                warResolved = true;
            } else if (warCard2.getRank() > warCard1.getRank()) {
                for (Card card : warPile1) {
                    player2.addCard(card);
                }
                for (Card card : warPile2) {
                    player2.addCard(card);
                }
                System.out.println("  ✓ Player 2 wins the war!\n");
                warResolved = true;
            } else {
                System.out.println("  Another war! Continuing...");
            }
        }
    }
}
