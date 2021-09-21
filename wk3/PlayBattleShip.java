import java.util.Scanner;

public class PlayBattleShip {
    
    //collaborators
    private BattleGrid gameGrid;
    
    private WarShips ship;
    
    private GunBattle battle;
    
    private Main main;
    
    //static variable to keep track of player
    private static final String player1 = "P1";
    private static final String player2 = "P2";
    private boolean hasPassed;
    private boolean beenPrompted;
    
    //create grid to track each player 
    private String[][] playerTracker;
    
    //initializing dependencies
    public PlayBattleShip(){
        gameGrid = new BattleGrid();
        ship = new WarShips();
        battle = new GunBattle();
        main = new Main();
        playerTracker = this.getGameGrid().getGrid();
    }
    
    //getters
    public BattleGrid getGameGrid(){
        return gameGrid;
    }
    
    public WarShips getShip(){
        return ship;
    }
    
    public GunBattle getBattle(){
        return battle;
    }
    
    public String[][] getPlayerTracker() {
        return playerTracker;
    }
    
    //prompt player for names and set their grid icons
    public Player createPlayers() throws InterruptedException, ClassNotFoundException {
        //initializing Scanner taking user input
        Scanner scan = new Scanner(System.in);
        
        Player[] player = new Player[2];
        
        if(!hasPassed){
            main.printMessage("Player " + player1 + " enter your name...\n");
            String playerOne = scan.nextLine();
            hasPassed = true;
            player[0] = new Player(playerOne);
            player[0].setPl(player1);
            return player[0];
        }else{
            main.printMessage("Player " + player2 + " enter your name...\n");
            String playerTwo = scan.nextLine();
            hasPassed = false;
            player[1] = new Player(playerTwo);
            player[1].setPl(player2);
            return player[1];
        }
    }
    
    //assign player an empty grid
    public void setPlayerInitGrid(Player player) {
        //grab a new game grid for the player
        String[][] playerGameGrid = this.getGameGrid().getGrid();
        player.setGameGrid(playerGameGrid);
    }
    
    //prompt player for coordinates and ship layout
    public void playerShipCoordinates(Player player) throws InterruptedException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        int row = 0;
        int col = 0;
        char alignment = ' ';
        
        /*if(!beenPrompted){
            main.printMessage(player.getPlayerName() + " You must choose your ship's coordinates. Coordinates are reflected by row and column position.\n"+
                "You will be prompted to enter coordinates for your ship's row position, column position and whether you want\n"+
                "the ship to be aligned vertically or horizontally.\n\n"+
                "When prompted, enter a number from 1 up to 15 for the row and column positions and an H or a V for vertical or\n"+
                "horizontal alignment.\n\n");
            beenPrompted = true;
        }*/
        
        try {
            main.printMessage(player.getPlayerName() + " Enter a number from 1 to 15 for row position...\n\n");
            row = scan.nextInt();
            
            main.printMessage(player.getPlayerName() + " Enter a number from 1 to 15 for column position...\n\n");
            col = scan.nextInt();
            
            //checking input
            if(!((row >= 1 && row <= 15) && (col >= 0 && col <= 15))){
                playerShipCoordinates(player);
            }
        } catch(Exception e) {
            main.printMessage(player.getPlayerName() + " You must enter a number from 1 to 15. Restart the process...\n\n");
            playerShipCoordinates(player);
        } finally {
        }
        
        try{
            scan = new Scanner(System.in);
            main.printMessage(player.getPlayerName() + " Enter an H for horizontal alignment or a V for vertical alignment of your battleship...\n\n");
            alignment = scan.next().charAt(0); 
            
            //checking input
            if(!((alignment == 'H') || (alignment == 'h') || (alignment == 'V') || (alignment == 'v'))){
                main.printMessage(player.getPlayerName() + " You must enter a single character H or V. Restart the process...\n\n");
                playerShipCoordinates(player);
            }
        }catch(Exception e){
            main.printMessage(player.getPlayerName() + " You must enter a single character H or V. Restart the process...\n\n");
            playerShipCoordinates(player);
        }
        
        setPlayerShips(player, row, col, alignment);
    }
    
    //call method to postion ships on the grid
    public void setPlayerShips(Player player, int row, int col, char layout) throws InterruptedException, ClassNotFoundException {
        if(layout == 'V' || layout == 'v'){
            this.getShip().placeWarShipVertical(playerTracker, player, row, col);
        }else{
            this.getShip().placeWarShipHorizontal(playerTracker, player, row, col);
        }
    }
    
    //main
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        
        //instatiate class / initializing dependencies
        PlayBattleShip play = new PlayBattleShip();
        
        //set up player's names and icons 
        Player playerOne = play.createPlayers();
        Player playerTwo = play.createPlayers();
        
        play.main.printMessage("One moment while we set things up...\n\n");
        
        //introducing players to their grid icons
        play.main.printMessage(playerOne.getPlayerName() + " your icon is " + playerOne.getPl() + "\n");
        play.main.printMessage(playerTwo.getPlayerName() + " your icon is " + playerTwo.getPl() + "\n\n");
        
        String playing = "";
        
        do{
            do{
                //setup players grids
                play.setPlayerInitGrid(playerOne);
                play.setPlayerInitGrid(playerTwo);
                
                //prompt player for coordinates and ship layout
                play.playerShipCoordinates(playerOne);
                play.playerShipCoordinates(playerTwo);
                
                play.getGameGrid().displayGrid(playerOne.getGameGrid());
                play.main.printMessage(playerOne.getPlayerName() + "'s war grid...\n\n");
                Thread.sleep(3000);
                
                play.getGameGrid().displayGrid(playerTwo.getGameGrid());
                play.main.printMessage(playerTwo.getPlayerName() + "'s war grid...\n\n");
                Thread.sleep(3000);
                
                // play.getBattle().battleRules();
                
                do{
                    Scanner scan = new Scanner(System.in);
        
                    try{
                        play.main.printMessage(playerOne.getPlayerName() + " enter a row coordinate from 1 up to 15...\n");
                        int row = scan.nextInt();
                        play.main.printMessage(playerOne.getPlayerName() + " enter a col coordinate from 1 up to 15...\n");
                        int col = scan.nextInt();
                        play.getBattle().fight(play.getPlayerTracker(), row, col, playerOne);
                        play.main.printMessage(playerTwo.getPlayerName() + " enter a row coordinate from 1 up to 15...\n");
                        row = scan.nextInt();
                        play.main.printMessage(playerOne.getPlayerName() + " enter a col coordinate from 1 up to 15...\n");
                        col = scan.nextInt();
                        play.getBattle().fight(play.getPlayerTracker(), row, col, playerTwo);
                    }catch(Exception e){
                        play.main.printMessage("Oops. You've entered an invalid coordinate. Loose a turn...\n\n");
                    }
                }while((playerOne.getHits() < 1) || (playerTwo.getHits() < 1));
        
                play.main.printMessage("Seems you have knocked another ship out of the sea...Congratulations...\n\n");
                
                play.main.printMessage("Here are the postions of the war ships in the previous battle...");
                play.getGameGrid().displayGrid(play.getPlayerTracker());
                
            }while(playerOne.getHits() < 2 || playerTwo.getHits() < 2);
            
            String winner = (playerOne.getHits() > 2) ? playerOne.getPlayerName() : playerTwo.getPlayerName();
            
            play.main.printMessage(winner + " you are the king of the sea...Nice going hause...\n\n");
            
            Scanner scan = new Scanner(System.in);
            
            play.main.printMessage("Would you like to continue playing?\n"+
                                "Enter \"Y\" for yes and any key for no...\n");
            try{
                playing = scan.nextLine();
            }catch(Exception e){
                play.main.printMessage("Invalid\n\n");
            }
        }while(playing.equalsIgnoreCase("Y"));
        
        //displaying the game grid 
        // play.getGameGrid().displayGrid(grid);
        
        // play.getShip().placeWarShipHorizontal(grid, 4, 13);
        
        // play.getShip().placeWarShipVertical(grid, 15, 1);
        
        // play.getGameGrid().displayGrid(grid);
        
        // play.getBattle().fight(grid1, grid, 15, 1, "P1");
        
        // play.getGameGrid().displayGrid(grid);
        
        //play.getGameGrid().displayGrid(playerTwo.getGameGrid());
    }
}