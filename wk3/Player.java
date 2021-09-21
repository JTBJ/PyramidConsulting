

public class Player {
    
    private String playerName;
    
    private String pl;
    
    private int hits;
    
    private String[][] gameGrid;
    
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    public void setPl(String pl) {
        this.pl = pl;
    }
    
    public String getPl() {
        return pl;
    }
    
    public void setGameGrid(String[][] gameGrid) {
        this.gameGrid = gameGrid;
    }
    
    public String[][] getGameGrid() {
        return gameGrid;
    }
    
    public void setHits(int hits) {
        this.hits = hits;
    }
    
    public int getHits() {
        return hits;
    }
}