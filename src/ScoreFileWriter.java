import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreFileWriter {

    public ScoreFileWriter() {
        loadHighScore();
    }

    public void loadHighScore() {
        try {
            File f = new File("src/score.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] data = line.split(",");

                int highScore = Integer.parseInt(data[0]);
                int speed = Integer.parseInt(data[1]);
                PlayerScoreBoard.setHighScore(highScore);
                GameArea.setSpeed(speed);
            }
            s.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found!");
        }
    }

    public void saveData() {
        try {
            File f = new File("src/score.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write(PlayerScoreBoard.getHighScore() + "," + GameArea.getSpeed());
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("Writing file failed");
            System.out.println(ioe);
        }

    }
}