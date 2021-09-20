

public class GunBattle {
    
    public void fight(String[][] grid, String[][] underGrid, int row, int col, String player){
        
        row--;
        col--;
        
        if(underGrid[row][col] != "*" && underGrid[row][col] != player){
            underGrid[row][col] = "X";
            System.out.println("Direct Hit!\n");
        }else{
            underGrid[row][col] = "~";
            System.out.print("Missed\n");
        }
       
    }
}