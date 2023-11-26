package Task1;

import java.util.Scanner;

public class NumberGuessingGame {
	public static void guessingNumberGame(){
	       try (Scanner sc = new Scanner(System.in)) {
			int number = 1 + (int)(100* Math.random());
	        int K;
	        System.out.println("Enter the trial how many times you want: ");
	        K=sc.nextInt();
	        int i, guess;
	        
	        System.out.println("A number is" + " between 1 to 100." + "Guess the number" + " within " + K + " trials.");
	 
	        for (i = 0; i < K; i++) {
	        	System.out.println("Guess the number:");
	            guess = sc.nextInt();
	 
	            if (number == guess) {
	                System.out.println("Congratulations!" + " You guessed the number.");
	                break;
	            }
	            else if (number > guess
	                     && i != K - 1) {
	                System.out.println("The guess number is too low");
	            }
	            else if (number < guess
	                     && i != K - 1) {
	                System.out.println("The guess number is too high");
	            }
	            
	        }
	       sc.close();
	       
	        if (i == K) {
	            System.out.println("You have exhausted" +  K +" trials.");
	 
	            System.out.println("The number was " + number);
	        }
		}
	        
	    }
	
	    public static void main(String arg[])
	    { 
	        guessingNumberGame();
	    }
	    
}
