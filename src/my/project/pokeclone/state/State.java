package my.project.pokeclone.state;

import my.project.pokeclone.Handler;
import java.awt.*;

public abstract class State {

    private static State currentState = null;
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public static void setCurrentState(State currentState) {
        State.currentState = currentState;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
