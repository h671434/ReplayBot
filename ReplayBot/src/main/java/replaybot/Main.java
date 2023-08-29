package replaybot;

import replaybot.util.PortReader;
import rlbot.manager.BotManager;

/**
 * See JavaAgent.py for usage instructions.
 *
 * Look inside ReplayBot.java for the actual bot logic!
 */
public class Main {

    private static final int DEFAULT_PORT = 17357;

    public static void main(String[] args) {

        BotManager botManager = new BotManager();
        int port = PortReader.readPortFromArgs(args).orElseGet(() -> {
            System.out.println("Could not read port from args, using default!");
            return DEFAULT_PORT;
        });

        BotPythonInterface pythonInterface = new BotPythonInterface(port, botManager);
        new Thread(pythonInterface::start).start();

        BotGUI.displayWindow(botManager, port);
    }


}
