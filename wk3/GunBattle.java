

public class GunBattle {
    
    private boolean hasPassed;
    
    public void battleRules() {
        
        if(!hasPassed){
            System.out.println("The rules of engagement are simple. Get three hits on the opponent before they get three hits\n"+
                "on your ships and win the game. After each hit, each opponent will set of a new ship position. Sink the\n"+
                "opponent before they sink you. Good luck...\n");
        }
        
        hasPassed = true;
    }
    
    public void fight(String[][] underGrid, int row, int col, Player player){
        
        row--;
        col--;
        
        if(underGrid[row][col] != "*" && underGrid[row][col] != player.getPl()){
            underGrid[row][col] = "X";
            player.getGameGrid()[row][col] = "X";
            new BattleGrid().displayGrid(player.getGameGrid());
            System.out.println("Direct Hit!\n");
            player.setHits(player.getHits() + 1);
            if(player.getHits() > 2){
                System.out.println("Congratulations " + player.getPlayerName() + ", you sank your opponent's battleship!!!\n");
            }
        }else{
            underGrid[row][col] = "~";
            player.getGameGrid()[row][col] = "~";
            new BattleGrid().displayGrid(player.getGameGrid());
            System.out.print("Missed\n");
        }
       
    }
}