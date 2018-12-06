package home.stanislavpoliakov.meet4practice;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.Queue;

public class StateManager {
    private final String LOG_TAG = "meet4_logs";
    private static StateManager instance;
    //private final String[] states = {"State \"A", "State \"B", "State \"C", "State \"D", "State \"E"};
    private Queue<String> statesQueue = new ArrayDeque<String>();

    private StateManager() {
        //Log.d(LOG_TAG, "Singleton: init");
        statesQueue.add("State \"A");
        statesQueue.add("State \"B");
        statesQueue.add("State \"C");
        statesQueue.add("State \"D");
        statesQueue.add("State \"E");
    }

    public static StateManager getInstance() {
        if (instance == null) instance = new StateManager();
        return instance;
    }

    public String getCurrentState() {
        //Log.d(LOG_TAG, "Send state: " + statesQueue.peek());
        return statesQueue.peek();
    }

    /**
     * Крутим состояния в ArrayDeque
     */
    public void changeState() {
        //Log.d(LOG_TAG, "Changing... Current: " + statesQueue.peek());
        String movingState = statesQueue.poll();
        //Log.d(LOG_TAG, "Changing... Poll: " + movingState);
        statesQueue.add(movingState);
        //Log.d(LOG_TAG, "Change complete At the top: " + statesQueue.peek());
    }

}
