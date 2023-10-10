package questionGame;

public class questionGame {
    public static void main(String[] args) throws Exception {
        displayGui gui = new displayGui();
        gui.initMenu();

        System.out.println(gui.stateOfMenu);
    }
}
