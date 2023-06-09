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
                String data = s.nextLine();
                int highScore = Integer.parseInt(data);
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
            FileWriter fw = new FileWriter("src/score.txt");
            fw.write(PlayerScoreBoard.getHighScore());
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}