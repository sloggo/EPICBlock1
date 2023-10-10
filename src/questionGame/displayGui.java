package questionGame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class displayGui  extends JFrame{
    public static void initMenu(){
        JFrame frame = new JFrame("Question Game");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        JButton button = new JButton("Button");
        topPanel.add(button);

        frame.getContentPane().add(topPanel);
    }
}
