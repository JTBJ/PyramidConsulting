import java.util.*;

public class HangManVersion2 {
    
    //holds a list of random words
    private static ArrayList<String> words;
    
    //holds correct guessus
    private static ArrayList<String> guesses;
    
    //holds incorrect guesses
    private static ArrayList<String> incorrectGuesses;
    
    //keeps count of bad guesses
    private static int count = 9;
    
    //2D array for hangman
    private static String[] str = new String[9];
    
    //used to determine if a message has been displayed if false, the message is displayed
    private static boolean hasPassed;

    //used to deliver the effect of the computer typing text to the console
    public static void waitTimer() throws InterruptedException {

        Thread.sleep(50);
    }
    
    //fill ArrayList words with a list of words
    public static void fillArray() {

        words.add("abruptly");
        words.add("foxglove");
        words.add("lengths");
        words.add("subway");
        words.add("absurd");
        words.add("frazzled");
        words.add("lucky");
        words.add("swivel");
        words.add("abyss");
        words.add("frizzled");
        words.add("luxury");
        words.add("syndrome");
        words.add("affix");
        words.add("fuchsia");
        words.add("lymph");
        words.add("thriftless");
        words.add("askew");
        words.add("funny");
        words.add("marquis");
        words.add("thumbscrew");
    }

    //delivers the instructions to the user
    public static void instructions() throws InterruptedException, ClassNotFoundException {

        String message = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tH A N G M A N\n\n" +
                "The computer will think of a word and then draw a blank line on the page for each letter in the word.\n" +
                "You will then try to guess letters that might be in the word. You will have 9 guesses to guess the\n"+
                "word correct. A correct guesses will not count against you. When you guess a letter correctly, you\n" +
                "will see it displayed on one of the blank lines on the pages. Guess all the letters before you run out of\n" +
                "attempts and you win and if not,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tH A N G M A N\n\n";

        printMessage(message);
    }

    //another method to portray the computer as typing to the console
    public static void printMessage(String message) throws InterruptedException, ClassNotFoundException {

        String[] arr = message.split("");
        for (String s : arr) {
            System.out.print(s);
            waitTimer();
            if (s.equals("\n")) {
                Thread.sleep(2000);
            }
        }
    }

    //helper method to issue a random integer to pick a random word from ArrayList
    public static int randomWord(){
        return new Random().nextInt(words.size());
    }
    
    //below are stickman positions
    public static void hanger(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void head(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void headArm1(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /        |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void headArm2(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /  \\     |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void headArmsChess(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void headArmsChessLeg1(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |       |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |       |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void headArmsChessLeg2(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void headArmsChessLegsFoot1(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /        |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }

    public static void hangMan(String[] stickManArr){
        String stickMan =
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /  \\     |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |\n"+
        "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------\n";
        System.out.println(stickMan);
    }
    
    public static void clear(){

        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }
    
    //gets the hangman position
    public static void getHangMan(int count) throws InterruptedException, ClassNotFoundException {
        switch (count){
            case 9:
                clear();
                hanger(str);
                break;
            case 8:
                clear();
                head(str);
                break;
            case 7:
                clear();
                headArm1(str);
                break;
            case 6:
                clear();
                headArm2(str);
                break;
            case 5:
                clear();
                headArmsChess(str);
                break;
            case 4:
                clear();
                headArmsChessLeg1(str);
                break;
            case 3:
                clear();
                headArmsChessLeg2(str);
                break;
            case 2:
                clear();
                headArmsChessLegsFoot1(str);
                break;
            case 1:
                clear();
                hangMan(str);
                break;
            default:
                printMessage("Sorry, you have no more guesses");
                main(new String[0]);
        }
    }
    
    //hangman guessing, winning, lossing, storing correct / incorrect guess logic for the game
    public static void playHangMan() throws InterruptedException, ClassNotFoundException {

        words = new ArrayList<>();
        guesses = new ArrayList<>();
        incorrectGuesses = new ArrayList<>();
        // theWord = new ArrayList<>();

        fillArray();

        String str = words.get(randomWord());

        Scanner scan = new Scanner(System.in);

        String[] arr = new String[str.length()];

        int badGuess = str.length();
        int goodGuess = 0;

        getHangMan(count);

        printMessage("Guess a letter");
        System.out.println();

        if(!(arr[0] == null)){
            System.out.println(Arrays.toString(arr));
        }
        
        String guess = "";
        
        try{
            guess = Character.toString(scan.next().charAt(0));
        }catch(Exception e){
            printMessage("Must enter a single letter. Try again...\n");
            playHangMan();
        }

        if(!(guesses.contains(guess) || incorrectGuesses.contains(guess))){
            if(str.contains(guess)){
                goodGuess++;
                printMessage("good guess\n");
            }else{
                printMessage("bad guess\n");
                count--;
            }

            if(guesses.isEmpty()){
                if(str.contains(guess)){
                    if(Character.toString(str.charAt(0)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[0] = guess;
                    }else{
                        arr[0] = "_";
                    }
                    if(Character.toString(str.charAt(1)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[1] = guess;
                    }else{
                        arr[1] = "_";
                    }
                    if(Character.toString(str.charAt(2)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[2] = guess;
                    }else{
                        arr[2] = "_";
                    }
                    if(Character.toString(str.charAt(3)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[3] = guess;
                    }else{
                        arr[3] = "_";
                    }
                    if(Character.toString(str.charAt(4)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[4] = guess;
                    }else{
                        arr[4] = "_";
                    }
                    
                    if(str.length() >= 6){
                        if(Character.toString(str.charAt(5)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[5] = guess;
                        }else{
                            arr[5] = "_";
                        }
                    }
                    
                    if(str.length() >= 7){
                        if(Character.toString(str.charAt(6)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[6] = guess;
                        }else{
                            arr[6] = "_";
                        }
                    }
                    
                    if(str.length() >= 8){
                        if(Character.toString(str.charAt(7)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[7] = guess;
                        }else{
                            arr[7] = "_";
                        }
                    }
                    
                    if(str.length() >= 9){
                        if(Character.toString(str.charAt(8)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[8] = guess;
                        }else{
                            arr[8] = "_";
                        }
                    }
                    
                    if(str.length() >= 10){
                        if(Character.toString(str.charAt(9)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[9] = guess;
                        }else{
                            arr[9] = "_";
                        }
                    }
                    
                    if(str.length() >= 11){
                        if(Character.toString(str.charAt(10)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[10] = guess;
                        }else{
                            arr[10] = "_";
                        }
                    }
                }else{
                    incorrectGuesses.add(guess);
                }
            }else{
                if(str.contains(guess)){
                    if(Character.toString(str.charAt(0)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[0] = guess;
                    }
                    if(Character.toString(str.charAt(1)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[1] = guess;
                    }
                    if(Character.toString(str.charAt(2)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[2] = guess;
                    }
                    if(Character.toString(str.charAt(3)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[3] = guess;
                    }
                    if(Character.toString(str.charAt(4)).equalsIgnoreCase(guess)){
                        guesses.add(guess);
                        arr[4] = guess;
                    }
                    
                    if(str.length() >= 6){
                        if(Character.toString(str.charAt(5)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[5] = guess;
                        }
                    }
                    
                    if(str.length() >= 7){
                        if(Character.toString(str.charAt(6)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[6] = guess;
                        }
                    }
                    
                    if(str.length() >= 8){
                        if(Character.toString(str.charAt(7)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[7] = guess;
                        }
                    }
                    
                    if(str.length() >= 9){
                        if(Character.toString(str.charAt(8)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[8] = guess;
                        }
                    }
                    
                    if(str.length() >= 10){
                        if(Character.toString(str.charAt(9)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[9] = guess;
                        }
                    }
                    
                    if(str.length() >= 11){
                        if(Character.toString(str.charAt(10)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[10] = guess;
                        }
                    }
                }else{
                    incorrectGuesses.add(guess);
                }
            }
        }else{
            printMessage("You have already entered this letter before.\n");
        }
        
        if(count == 0 ){
            printMessage("Sorry, but you are out of guesses.\n");
            printMessage("The word was " + str.toUpperCase() + "\n\n");
        }else if(goodGuess == str.length()){
            System.out.println(Arrays.toString(arr));
            printMessage("Congratulations, you win.\n\n");
            main(new String[0]);
        }
        
        if(goodGuess < str.length() || count > 0){
            playHangMan();
        }else{
            main(new String[0]);
        }
    }

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {

        if(!(hasPassed)){
            instructions();
            hasPassed = true;
        }

        String response = "";

        do{
            Scanner scanner = new Scanner(System.in);

            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            printMessage("Would you like to play HANGMAN?");
            System.out.println();
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            printMessage("Enter \"N\" for no.");

            System.out.print("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ");

            try{
                response = scanner.nextLine();
            }catch(Exception e){
                printMessage("Must enter a single letter. Try again...\n");
                playHangMan();
            }
            
            if(response.equalsIgnoreCase("N")){
                printMessage("Thanks for playing. We'll see you later.");
                System.exit(0);
            }else {
                playHangMan();
            }
        }while (!response.equalsIgnoreCase("N"));
    }
}