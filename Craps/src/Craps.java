import java.util.Calendar;
import java.util.Scanner;

public class Craps
	{
        static int sum;
        static int dice1;
        static int dice2;
        static int balance = 100;
        static int bet;
        static String name; 
        static boolean keepGoing = true;
		public static void main(String[] args)
			{
				greeting();				
			    Scanner userInput2 = new Scanner(System.in);
			    System.out.println("You have $100 now. How much money do you want to bet?");
			    bet = userInput2.nextInt();
			   
			    rollDice();			    
			    if (sum == 7 || sum == 11) 
			    	{
			    System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + sum + ". Instant win, " + name + "! You have $" + win() + " now.");	   
			    } else if (sum == 2 || sum == 12) 
			    	{
				    System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + sum + ". Too bad, " + name + ". Instant lose. You have $" + lose() + " now.");
				    boolean keepGoing = false;
				} else {
					System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + sum + ". Nothing happens, " + name + ". Let's reroll.");
				}			    
			    while( keepGoing ) {
			    	rollDice();
			         if (sum == 7){
			        	 System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + sum + ". Too bad, " + name + ". You lose. You have $" + lose() + " now.");
			        	 lose();
			        	 keepGoing = false;
			         } else if (sum == 8){
			        	 System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + sum + ". You win, " + name + "! You have $" + win() + " now.");
			        	 win();
			        	 keepGoing = false;
			         } else {
			        	 System.out.println("You rolled a " + dice1 + " and a " + dice2 + " for a total of " + sum + ". Reroll, " + name + ". You have $" + balance + " now.");
			         }
			      }
			    System.out.println("You now have $" + balance + ", " + name + ".");
			}
		public static void greeting(){
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			String phrase;
			if (hour < 12){
				phrase = "Good morning";
			} else if (hour < 17){
				phrase = "Good afternoon";
			} else {
				phrase = "Good evening";
			}
			Scanner userInput = new Scanner(System.in);
		    System.out.println(phrase + ", what is your name?");
		    name = userInput.nextLine();
		    System.out.println("Hello, " + name + "!");
		}
		public static int rollDice(){
	         dice1 = (int)(Math.random()*6)+1;
	         dice2 = (int)(Math.random()*6)+1;
	         sum = dice1 + dice2;
	        return sum;
	    }
		public static int win(){
			balance = balance + bet;
			return balance;
		}
		public static int lose(){
			balance = balance - bet;
			return balance;
		}
 

}