import javax.swing.*;

public class questionGame {
    public static void main(String[] args) throws Exception {
        initMenu();
    }

    public static void initMenu(){
        JFrame frame = new JFrame("Question Game");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);

    }
}
