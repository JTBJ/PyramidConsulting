import java.util.*;

public class HangMan {

    private static ArrayList<String> words;

    private static ArrayList<String> guesses;

    private static ArrayList<String> incorrectGuesses;

    private static ArrayList<String> theWord;

    private static String[] str = new String[9];

    private static boolean hasPassed;

    public static void waitTimer() throws InterruptedException {

        Thread.sleep(50);
    }

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

    public static int randomWord(){
        return new Random().nextInt(words.size());
    }

    public static void hanger(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void head(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void headArm1(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /        |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void headArm2(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /  \\     |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void headArmsChess(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void headArmsChessLeg1(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |       |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |       |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void headArmsChessLeg2(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void headArmsChessLegsFoot1(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /        |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

    public static void hangMan(String[] stickManArr){
        stickManArr[0] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ________";
        stickManArr[1] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ()      |";
        stickManArr[2] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /##\\     |";
        stickManArr[3] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ##      |";
        stickManArr[4] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |";
        stickManArr[5] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ||      |";
        stickManArr[6] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t /  \\     |";
        stickManArr[7] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t          |";
        stickManArr[8] = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  -----------------";
        for(int i = 0; i < stickManArr.length; i++){
            System.out.println(stickManArr[i]);
        }
    }

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
                return;
        }
    }

    public static void clear(){

        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    public static void playHangMan() throws InterruptedException, ClassNotFoundException {

        words = new ArrayList<>();
        guesses = new ArrayList<>();
        incorrectGuesses = new ArrayList<>();
        theWord = new ArrayList<>();

        fillArray();

        String str = words.get(randomWord());

        Scanner scan = new Scanner(System.in);

        String[] arr = new String[str.length()];

        int count = 9;
        int badGuess = str.length();
        int goodGuess = 0;

        do{
            getHangMan(count);

            printMessage("Guess a letter");
            System.out.println();

            if(!(arr[0] == null)){
                for(String s : arr){
                    System.out.print(s + " ");
                }
            }

            String guess = Character.toString(scan.next().charAt(0));

            if(!(guesses.contains(guess) || incorrectGuesses.contains(guess))){
                if(str.contains(guess)){
                    goodGuess++;
                    printMessage("good guess\n");
                }else{
                    printMessage("bad guess\n");
                    count--;
                }

                if(guesses.isEmpty()){
                    for(int i = 0; i < str.length(); i++){
                        if(Character.toString(str.charAt(i)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[i] = guess;
                        }else{
                            incorrectGuesses.add(guess);
                            arr[i] = "_";
                        }
                    }
                }else{
                    for(int i = 0; i < str.length(); i++){
                        if(Character.toString(str.charAt(i)).equalsIgnoreCase(guess)){
                            guesses.add(guess);
                            arr[i] = guess;
                        }else{
                            incorrectGuesses.add(guess);
                        }
                    }
                }
            }else{
                printMessage("You have already entered this number before.\n");
            }
            if(count == 0 ){
                printMessage("Sorry, but you are out of guesses.\n");
                printMessage("The word was " + str.toUpperCase() + "\n\n");
                main(new String[0]);
            }else if(goodGuess == str.length()){
                for(String s : arr){
                    System.out.print(s + " ");
                }
                printMessage("Congratulations, you win.\n\n");
                main(new String[0]);
            }
        }while(goodGuess < str.length() || count > 0);


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
            response = scanner.nextLine();

            if(response.equalsIgnoreCase("N")){
                printMessage("Thanks for playing. We'll see you later.");
                System.exit(0);
            }else {
                playHangMan();
            }
        }while (response.equalsIgnoreCase("N"));
    }
}