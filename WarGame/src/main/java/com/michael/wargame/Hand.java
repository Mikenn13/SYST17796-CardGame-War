/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michael.wargame;

import java.util.ArrayList;
/**
 *
 * @author maiyh
 */
public class Hand {
    private final ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }
    public Card playCard(){
        return cards.remove(0);
    }
    public int getSize() {
        return cards.size();
    }
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
