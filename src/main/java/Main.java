import gui.VoterGUI;
import config.ConfigLoader;

public class Main {

    public static void main(String[] args) {
        ConfigLoader.load();
        new VoterGUI();
    }
}
