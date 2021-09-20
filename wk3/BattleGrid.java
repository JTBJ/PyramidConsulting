

public class BattleGrid {
    
    private String[][] grid;
    
    public BattleGrid() {
        grid = new String[15][15];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = "*";
            }
        }
    }
    
    public String[][] getGrid() {
        return grid;
    }
    
    public void displayGrid(String[][] grid) {
        for(String[] g : grid){
            for(String s : g){
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}