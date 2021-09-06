import java.util.*;

public class GuessingGame {
    
    public static void waitTimer() throws InterruptedException {
        
        Thread.sleep(50);
    }
    
    public static void instructions() throws InterruptedException, ClassNotFoundException {
        
        String message = "The computer will think of a secret number from 1 to 20\n"+ 
                	    "and ask you to guess it. After each guess, the computer will\n"+
                	    "tell you whether the number is too high or too low. You win if\n"+
            	        "you can guess the number within six tries.\n\n";
        
        printMessage(message);
    }
    
    public static void printMessage(String message) throws InterruptedException, ClassNotFoundException {
        
        String[] arr = message.split("");
        for(String s : arr){
            System.out.print(s);
            waitTimer();
            if(s.equals("\n")){
                Thread.sleep(2000);
            }
        }
    }
    
    public static void guess(int num) throws InterruptedException, ClassNotFoundException {
        
        printMessage("Guess a number between 1 and 20.\n\n");
        
        Scanner scan = new Scanner(System.in);
        String guess = null;
        String hilo = null;
        int count = 6;
        int numOfGuesses = 1;
        
        try {
            do{
                guess = scan.nextLine();
                if(guess.equals(String.valueOf(num))) {
                    if(numOfGuesses == 1){
                        printMessage("Congradulations!!! You guessed the number in " + numOfGuesses + " try.\n\n");
                    }else{
                        printMessage("Congradulations!!! You guessed the number in " + numOfGuesses + " tries.\n\n");
                    }
                }else{
                    count--;
                    numOfGuesses++;
                    if((Integer.parseInt(guess)) > num){
                            hilo = "You guessed too hi.";
                        }else{
                            hilo = "You guessed too low.";
                        }
                    if(count == 1){
                        printMessage("Sorry, you guessed incorrectly. " + hilo + " You have " + count + " more guess.\n\n");
                    }else if(count == 0){
                        printMessage("Sorry, you guessed incorrectly. " + hilo + "  You have no more guesses.\n");
                        printMessage("The correct number was " + num + "\n\n");
                    }else{
                        printMessage("Sorry, you guessed incorrectly. " + hilo + "  You have " + count + " more guesses. Guess again.\n\n");
                    }
                }
 
            }while(!(guess.equals(String.valueOf(num)) || count == 0));
        } catch(Exception e) {
            printMessage("Invalid selection...\n\n");
            GuessingGame.main(new String[0]);
        }
        
    }
    
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
	    
	    Scanner scanner = new Scanner(System.in);

	    instructions();
	    
	    guess(new Random().nextInt(20));
	    
	    String response = null;
	    
	    do{
	        printMessage("Key in the character \"N\" on your key board to quit the game at this screen.\n");
	        response = scanner.nextLine();
	        if(response.equalsIgnoreCase("n")){
	            printMessage("Thanks for playing, goodbye for now!");
	            System.exit(0);
	        }else{
	            guess(new Random().nextInt(20));
	        }
	    }while(!(response.equalsIgnoreCase("n")));
	    
	}
}

// System.out.println(guess.getClass().getName());
// System.out.println(Integer.parseInt(guess).getClass.getName());
