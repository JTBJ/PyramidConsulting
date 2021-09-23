import java.util.Random;

public class Goblins {

    public static Goblins goblins = new Goblins();

    char goblin = '\u3323';

    private int goblinDamage = 30;

    private boolean isInFrenzy;

    public char getPlayer() {
        return goblin;
    }

    public int getGoblinDamage() {
        return goblinDamage;
    }

    public void setGoblinDamage(int goblinDamage) {
        this.goblinDamage = goblinDamage;
    }

    public void move(char[][] gridGameWorld) throws InterruptedException, ClassNotFoundException {

        if(isInFrenzy){
            moveGoblin(gridGameWorld);
        }
            int row = 0;
            int col = 0;
            int humanRow = 0;
            int humanCol = 0;

            for (int i = 0; i < gridGameWorld.length - 1; i++) {
                for (int j = 0; j < gridGameWorld[i].length  - 1; j++) {
                    if (gridGameWorld[i][j] == Goblins.goblins.getPlayer()) {
                        row = i;
                        col = j;
                    }

                    if (gridGameWorld[i][j] == Humans.humans.getPlayer()) {
                        humanRow = i;
                        humanCol = j;
                    }
                }
            }

            int direction = new Random().nextInt(4) + 1;
            switch (direction) {
                case 1:
                    if (!(row - 1 <= 0)) {
                        if (gridGameWorld[row - 1][col] == Humans.humans.getPlayer()) {
                            HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                            Humans.humans.doBattle();
                            Humans.humans.checkHealth();
                            HumansVsGoblins.printMessage(Goblins.goblins.toString());
                            System.out.println();
                            isInFrenzy = false;
                        } else {
                            if (gridGameWorld[row - 1][col] == 'H' || gridGameWorld[row - 1][col] == 'S' || gridGameWorld[row - 1][col] == 'B') {

                            }else {
                                if (gridGameWorld[row - 1][col] == 'G') {
                                    isInFrenzy = true;
                                }
                                gridGameWorld[row][col] = HumansVsGoblins.fill();
                                gridGameWorld[--row][col] = getPlayer();
                            }
                        }
                    }
                    break;
                case 2:
                    if(!(row + 1 >= gridGameWorld.length - 1)) {
                        if (gridGameWorld[row + 1][col] == Humans.humans.getPlayer()) {
                            HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                            Humans.humans.doBattle();
                            Humans.humans.checkHealth();
                            HumansVsGoblins.printMessage(Goblins.goblins.toString());
                            System.out.println();
                            isInFrenzy = false;
                        } else {
                            if (gridGameWorld[row + 1][col] == 'H' || gridGameWorld[row + 1][col] == 'S' || gridGameWorld[row + 1][col] == 'B') {

                            }else {
                                if (gridGameWorld[row + 1][col] == 'G') {
                                    isInFrenzy = true;
                                }
                                gridGameWorld[row][col] = HumansVsGoblins.fill();
                                gridGameWorld[++row][col] = getPlayer();
                            }
                        }
                    }
                    break;
                case 3:
                    if(!(col - 1 <= 0)) {
                        if (gridGameWorld[row][col - 1] == Humans.humans.getPlayer()) {
                            HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                            Humans.humans.doBattle();
                            Humans.humans.checkHealth();
                            HumansVsGoblins.printMessage(Goblins.goblins.toString());
                            System.out.println();
                            isInFrenzy = false;
                        } else {
                            if (gridGameWorld[row][col - 1] == 'H' || gridGameWorld[row][col - 1] == 'S' || gridGameWorld[row][col - 1] == 'B') {

                            }else {
                                if (gridGameWorld[row][col - 1] == 'G') {
                                    isInFrenzy = true;
                                }
                                gridGameWorld[row][col] = HumansVsGoblins.fill();
                                gridGameWorld[row][--col] = getPlayer();
                            }
                        }
                    }
                    break;
                case 4:
                    if(!(col + 1 >= gridGameWorld[row].length)) {
                        if (gridGameWorld[row][col + 1] == Humans.humans.getPlayer()) {
                            HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                            Humans.humans.doBattle();
                            Humans.humans.checkHealth();
                            HumansVsGoblins.printMessage(Goblins.goblins.toString());
                            System.out.println();
                            isInFrenzy = false;
                        } else {
                            if (gridGameWorld[row][col + 1] == 'H' || gridGameWorld[row][col + 1] == 'S' || gridGameWorld[row][col + 1] == 'B') {

                            }else {
                                if (gridGameWorld[row][col + 1] == 'G') {
                                    isInFrenzy = true;
                                }
                                gridGameWorld[row][col] = HumansVsGoblins.fill();
                                gridGameWorld[row][++col] = getPlayer();
                            }
                        }
                    }
                    break;
            }
    }

    public void moveGoblin(char[][] gridGameWorld) throws InterruptedException, ClassNotFoundException {

        if(!isInFrenzy){
            move(gridGameWorld);
        }else {

            int row = 0;
            int col = 0;
            int humanRow = 0;
            int humanCol = 0;

            for (int i = 0; i < gridGameWorld.length; i++) {
                for (int j = 0; j < gridGameWorld[i].length; j++) {
                    if (gridGameWorld[i][j] == Goblins.goblins.getPlayer()) {
                        row = i;
                        col = j;
                    }

                    if (gridGameWorld[i][j] == Humans.humans.getPlayer()) {
                        humanRow = i;
                        humanCol = j;
                    }
                }
            }

            if (row > humanRow) {
                if (gridGameWorld[row - 1][col] == Humans.humans.getPlayer()) {
                    HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                    Humans.humans.doBattle();
                    Humans.humans.checkHealth();
                    HumansVsGoblins.printMessage(Goblins.goblins.toString());
                    System.out.println();
                    isInFrenzy = false;
                } else {
                    if(gridGameWorld[row - 1][col] != 'H' || gridGameWorld[row - 1][col] != 'S' || gridGameWorld[row - 1][col] != 'B') {
                        if(gridGameWorld[row - 1][col] == 'G') {
                            isInFrenzy = true;
                        }
                        gridGameWorld[row][col] = HumansVsGoblins.fill();
                        gridGameWorld[--row][col] = getPlayer();
                    }
                }
            } else if (row < humanRow) {
                if (gridGameWorld[row + 1][col] == Humans.humans.getPlayer()) {
                    HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                    Humans.humans.doBattle();
                    Humans.humans.checkHealth();
                    HumansVsGoblins.printMessage(Goblins.goblins.toString());
                    System.out.println();
                    isInFrenzy = false;
                } else {
                    if(gridGameWorld[row + 1][col] != 'H' || gridGameWorld[row + 1][col] != 'S' || gridGameWorld[row + 1][col] != 'B') {
                        if(gridGameWorld[row + 1][col] == 'G') {
                            isInFrenzy = true;
                        }
                        gridGameWorld[row][col] = HumansVsGoblins.fill();
                        gridGameWorld[++row][col] = getPlayer();
                    }
                }
            } else if (col > humanCol) {
                if (gridGameWorld[row][col - 1] == Humans.humans.getPlayer()) {
                    HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                    Humans.humans.doBattle();
                    Humans.humans.checkHealth();
                    HumansVsGoblins.printMessage(Goblins.goblins.toString());
                    System.out.println();
                    isInFrenzy = false;
                } else {
                    if(gridGameWorld[row][col - 1] != 'H' || gridGameWorld[row][col - 1] != 'S' || gridGameWorld[row][col - 1] != 'B') {
                        if(gridGameWorld[row][col - 1] == 'G') {
                            isInFrenzy = true;
                        }
                        gridGameWorld[row][col] = HumansVsGoblins.fill();
                        gridGameWorld[row][--col] = getPlayer();
                    }
                }
            } else if (col < humanCol) {
                if (gridGameWorld[row][col + 1] == Humans.humans.getPlayer()) {
                    HumansVsGoblins.printMessage("Humans Vs Goblins\n");
                    Humans.humans.doBattle();
                    Humans.humans.checkHealth();
                    HumansVsGoblins.printMessage(Goblins.goblins.toString());
                    System.out.println();
                    isInFrenzy = false;
                } else {
                    if(gridGameWorld[row][col + 1] != 'H' || gridGameWorld[row][col + 1] != 'S' || gridGameWorld[row][col + 1] != 'B') {
                        if(gridGameWorld[row][col + 1] == 'G') {
                            isInFrenzy = true;
                        }
                        gridGameWorld[row][col] = HumansVsGoblins.fill();
                        gridGameWorld[row][++col] = getPlayer();
                    }
                }
            }
        }
        HumansVsGoblins.displayBoard(gridGameWorld);
    }

    @Override
    public String toString() {
        return "Goblin' s health: " + getGoblinDamage() + "\n";
    }
}