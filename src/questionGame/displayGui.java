package questionGame;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class displayGui  extends JFrame{
    public static void initMenu(){
        JFrame frame = new JFrame("Question Game");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JLabel title = new JLabel("Welcome to Question Game!");
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);

        JButton button = new JButton("Button");
        topPanel.add(title);
        bottomPanel.add(button);


        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }
}
