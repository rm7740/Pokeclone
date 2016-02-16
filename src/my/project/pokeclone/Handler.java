package my.project.pokeclone;

import my.project.pokeclone.input.KeyManager;
import my.project.pokeclone.map.GameMap;

public class Handler {

    private GameEngine gameEngine;
    private GameMap gameMap;

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
        return gameEngine.getKeyManager();
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }
}
