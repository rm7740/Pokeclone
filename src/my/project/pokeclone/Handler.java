package my.project.pokeclone;

import my.project.pokeclone.display.GameCamera;
import my.project.pokeclone.input.KeyManager;
import my.project.pokeclone.map.GameMap;
import my.project.pokeclone.state.GameState;

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

    public GameCamera getGameCamera() {
        return gameEngine.getGameCamera();
    }

    public GameState getGameState() {return gameEngine.getGameState();}

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }
}
