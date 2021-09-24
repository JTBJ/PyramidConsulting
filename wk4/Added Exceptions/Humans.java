public class Humans {

    private char human = '\u1371';;

    public static Humans humans = new Humans();

    private int health = 20;

    private boolean hasTwoSwords;

    private int healthBoast = 10;

    private boolean hasShield;

    public static char[] temp = {'H', 'S', 'B'};



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isHasTwoSwords() {
        return hasTwoSwords;
    }

    public void setHasTwoSwords(boolean hasTwoSwords) {
        this.hasTwoSwords = hasTwoSwords;
    }

    public int getHealthBoast() {
        return healthBoast;
    }

    public void setHealthBoast(int healthBoast) {
        this.healthBoast = healthBoast;
    }

    public boolean isHasShield() {
        return hasShield;
    }

    public void setHasShield(boolean hasShield) {
        this.hasShield = hasShield;
    }

    public char getPlayer() {
        return human;
    }

    public void movement(char[][] gridGameBoard, String move) throws InterruptedException, ClassNotFoundException {

        switch (move){
            case "U":
            case "u":
                moveUp(gridGameBoard, new Humans().getPlayer());
                break;
            case "D":
            case "d":
                moveDown(gridGameBoard, new Humans().getPlayer());
                break;

            case "L":
            case "l":
                moveLeft(gridGameBoard, new Humans().getPlayer());
                break;

            case "R":
            case "r":
                moveRight(gridGameBoard, new Humans().getPlayer());
                break;
            case "Q":
            case "q":
                HumansVsGoblins.printMessage("You have been a good sport.\n");
                break;
            default:
                HumansVsGoblins.printMessage("Invalid moves causes you to lose that move and allows the Goblin to come closer.\n");
        }

    }

    public void moveUp(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

        int tempPosRow = 0;
        int row = 0;
        int col = 0;

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                if(gridGameWorld[i][j] == player){
                    try{
                        row = i;
                        col = j;
                    }catch (Exception e){
                        HumansVsGoblins.printMessage("You must move within the bounds of the grid. Remember the Goblin is trying to find you.\n");
                    }
                }
            }
        }

        if(row - 1 < 0){
            HumansVsGoblins.printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row - 1][col] == new Goblins().getPlayer()) {
                HumansVsGoblins.printMessage("Humans vs Goblins\n");
                doBattle();
                checkHealth();
                System.out.println();
                Goblins.goblins.toString();
                hasTwoSwords = false;
                hasShield = false;
            }else{
                for(char c : temp){
                    if (c == gridGameWorld[row - 1][col]){
                        if(c == 'H'){
                            setHealth(getHealth() + getHealthBoast());
                        }else if(c == 'S'){
                            hasTwoSwords = true;
                        }else if(c == 'B'){
                            hasShield = true;
                        }
                    }
                }
                gridGameWorld[row][col] = HumansVsGoblins.fill();
                gridGameWorld[--row][col] = player;
                HumansVsGoblins.displayBoard(gridGameWorld);
            }
        }
    }

    public void moveDown(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

        int row = 0;
        int col = 0;

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                if(gridGameWorld[i][j] == player){
                    row = i;
                    col = j;
                }
            }
        }

        if(row + 1 >= gridGameWorld.length){
            HumansVsGoblins.printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row + 1][col] == new Goblins().getPlayer()) {
                HumansVsGoblins.printMessage("Humans vs Goblins\n");
                doBattle();
                checkHealth();
                System.out.println();
                Goblins.goblins.toString();
                hasTwoSwords = false;
                hasShield = false;
            }else{
                for(char c : temp){
                    if (c == gridGameWorld[row + 1][col]){
                        if(c == 'H'){
                            setHealth(getHealth() + getHealthBoast());
                        }else if(c == 'S'){
                            hasTwoSwords = true;
                        }else if(c == 'B'){
                            hasShield = true;
                        }
                    }
                }
                gridGameWorld[row][col] = HumansVsGoblins.fill();
                gridGameWorld[++row][col] = player;
                HumansVsGoblins.displayBoard(gridGameWorld);
            }
        }
    }

    public void moveLeft(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

        int row = 0;
        int col = 0;

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                if(gridGameWorld[i][j] == player){
                    row = i;
                    col = j;
                }
            }
        }
        if(col - 1 < 0){
            HumansVsGoblins.printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row][col - 1] == new Goblins().getPlayer()) {
                HumansVsGoblins.printMessage("Humans vs Goblins\n");
                doBattle();
                checkHealth();
                System.out.println();
                Goblins.goblins.toString();
                hasTwoSwords = false;
                hasShield = false;
            }else{
                for(char c : temp){
                    if (c == gridGameWorld[row][col - 1]){
                        if(c == 'H'){
                            setHealth(getHealth() + getHealthBoast());
                        }else if(c == 'S'){
                            hasTwoSwords = true;
                        }else if(c == 'B'){
                            hasShield = true;
                        }
                    }
                }
                gridGameWorld[row][col] = HumansVsGoblins.fill();
                gridGameWorld[row][--col] = player;
                HumansVsGoblins.displayBoard(gridGameWorld);
            }
        }
    }

    public void moveRight(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

        int row = 0;
        int col = 0;

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                if(gridGameWorld[i][j] == player){
                    row = i;
                    col = j;
                }
            }
        }

        if(col + 1 >= gridGameWorld[row].length){
            HumansVsGoblins.printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row][col + 1] == new Goblins().getPlayer()) {
                HumansVsGoblins.printMessage("Humans vs Goblins\n");
                doBattle();
                checkHealth();
                System.out.println();
                Goblins.goblins.toString();
                hasTwoSwords = false;
                hasShield = false;
            }else{
                for(char c : temp){
                    if (c == gridGameWorld[row][col + 1]){
                        if(c == 'H'){
                            setHealth(getHealth() + getHealthBoast());
                        }else if(c == 'S'){
                            hasTwoSwords = true;
                        }else if(c == 'B'){
                            hasShield = true;
                        }
                    }
                }
                gridGameWorld[row][col] = HumansVsGoblins.fill();
                gridGameWorld[row][++col] = player;
                HumansVsGoblins.displayBoard(gridGameWorld);
            }
        }
    }

    public void doBattle(){
        if(hasShield){

        }else {
            health -= 3;
        }
        hasShield = false;

        if(hasTwoSwords){
            Goblins.goblins.setGoblinDamage(Goblins.goblins.getGoblinDamage() - 5);
        }else {
            Goblins.goblins.setGoblinDamage(Goblins.goblins.getGoblinDamage() - 3);
        }
    }

    public void checkHealth() throws InterruptedException, ClassNotFoundException {
        HumansVsGoblins.printMessage("Your human's health is: " + getHealth() + "\n");
        if(health <= 0){
            HumansVsGoblins.printMessage("Oh no, your human was defeated by the goblin.\n");
            HumansVsGoblins.main(new String[0]);
        }else if(Goblins.goblins.getGoblinDamage() <= 0){
            HumansVsGoblins.printMessage("You are an honorable worrier. You have defeated the goblin.\n");
            HumansVsGoblins.main(new String[0]);
        }
    }

    @Override
    public String toString() {
        return "Humans{" +
                "human=" + human +
                ", health=" + health +
                '}';
    }
}