/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.michael.wargame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author maiyh
 */
public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();
    
    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                cards.add(new Card(suit, i));
            }
        }
    }
    
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card dealCard(){
        return cards.remove(0);
    }
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
