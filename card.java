/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THEHC;

import java.util.Comparator;

/**
 *
 * @author ali9450
 */
class Card implements Comparator<Card>{
    private int suit;
    //clubs 0 diamonds 1 hearts 2 spades 3
    private int rank;
    //Ace 1,2,...Queen 12, King 13
    private boolean checked = false;
    private String owner;
    
    public Card(int rank){
    
    if (rank == 1) {
            this.rank = 14;
        }
        else if (rank !=1) {
            this.rank = rank;
        }
    }
    
     @Override
  public boolean equals(Object object) {
           boolean sameSame = false;

         if (object != null && object instanceof Card) {
             sameSame = (this.getvalue() == ((Card) object).getvalue());
         }

     return sameSame;
  }
    @Override
public int hashCode() {
    return this.getvalue();
}   
    public Card(int rank, int suit, boolean checked, String owner){
    
        if (rank == 1) {
            this.rank = 14;
        }
        else if (rank !=1) {
            this.rank = rank;
        }
        
        
        
    this.suit = suit;
    
    }
    @Override
    public String toString() {
    String[] ranks = {"Null", "Null", "2", "3", "4", "5", "6",
               "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String s = ranks[this.rank] + " of " + suits[this.suit];
    return s;
}
    
    public int setValue (){
    int newvalue = 1;
    
        
    
    return newvalue;
    }
    public void setOwner (String own){
    
    
    owner = own;
    }
    
    
    
      public static Comparator<Card> CardValue = new Comparator<Card>() {

	public int compare(Card s1, Card s2) {

	   int rollno1 = s1.getvalue();
	   int rollno2 = s2.getvalue();

	   /*For ascending order*/
	   return rollno1-rollno2;

	   /*For descending order*/
	   //rollno2-rollno1;
   }};
    
    
    public String getName(){
    
    
    String[] ranks = {"Null", "Null", "2", "3", "4", "5", "6",
               "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String name = ranks[this.rank];
    return name;
    }
    
    public String getSuit(){
    
    
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String suit = suits[this.suit];
    return suit;
    }
    
    public int getSuitint(){
    
    
    int[] suits = {1, 2, 3, 4};
    int suit = suits[this.suit];
    return suit;
    }
    public String getOwner(){
    return owner;
    }
    
    public void setfalse(){
    checked = false;
    
    }
    
    public void settrue(){
    checked = true;
    
    }
    
    public Boolean getcheckedstatus(){
    return checked;
    }
    
    
    
    public int getvalue(){
    int value = 0;
    // String[] ranks = {"Null", "Null", "2", "3", "4", "5", "6",
    //            "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        value = this.rank;
    
    return value;
    }
    
   
    
     

    

    @Override
    public int compare(Card o1, Card o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
   

   
    
    
    
}















