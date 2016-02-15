package my.project.pokeclone;

import my.project.pokeclone.input.KeyManager;

public class Handler {

    private GameEngine gameEngine;

    public Handler(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public int getGameWidth() {
        return gameEngine.getWidth();
    }

    public int getGameHeight() {
        return gameEngine.getHeight();
    }

    public KeyManager getKeyManager() {
        return gameEngine.getGameWindow().getKeyManager();
    }
}
