import java.util.Random;

public class Land {

    public static Land lad = new Land();
    char land = '\u7777';

    public char getLand() {
        return land;
    }

    public char[][] setGoblinFrenzy(char[][] gridGameWorld){

        Random r = new Random();
        for(int i = 0; i < 2; i++){
            gridGameWorld[r.nextInt(10)][r.nextInt(10)] = 'G';
        }
        return gridGameWorld;
    }

    public char[][] setHumanInventory(char[][] gridGameWorld){

        Random r = new Random();

        for(int i = 0; i < 6; i++){
            gridGameWorld[r.nextInt(10)][r.nextInt(10)] = Humans.temp[r.nextInt(Humans.temp.length)];
        }
        return gridGameWorld;
    }

    @Override
    public String toString() {
        return "Land{" +
                "land=" + land +
                '}';
    }
}
