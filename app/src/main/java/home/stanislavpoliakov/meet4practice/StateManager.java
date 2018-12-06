package home.stanislavpoliakov.meet4practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class StateManager {
    private static StateManager instance;
    //private final String[] states = {"State \"A", "State \"B", "State \"C", "State \"D", "State \"E"};
    private Queue<String> statesQueue = new ArrayDeque<String>();

    private StateManager() {
        statesQueue.add("State \"A");
        statesQueue.add("State \"B");
        statesQueue.add("State \"C");
        statesQueue.add("State \"D");
        statesQueue.add("State \"E");
    }

    public static StateManager getInstance() {
        if (instance == null) return new StateManager();
        else return instance;
    }

    public String getCurrentState() {
        return statesQueue.peek();
    }

    public void changeState() {
        String movingState = statesQueue.poll();
        statesQueue.add(movingState);
    }

}
