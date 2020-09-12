package THEHC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Zaverot
 */
class PokerComparator implements Comparator<Integer>
{
	 public int compare(final int s1, final int s2, final ArrayList<Card> list) {
         final int rank1 = s1;
         final int rank2 = s2;
         return rank1 - rank2;
     }

     @Override
     public int compare(final Integer o1, final Integer o2) {
         throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                        // Tools | Templates.
     }

 }

 public class main {

     public static void newdeck(final ArrayList<Card> list) {

         for (int i = 0; i < 4; i++) {
             for (int j = 1; j < 14; j++) {

                 final Card temp = new Card(j, i, false, "");
                 list.add(temp);
             }

         }
     }

     public static void drawrandomcard(final ArrayList<Card> list, final ArrayList<Card> hand, final boolean show) {
         final Random rand = new Random();
         final int n = rand.nextInt(list.size());

         if (show == true) {
             System.out.println(list.get(n).toString());
         } else if (show == false) {
             // System.out.println("");
         }

         hand.add(list.get(n));
         list.remove(n);
     }

     public static void drawcard(final ArrayList<Card> list, final ArrayList<Card> hand, final boolean show) {

         final int n = 0;

         if (show == true) {
             System.out.println(list.get(n).toString());
         } else if (show == false) {
             System.out.println();

         }
         hand.add(list.get(n));
         list.remove(n);
     }

     public static void showtable(final ArrayList<Card> deck, final ArrayList<Card> table) {
         System.out.println("The cards on the table currently are: ");
         System.out.println("-----------------------------------------------------------");
         for (final Card card : table) {
             System.out.println(card.toString());

         }
         System.out.println("-----------------------------------------------------------");
     }

     public static Hand wincondition(final ArrayList<Card> hand, final ArrayList<Card> table) {
         final ArrayList<String> handnames = new ArrayList<>();
         final ArrayList<String> suitnames = new ArrayList<>();
         final ArrayList<Card> bighand = new ArrayList<>();
         final ArrayList<Card> straightarray = new ArrayList<>();
         final ArrayList<Card> rankssorted = new ArrayList<>();
         final ArrayList<Card> sizedflush = new ArrayList<>();
         final ArrayList<Card> suitssorted = new ArrayList<>();
         // ArrayList<Card> rankssorted = new ArrayList<>();
         final ArrayList<Card> suitsandranksorted = new ArrayList<>();

         bighand.clear();
         rankssorted.clear();
         sizedflush.clear();
         suitssorted.clear();

         for (final Card card : hand) {
             bighand.add(card);
         }
         for (final Card card : table) {
             bighand.add(card);
         }
         for (final Card card : bighand) {
             card.settrue();
         }
         Collections.sort(bighand, Card.CardValue);
         for (final Card card : bighand) {
             rankssorted.add(card);
         }
         for (final Card card : bighand) {
             final int tempsuit = card.getSuitint();
             for (int i = 1; i <= 4; i++) {
                 for (final Card card1 : bighand) {
                     if (card1.getSuitint() == i && card1.getcheckedstatus()) {
                         suitssorted.add(card1);
                         card1.setfalse();
                     }
                 }
             }
         }

         // Flush checker
         boolean flush = false;
         int counter = 0;
         int cardcounter = 1;
         int highFlushValue = 0;
         final boolean suitchecked = false;

         while (cardcounter < 5 && counter < 5) {
             counter = 0;

             for (final Card card : suitssorted) {

                 if (card.getSuitint() == cardcounter) {
                     counter++;

                 }
             }
             cardcounter++;
         }

         if (counter >= 5) {
             flush = true;
             highFlushValue = rankssorted.get(rankssorted.size() - 1).getvalue();
             for (final Card card : suitssorted) {
                 if (card.getSuitint() == cardcounter - 1) {
                     sizedflush.add(card);
                 }
             }
         }

         else if (counter < 5) {
             flush = false;
         }

         boolean straightFlush = false;
         boolean royalFlush = false;
         int highSFValue = 0;
         int highStraightValue = 0;
         final int temphighStraight = 0;
         final int straightcounter = 0;
         boolean straight = false;

         if (flush == true) {
             int i = 14;
             while (i > 5 && straightFlush == false) {
                 if (sizedflush.contains(new Card(i)) && sizedflush.contains(new Card(i - 1))
                         && sizedflush.contains(new Card(i - 2)) && sizedflush.contains(new Card(i - 3))
                         && sizedflush.contains(new Card(i - 4))) {
                     straightFlush = true;
                     highSFValue = i;
                 }

                 i--;
             }
             if (highSFValue == 14) {
                 royalFlush = true;
             }

         }

         if (flush == false) {
             int j = 14;
             while (j > 5 && straight == false) {
                 if (rankssorted.contains(new Card(j)) && rankssorted.contains(new Card(j - 1))
                         && rankssorted.contains(new Card(j - 2)) && rankssorted.contains(new Card(j - 3))
                         && rankssorted.contains(new Card(j - 4))) {
                     straight = true;
                     highStraightValue = j;
                 }

                 j--;
             }

         }

         // test for multiple cards
         int sameCards = 1;
         int sameCards2 = 1;
         final int n = 1;
         int largegroupRank = 0;
         int smallgroupRank = 0;
         int multiCounter = 0;
         boolean fourkind = false;
         int highFourValue = 0;
         boolean fullhouse = false;
         int highFullHouse = 0;
         boolean threekind = false;
         int highThreeValue = 0;
         boolean twopair = false;
         int highTwoPair = 0;
         boolean pair = false;
         int highPairValue = 0;

         sameCards = 1;
         sameCards2 = 1;
         largegroupRank = 0;
         smallgroupRank = 0;

         for (int i = 14; i >= 1; i--) {
             for (final Card card : rankssorted) {
                 if (card.getvalue() == i) {
                     multiCounter++;
                 }
             }
             if (multiCounter > sameCards) {

                 if (sameCards != 1) {

                     sameCards2 = sameCards;
                     smallgroupRank = largegroupRank;
                 }
                 sameCards = multiCounter;
                 largegroupRank = i;

             } else if (multiCounter > sameCards2) {
                 sameCards2 = multiCounter;
                 smallgroupRank = i;
             }

             multiCounter = 0;
         }

         // System.out.println(multiCounter);
         // System.out.println(sameCards);
         if (sameCards == 4 || sameCards2 == 4) {
             fourkind = true;
             if (sameCards == 4) {
                 highFourValue = largegroupRank;
             }
             if (sameCards2 == 4) {
                 highFourValue = smallgroupRank;
             }
         }
         if ((sameCards == 3 && sameCards2 == 2) || (sameCards2 == 3 && sameCards == 2)) {
             fullhouse = true;
             if (sameCards == 3 && sameCards2 == 2) {
                 highFullHouse = largegroupRank;
             }
             if (sameCards2 == 3 && sameCards == 2) {
                 highFullHouse = smallgroupRank;
             }

         }
         if ((sameCards == 3 && sameCards2 != 2) || (sameCards2 == 3 && sameCards != 2)) {
             threekind = true;
             if (sameCards == 3 && sameCards2 != 2) {
                 highThreeValue = largegroupRank;
             }
             if (sameCards2 == 3 && sameCards != 2) {
                 highThreeValue = smallgroupRank;
             }
         }

         if (sameCards == 2 && sameCards2 == 2) {
             twopair = true;
             highTwoPair = largegroupRank;
         }
         if ((sameCards == 2 && sameCards2 < 2) || (sameCards2 == 2 && sameCards < 2)) {
             pair = true;
             highPairValue = largegroupRank;
         }

         final int otherhighcard = 0;
         final int hccounter = 0;

         int handa = 0;
         int handb = 0;

         if (royalFlush) {
             handa = 9;
             handb = highSFValue;
         } else if (straightFlush) {
             handa = 8;
             handb = highSFValue;
         } else if (fourkind) {
             handa = 7;
             handb = highFourValue;
         } else if (fullhouse) {
             handa = 6;
             handb = highFullHouse;
         } else if (flush) {
             handa = 5;
             handb = highFlushValue;
         } else if (straight) {
             handa = 4;
             handb = highStraightValue;
         } else if (threekind) {
             handa = 3;
             handb = highThreeValue;
         } else if (twopair) {
             handa = 2;
             handb = highTwoPair;
         } else if (pair) {
             handa = 1;
             handb = highPairValue;
         } else if (!royalFlush && !straightFlush && !fourkind && !fullhouse && !flush && !straight && !threekind
                 && !twopair && !pair) {
             handa = 1;
             handb = otherhighcard;
         }
         int handc = 0;
         // this part determines the next highest card, incase there is a tie
         if ((hand.get(0).getvalue() != handb) && hand.get(0).getvalue() > hand.get(1).getvalue()) {
             handc = hand.get(0).getvalue();
         }
         if ((hand.get(0).getvalue() != handb) && hand.get(0).getvalue() < hand.get(1).getvalue()
                 && (hand.get(1).getvalue() == handb)) {
             handc = hand.get(0).getvalue();
         }
         else if (hand.get(0).getvalue() < hand.get(1).getvalue()) {
             handc = hand.get(1).getvalue();
         }

         final Hand winthing = new Hand(handa, handb, handc);
         return winthing;
     }

     public static void compareHands(final Hand a, final Hand b) {
         if (a.getTypeInt() > b.getTypeInt()) {
             System.out.println(" You won with a : " + a.getType());
         } else if (b.getTypeInt() > a.getTypeInt()) {
             System.out.println("The dealer won with a : " + b.getType());
         } else if (a.getTypeInt() == b.getTypeInt()) {
             if (a.getHighest() > b.getHighest()) {
                 System.out.println("You won with a " + a.getType() + " with high card " + a.getHighestType());
             }
             if (a.getHighest() < b.getHighest()) {
                 System.out.println("The dealer won with a " + b.getType() + " with high card " + b.getHighestType());
             }
             if (a.getHighest() == b.getHighest()) {
                 if (a.getotherhighcard() > b.getotherhighcard()) {
                     System.out.println("You won with a " + a.getType() + " with another high card of "
                             + a.getotherhighcardString());
                 }
                 if (a.getotherhighcard() < b.getotherhighcard()) {
                     System.out.println("The dealer won with a " + b.getType() + " with another high card of "
                             + b.getotherhighcardString());
                 }
                 if (a.getotherhighcard() == b.getotherhighcard()) {
                     System.out.println("There's a tie! somehow...");
                 }
             }
         }

     }

     /**
      * @param args the command line arguments
      */

     public static void main(final String[] args) {
         final ArrayList<Card> deck = new ArrayList<>();
         final ArrayList<Card> playerhand = new ArrayList<>();
         final ArrayList<Card> dealerhand = new ArrayList<>();
         final ArrayList<Card> table = new ArrayList<>();
         final ArrayList<Card> testdeck = new ArrayList<>();

         int choice = 0;
         boolean roundover = false;
         boolean playgame = true;
         final int turncount = 1;
         int playerchoice;
         boolean keepGoing = true;
         final String fold = "Please enter 1 to continue or 2 to fold: ";
         final Scanner s = new Scanner(System.in);
         final Hand folded = new Hand(0, 0, 0);
         int gameChoice;

         do {
             newdeck(deck);
             playerhand.clear();
             table.clear();
             dealerhand.clear();
             choice = 0;
             roundover = false;
             playgame = true;
             keepGoing = true;

             System.out.println("Welcome to poker. The goal of the game is to get the best hand :");

             System.out.println("You have been dealt the: ");
             System.out.println("-----------------------------------------------------------");
             drawrandomcard(deck, playerhand, true);
             drawrandomcard(deck, playerhand, true);
             System.out.println("-----------------------------------------------------------");

             System.out.println("The dealer has been dealt two cards: ");
             drawrandomcard(deck, dealerhand, false);
             drawrandomcard(deck, dealerhand, false);

             drawrandomcard(deck, table, false);
             drawrandomcard(deck, table, false);
             drawrandomcard(deck, table, false);
             do {
                 showtable(deck, table);
                 System.out.println(fold);
                 playerchoice = s.nextInt();
                 if (playerchoice == 1) {

                     drawrandomcard(deck, table, false);
                     System.out.println("A card has been added to the table.");
                 }
                 if (playerchoice == 2) {
                     keepGoing = false;
                     while (table.size() <= 4) {
                         drawrandomcard(deck, table, keepGoing);
                         System.out.println("A card has been added to the table.");

                     }
                     showtable(deck, table);

                 }
                 if (table.size() == 5) {
                     roundover = true;
                 }

             } while (!roundover && keepGoing);
             if (keepGoing == true) {
                 System.out.println("You have:");
                 System.out.println("-----------------------------------------------------------");
                 for (final Card card : playerhand) {
                     System.out.println(card.toString());
                 }
                 System.out.println("-----------------------------------------------------------");
                 System.out.println("Dealer has: ");
                 System.out.println("-----------------------------------------------------------");
                 for (final Card card : dealerhand) {
                     System.out.println(card.toString());
                 }
                 System.out.println("-----------------------------------------------------------");
                 showtable(deck, table);
                 compareHands(wincondition(playerhand, table), wincondition(dealerhand, table));
             }

             if (playerchoice == 2) {
                 System.out.println("Dealer has: ");
                 System.out.println("-----------------------------------------------------------");
                 for (final Card card : dealerhand) {
                     System.out.println(card.toString());
                 }
                 System.out.println("-----------------------------------------------------------");
                 compareHands(folded, wincondition(dealerhand, table));
             }

             System.out.println("Would you like to play again? Press 1 for yes and 2 for no:");
             gameChoice = s.nextInt();
             if (gameChoice == 1) {
                 playgame = true;
             }
             if (gameChoice == 2) {
                 playgame = false;
             }

         } while (playgame);

         System.out.println("Goodbye!");

        

     }

     public int compare(final Integer o1, final Integer o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}















