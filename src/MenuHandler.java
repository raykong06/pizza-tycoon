import javax.swing.*;

public class MenuHandler extends JFrame {
    private JButton quitGameButton;
    private JButton challengesButton;
    private JTextArea snowSurferTextArea;
    private JPanel MenuHandler;
    private JButton startGameButton;

    public MenuHandler(String title)
    {
        setContentPane(MenuHandler);
        setTitle(title);
        setSize(1000, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
