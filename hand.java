/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THEHC;

/**
 *
 * @author ali9450
 */
class Hand {
    private int type;
    //9 Royal Flush
    //8 Straight Flush
    //7 Four of a Kind
    //6 Full House
    //5 Flush
    //4 Straight
    //3 Three of a Kind
    //2 Two Pair
    //1 Pair
    //0 High Card
    private int highest;
    private int otherhighcard;
    
    public Hand (int handtype, int highestvalue, int othercard){
        type = handtype;
        highest = highestvalue;
        otherhighcard = othercard;
    }
    
    
    public String toString() {
    
    String s = Integer.toString(type) + ", " +Integer.toString(highest);
    return s;
       
}
    
    public int getTypeInt (){
        int a = type;
        
        
     return a;
    }
    public int getHighest (){
    int b = highest;
    
    return b;
    }
    
    public String getHighestType (){
    String value = "";
    String[] ranks = {"Null", "Null", "2", "3", "4", "5", "6",
               "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        value = ranks[this.highest];
    
    return value;
    
    }
    public int getotherhighcard(){
    int c = otherhighcard;
    
    return c;
    }
    
    public String getotherhighcardString(){
    String value = "";
    String[] ranks = {"Null", "Null", "2", "3", "4", "5", "6",
               "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        value = ranks[this.otherhighcard];
    return value;
    }
    public String getType (){
        String a = "";
        if (type == 9) {
            a = "Royal Flush";
        }
        if (type == 8) {
            a = "Straight Flush";
        }
        if (type == 7) {
            a = "Four of a Kind";
        }
        if (type == 6) {
            a = "Full House";
        }
        if (type == 5) {
            a = "Flush";
        }
        if (type == 4) {
            a = "Straight";
        }
        if (type == 3) {
            a = "Three of a Kind";
        }
        if (type == 2) {
            a = "Two Pair";
        }
        if (type == 1) {
            a = "Pair";
        }
        if (type == 0) {
            a = "High Card";
        }
        
        
     return a;
    }
    
    
}










