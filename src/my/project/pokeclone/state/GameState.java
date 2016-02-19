package my.project.pokeclone.state;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.map.GameMap;
import my.project.pokeclone.map.PalletTown;

import java.awt.*;

public class GameState extends State{

    private GameMap palletTown;
    private GameMap currentMap;
    private Player player;

    public GameState(Handler handler) {
        super(handler);
        player = new Player(handler, 200, 32, true);

        loadMaps();
        currentMap = palletTown;
        handler.setGameMap(currentMap);

    }

    private void loadMaps() {
        palletTown = new PalletTown(handler, player);
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
