/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michael.wargame;

/**
 *
 * @author maiyh
 */
public class Card {
    private String suit;
    private int rank;
    
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public String getSuit() {
        return suit;
    }
    public int getRank(){
        return rank ;
    }
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
