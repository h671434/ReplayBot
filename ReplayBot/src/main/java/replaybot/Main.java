package replaybot;

import java.util.Optional;

import replaybot.gui.BotGUI;
import rlbot.manager.BotManager;

/**.
 * Look inside ReplayBot.java for the actual bot logic!
 */
public class Main {

    private static final int DEFAULT_PORT = 17357;

    public static void main(String[] args) {

        BotManager botManager = new BotManager();
        int port = readPortFromArgs(args).orElseGet(() -> {
            System.out.println("Could not read port from args, using default!");
            return DEFAULT_PORT;
        });

        BotPythonInterface pythonInterface = new BotPythonInterface(port, botManager);
        new Thread(pythonInterface::start).start();

        BotGUI.displayWindow(botManager, port);
    }

    public static Optional<Integer> readPortFromArgs(String[] args) {
        if (args.length == 0) {
            return Optional.empty();
        }
        
        try {
            return Optional.of(Integer.parseInt(args[0]));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    

}
