import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHandler extends JFrame {
    private JButton quitGameButton;
    private JButton challengesButton;
    private JTextArea snowSurferTextArea;
    private JPanel menuHandler;
    private JButton startGameButton;
    private int option;

    public MenuHandler(String title)
    {
        setContentPane(menuHandler);
        setTitle(title);
        setSize(1000, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                option = 1;
                System.out.println("hii");
            }
        });
    }

    public int getOption() {
        return option;
    }

}
