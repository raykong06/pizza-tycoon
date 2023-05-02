import java.awt.*;

public class Window extends Frame implements Runnable{
    private KeyInput keyInput = new KeyInput();
    @Override
    public void run() {
        keyInput.inputTick();
    }
}
