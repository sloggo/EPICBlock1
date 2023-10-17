package questiongame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    private String[] gameModes = {"Novice", "Intermediate", "Expert"};
    private JComboBox<String> modeComboBox;

    public GameMenu() {
        setTitle("Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Select Game Mode:");
        add(label);

        modeComboBox = new JComboBox<>(gameModes);
        add(modeComboBox);

        JButton startButton = new JButton("Start Game");
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMode = (String) modeComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(GameMenu.this, "Starting game in " + selectedMode + " mode.");
                // Add code to start the game with the selected mode
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameMenu menu = new GameMenu();
                menu.setVisible(true);
            }
        });
    }
}

