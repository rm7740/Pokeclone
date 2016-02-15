package my.project.pokeclone.state;

import my.project.pokeclone.Handler;
import java.awt.*;

public class GameState extends State{

    private GameMap palletTown;
    private GameMap currentMap;

    public GameState(Handler handler) {
        super(handler);

        loadMaps();
        currentMap = palletTown;
        handler.setGameMap(currentMap);
    }

    private void loadMaps() {
        palletTown = new GameMap(handler, "path");
    }

    @Override
    public void update() {
        currentMap.update();
    }

    @Override
    public void render(Graphics graphics) {
        currentMap.render(graphics);
    }
}
