import javax.swing.*;

public class MenuHandler extends JFrame {
    private JButton button1;
    private JButton button2;
    private JTextArea snowSurferTextArea;
    private JPanel MenuHandler;

    public MenuHandler(String title)
    {
        setContentPane(MenuHandler);
        setTitle(title);
        setSize(1000, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
