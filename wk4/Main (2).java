import java.io.*;
import java.util.*;

public class Main{
    
    private static ArrayList<String> al = new ArrayList<>();
    
    public static void composeMessage() throws InterruptedException {
        
        String instructions = "In this game, the player is in a land full of dragons.\n"+ 
                              "The dragons all live in caves with their large piles of collected\n" +
                              "treasure. Some dragons are friendly and share their treasure. Other\n"+
                              "dragons are hungry and eat anyone who enters their cave. The player\n"+
                              "approaches two caves, one with a friendly dragon and the other with\n"+
                              "a hungry dragon, but doesn’t know which dragon is in which cave.\n" +
                              "The player must choose between the two.\n\n\n\n\n\n\n";
        printMessage(instructions);
        
        String selection = "Choose a cave to enter. Select option 1). for the left cave and 2). for the right....\n";
        printMessage(selection);
        
        String cave = "\t\t\t\t\u9728\u9728\u9728\u9728\u9728\t\t\t\t\u9728\u9728\u9728\u9728\u9728\n"+
                      "\t\t\t\t\u9728\u9728\u9728\u9728\u9728\t\t\t\t\u9728\u9728\u9728\u9728\u9728\n"+
                      "\t\t\t\t\u9728\u9728\u9728\u9728\u9728\t\t\t\t\u9728\u9728\u9728\u9728\u9728\n"+
                      "\t\t\t\t\u9728\u9728\u9728\u9728\u9728\t\t\t\t\u9728\u9728\u9728\u9728\u9728\n"+
                      "\t\t\t\t\u9728\u9728\u9728\u9728\u9728\t\t\t\t\u9728\u9728\u9728\u9728\u9728\n\n";
        printMessage(cave);
        
        String options = "\t\t\t\t    1.\t\t\t\t\t    2.\n\n";
        printMessage(options);
    }
    
    public static void waitTimer(int num) throws InterruptedException {
        Thread.sleep(num);
    }
    
    public static void printMessage(String string) throws InterruptedException {
        String[] strArr = string.split("");
        
        for(String s : strArr){
            System.out.print(s);
            Thread.sleep(50);
            if(s.equals("\n"))
            Thread.sleep(3000);
        }
        
    }
    
    public static void stickManHandsUp(){
        
        String stickManHandsUp =
        "\t\t\t\t\t\t\t     \n"+
		"\t\t\t\t\t\t\t  O  \n"+
		"\t\t\t\t\t\t\t /#\\  \n"+
		"\t\t\t\t\t\t\t  |  \n"+
		"\t\t\t\t\t\t\t_/ \\_";
		al.add(stickManHandsUp);
    }

    public static void stickManDown(){
        
        String stickManDown =
		"\n\n\n\n\n\n\n\t\t\t\t\t\t\t |____\\__()\n"+
		"\t\t\t\t\t\t\t      /";
		al.add(stickManDown);
    }

    public static void stickManParallelHands(){
        String stickManParallelHands = 
         "     \n"+
		 "  O\n"+
		 " /|\\\n"+
		 "  |\n"+
		 " /_\\_\n";
        al.add(stickManParallelHands);
    }

    public static void stickManHandsDown(){
		
		String stickManHandsDown =
		"     \n"+
		"  O\n"+
		"  |\n"+
		"  |\n"+
		"  |_\n";
        al.add(stickManHandsDown);
    }
    
    public static void dragonEater() throws InterruptedException {
        
        for(int i = 0; i < 20; i++){
            System.out.print("==<");
            Main.waitTimer(500);
            System.out.print("\b");
            System.out.print("\b");
            System.out.print("\b");
            System.out.print("\b");
            System.out.print("    ");
            System.out.print("===");
            Main.waitTimer(500);
            System.out.print("\b");
            System.out.print("\b");
            System.out.print("\b");
            System.out.print("\b");
            System.out.print("    ");
        }

    }
    
    public static void manWalking() throws InterruptedException {
        
        for(int i = 0; i < 60; i++){
            System.out.print(al.get(0));
            Main.waitTimer(500);
            System.out.print(al.get(1));
            Main.waitTimer(500);
        }
    }
    
    public static void carryOn() throws InterruptedException {
        
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        
        try {
            int choice = scan.nextInt();
            if(choice - 1 == rand.nextInt(2)){
                printMessage(new String("You found the good Dragon. Take the treasure and walk\n"));
                manWalking();
            }else{
                printMessage(new String("Ohh no. You found the bad Dragon and here he comes...\n\n"));
                dragonEater();
                printMessage("\n\n");
                System.out.print(al.get(3));
            }
        } catch(Exception e) {
            printMessage(new String("You have made and invalid selection...try again...\n"));
            carryOn();
        } finally {
        }
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        
        stickManHandsDown();//0
        stickManParallelHands();//1
        stickManHandsUp();//2
        stickManDown();//3
        
        composeMessage();
        System.out.println(al.get(2));
        carryOn();
        
    }
}