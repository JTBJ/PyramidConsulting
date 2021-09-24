import java.util.*;

public class TicTacToe {
    
    public static ArrayList<Integer> playersPos = new ArrayList<Integer>();
    public static ArrayList<Integer> aiPos = new ArrayList<Integer>();
    
    public static void printBoard(char[][] board){
        for(char[] row : board){
            for(char c : row){ 
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static void placeMark(char[][] board, int coordinates, String user){
        
        char symbol = ' ';
        
        if(user.equalsIgnoreCase("player")){
            symbol = 'X';
            playersPos.add(coordinates);
        }
        if(user.equalsIgnoreCase("ai")){
            symbol = 'O';
            aiPos.add(coordinates);
        }
        
        switch(coordinates){
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
            default:
                System.out.println("Invalid entry. You must enter a number from 1 to 9");
        }
        printBoard(board);
    }
    
    public static String gameOver(){
        
        List row1 = Arrays.asList(1, 2, 3);
        List row2 = Arrays.asList(4, 5, 6);
        List row3 = Arrays.asList(7, 8, 9);
        List col1 = Arrays.asList(1, 4, 7);
        List col2 = Arrays.asList(2, 5, 8);
        List col3 = Arrays.asList(3, 6, 9);
        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(3, 5, 7);
        
        List<List> win = new ArrayList<>();
        win.add(row1);
        win.add(row2);
        win.add(row3);
        win.add(col1);
        win.add(col2);
        win.add(col3);
        win.add(diag1);
        win.add(diag2);
        
        for(List c : win){
            if(playersPos.containsAll(c)){
                return "Congratulations you won!!";
            }
            if(aiPos.containsAll(c)){
                return "The computer wins.";
            }
            if(playersPos.size() + aiPos.size() == 9){
                return "This game ends in a tie.";
            }
        }
        return "";
    }
    
	public static void main(String[] args) {
	    
        char[][] board = {
                         {' ', '|', ' ', '|', ' '}, 
                         {'-', '+', '-', '+', '-'},
                         {' ', '|', ' ', '|', ' '},
                         {'-', '+', '-', '+', '-'},
                         {' ', '|', ' ', '|', ' '},
                         };
        
        printBoard(board);
        
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a position 1-9");
            
            int coordinates = o;
            
            try {
                coordinates = scan.nextInt();
            } catch(Exception e) {
                System.out.println("Invalid. You must enter a number. Try again...");
                main(args);
            } finally {
            }
            
            while(playersPos.contains(coordinates) || aiPos.contains(coordinates)){
                System.out.println("Position taken! Enter a valid coordinate.");
                
                try {
                    coordinates = scan.nextInt();
                } catch(Exception e) {
                    System.out.println("Invalid. You must enter a number. Try again...");
                    main(args);
                } finally {
                }
                placeMark(board, coordinates, "Player");
                
                Random rand = new Random();
                
                int aiCoordinates = rand.nextInt(9) + 1;
                
                while(playersPos.contains(aiCoordinates) || aiPos.contains(aiCoordinates)){
                    System.out.println("Position taken! Enter a valid coordinate.");
                    aiCoordinates = rand.nextInt(9) + 1;
                }
            
                placeMark(board, aiCoordinates, "ai");
                
                printBoard(board);
                
                System.out.println(gameOver());
            }
    	}
    }
}
