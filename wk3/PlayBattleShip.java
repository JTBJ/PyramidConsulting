

public class PlayBattleShip {
    
    private BattleGrid gameGrid;
    
    private WarShips ship;
    
    GunBattle battle;
    
    public PlayBattleShip(){
        gameGrid = new BattleGrid();
        ship = new WarShips();
        battle = new GunBattle();
    }
    
    public BattleGrid getGameGrid(){
        return gameGrid;
    }
    
    public WarShips getShip(){
        return ship;
    }
    
    public GunBattle getBattle(){
        return battle;
    }
    
    public static void main(String[] args) {
        
        PlayBattleShip play = new PlayBattleShip();
        
        String[][] grid = play.getGameGrid().getGrid();
        
        String[][] grid1 = play.getGameGrid().getGrid();
        
        play.getGameGrid().displayGrid(grid);
        
        play.getShip().placeWarShipHorizontal(grid, 4, 13);
        
        play.getShip().placeWarShipVertical(grid, 15, 1);
        
        play.getGameGrid().displayGrid(grid);
        
        play.getBattle().fight(grid1, grid, 15, 1, "P1");
        
        play.getGameGrid().displayGrid(grid);
    }
}