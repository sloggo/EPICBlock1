package questionGame;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class displayGui  extends JFrame{
    String stateOfMenu = "menu";
    
    public static void initMenu(){
        JFrame frame = new JFrame("Question Game");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JLabel title = new JLabel("Welcome to Question Game!");
        title.setVerticalTextPosition(JLabel.BOTTOM);
        title.setHorizontalTextPosition(JLabel.CENTER);

        JButton button = new JButton("Discrete Maths");
        JButton button2 = new JButton("Computer Science Fundamentals");
        JButton button3 = new JButton("Computer Organisation");

        topPanel.add(title);
        bottomPanel.add(button);
        bottomPanel.add(button2);
        bottomPanel.add(button3);


        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }
}
