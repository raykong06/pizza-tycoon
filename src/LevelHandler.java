import java.util.Random;

public class LevelHandler {
    private int seed;

    public LevelHandler(){
        Random r = new Random();
        seed = r.nextInt();
        System.out.println(seed);
    }
}
