import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HumansVsGoblins {

    public static char[][] drawGrid(){
        Random rand = new Random();

        char[][] gridGameWorld = new char[10][10];

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                gridGameWorld[i][j] = new Water().getWater();
            }
        }

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                gridGameWorld[rand.nextInt(9) + 1][rand.nextInt(9) + 1] = Land.lad.getLand();
            }
        }

        Land.lad.setGoblinFrenzy(gridGameWorld);

        Land.lad.setHumanInventory(gridGameWorld);

        gridGameWorld[rand.nextInt(9) + 1][rand.nextInt(9) + 1] = Goblins.goblins.getPlayer();

        gridGameWorld[rand.nextInt(9) + 1][rand.nextInt(9) + 1] = Humans.humans.getPlayer();

        for(char[] row : gridGameWorld){
            for(char c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }

        return gridGameWorld;
    }

    public static void displayBoard(char[][] gridGameWorld){
        for(char[] row : gridGameWorld){
            for(char c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }

    public static void waitTimer() throws InterruptedException {
        Thread.sleep(50L);
    }

    public static void printMessage(String message) throws InterruptedException, ClassNotFoundException {
        String[] arr = message.split("");
        String[] var2 = arr;
        int var3 = arr.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String s = var2[var4];
            System.out.print(s);
            waitTimer();
            if (s.equals("\n")) {
                Thread.sleep(2000L);
            }
        }

    }

    public static void instructions() throws InterruptedException, ClassNotFoundException {
        printMessage("Welcome to the game of Humans Vs Goblins.\n"+
                "Your player will be on a grid made of land and water.\n"+
                "Players are made up of " + Humans.humans.getPlayer() + " markings\n"+
                "Land is made up of " + Land.lad.getLand() + " markings.\n"+
                "Water is made up of " + new Water().getWater() + " markings\n"+
                "The Goblin is made up of " + Goblins.goblins.getPlayer() + " markings.\n"+
                "You must ponder the land and fight the goblin.\n"+
                "There are hidden inventory throughout the land that will boost your stats.\n"+
                "Collect them as this inventory will help you fight the goblins.\n"+
                "You can fight the goblin on land or water.\n"+
                "Use the \"N\", \"S\", \"E\", \"W\" keyboards keys to move up, down, left and right.");
    }

    public static char fill(){

        ArrayList<Character> al = new ArrayList();
        al.add(Land.lad.getLand()); al.add(new Water().getWater());
        al.add(Land.lad.getLand()); al.add(new Water().getWater());
        al.add(Land.lad.getLand()); al.add(new Water().getWater());
        al.add(Land.lad.getLand()); al.add(new Water().getWater());
        al.add(Land.lad.getLand()); al.add(new Water().getWater());
        return al.get(new Random().nextInt(al.size()));
    }

    /*public static void movement(char[][] gridGameBoard, String move) throws InterruptedException, ClassNotFoundException {

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
                printMessage("You have been a good sport.\n");
                break;
            default:
                printMessage("Invalid moves causes you to lose that move and allows the Goblin to come closer.\n");
        }

    }

    public static void moveUp(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

        int tempPosRow = 0;
        int row = 0;
        int col = 0;

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                if(gridGameWorld[i][j] == player){
                    try{
                        tempPosRow = i;
                        row = i;
                        col = j;
                    }catch (Exception e){
                        printMessage("You must move within the bounds of the grid. Remember the Goblin is trying to find you.");
                    }
                }
            }
        }

        if(row - 1 < 0){
            printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row - 1][col] == new Goblins().getPlayer()) {
                printMessage("Humans vs Goblins");
            }else{
                gridGameWorld[row][col] = fill();
                gridGameWorld[--row][col] = player;
                displayBoard(gridGameWorld);
            }
        }
    }

    public static void moveDown(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

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
            printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row + 1][col] == new Goblins().getPlayer()) {
                printMessage("Humans vs Goblins");
            }else{
                gridGameWorld[row][col] = fill();
                gridGameWorld[++row][col] = player;
                displayBoard(gridGameWorld);
            }
        }
    }

    public static void moveLeft(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

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
            printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row][col - 1] == new Goblins().getPlayer()) {
                printMessage("Humans vs Goblins");
            }else{
                gridGameWorld[row][col] = fill();
                gridGameWorld[row][--col] = player;
                displayBoard(gridGameWorld);
            }
        }
    }

    public static void moveRight(char[][] gridGameWorld, char player) throws InterruptedException, ClassNotFoundException {

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
            printMessage("Cannot move beyond the bonds of the grid.\n");
        }else {
            if(gridGameWorld[row][col + 1] == new Goblins().getPlayer()) {
                printMessage("Humans vs Goblins");
            }else{
                gridGameWorld[row][col] = fill();
                gridGameWorld[row][++col] = player;
                displayBoard(gridGameWorld);
            }
        }
    }
*/
/*
    public static void moveGoblin(char[][] gridGameWorld) throws InterruptedException, ClassNotFoundException {
        int row = 0;
        int col = 0;
        int humanRow = 0;
        int humanCol = 0;

        for(int i = 0; i < gridGameWorld.length; i++){
            for(int j = 0; j < gridGameWorld[i].length; j++){
                if(gridGameWorld[i][j] == new Goblins().getPlayer()){
                    row = i;
                    col = j;
                }

                if(gridGameWorld[i][j] == new Humans().getPlayer()){
                    humanRow = i;
                    humanCol = j;
                }
            }
        }

        if(row > humanRow){
            if(gridGameWorld[row - 1][col] == new Humans().getPlayer()){
                HumansVsGoblins.printMessage("Humans Vs Goblins");
            }else {
                gridGameWorld[--row][col] = new Goblins().getPlayer();
            }
        }else if(row < humanRow){
            if(gridGameWorld[row + 1][col] == new Humans().getPlayer()){
                HumansVsGoblins.printMessage("Humans Vs Goblins");
            }else {
                gridGameWorld[++row][col] = new Goblins().getPlayer();
            }
        }else if(col > humanCol){
            if(gridGameWorld[row][col - 1] == new Humans().getPlayer()){
                HumansVsGoblins.printMessage("Humans Vs Goblins");
            }else {
                gridGameWorld[row][--col] = new Goblins().getPlayer();
            }
        }else if(col < humanCol){
            if(gridGameWorld[row][col + 1] == new Humans().getPlayer()){
                HumansVsGoblins.printMessage("Humans Vs Goblins");
            }else {
                gridGameWorld[row][++col] = new Goblins().getPlayer();
            }
        }

    }
*/

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {

        //instructions();

        char[][] gridGameBoard = drawGrid();

        System.out.println();

        Scanner scan = new Scanner(System.in);
        String move = "";


        printMessage("To quit, key in \"Q\" and press enter\n");

        do{
            move = scan.nextLine();
            Humans.humans.movement(gridGameBoard, move);
            Thread.sleep(1000);
            Goblins.goblins.moveGoblin(gridGameBoard);

        }while (!(move.equalsIgnoreCase("Q")));

        printMessage("Thanks for playing!");

    }
}
