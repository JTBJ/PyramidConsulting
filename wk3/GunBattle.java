

public class GunBattle {
    
    private boolean hasPassed;
    
    public void battleRules() throws InterruptedException, ClassNotFoundException {
        
        if(!hasPassed){
            new Main().printMessage("The rules of engagement are simple. Get three hits on the opponent before they get three hits\n"+
                "on your ships and win the game. After each hit, each opponent will set of a new ship position. Sink the\n"+
                "opponent before they sink you. Good luck...\n\n");
        }
        
        hasPassed = true;
    }
    
    public void fight(String[][] underGrid, int row, int col, Player player) throws InterruptedException, ClassNotFoundException {
        
        row--;
        col--;
        
        if(underGrid[row][col] != "*" && underGrid[row][col] != player.getPl()){
            underGrid[row][col] = "X";
            player.getGameGrid()[row][col] = "X";
            new BattleGrid().displayGrid(player.getGameGrid());
            new Main().printMessage("Direct Hit!\n\n");
            player.setHits(player.getHits() + 1);
            if(player.getHits() > 2){
                new Main().printMessage("Congratulations " + player.getPlayerName() + ", you sank your opponent's battleship!!!\n\n");
            }
        }else{
            underGrid[row][col] = "~";
            player.getGameGrid()[row][col] = "~";
            new BattleGrid().displayGrid(player.getGameGrid());
            new Main().printMessage("Missed\n\n");
        }
       
    }
}