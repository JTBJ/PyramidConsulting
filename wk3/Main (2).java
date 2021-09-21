import java.util.Arrays;

public class Main {
    
    public static void waitTimer() throws InterruptedException {
        Thread.sleep(50);
    }

    public static void printMessage(String message) throws InterruptedException, ClassNotFoundException {

        String[] arr = message.split("");
        for (String s : arr) {
            System.out.print(s);
            waitTimer();
            if (s.equals("\n")) {
                Thread.sleep(2000);
            }
        }
    }

    public static void instructions() throws InterruptedException, ClassNotFoundException {

        String message = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tBATTLESHIPS\n\n" +
                "Battleship is a strategy type guessing game for two players.\n" +
                "It is played on ruled grids on which each player's fleet of ships are marked.\n" +
                "The locations of the fleets are concealed from the other player.\n" +
                "Players alternate turns calling shots at the other player's ships, and the objective of the game\n" + 
                "is to destroy the opposing player's fleet.\n" +
                "In this version of Battleship, each player will be granted three ships, one per grid.\n"+
                "When a player's ship is hit, a new grid will be asymboled and the players will remark the coordinates\n"+
                "of their ships. Once a player sinks three ships before having three of their ships sunk, they win.\n"+
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tBATTLESHIPS\n\n";

        printMessage(message);
    }
    
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
	    
	    Main m = new Main();
	    
	   // m.instructions();
	    PlayBattleShip.main(args);
	}
}
