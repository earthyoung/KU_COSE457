import controller.MainArea;

public class Main {

    public static void main(String[] args) {
        MainArea mainFrame = MainArea.getInstance();
        mainFrame.setVisible(true);
        mainFrame.initialize();
    }

}
