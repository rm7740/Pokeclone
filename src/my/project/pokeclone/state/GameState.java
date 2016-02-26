package my.project.pokeclone.state;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.map.*;

import java.awt.*;

public class GameState extends State{

    private GameMap heroHome2F;
    private GameMap heroHome1F;
    private GameMap palletTown;
    private GameMap rivalHome1F;
    private GameMap oaksLab1F;
    private Player player;

    public GameState(Handler handler) {
        super(handler);
        player = new Player(handler, 224, 64, true);

        loadMaps();
        handler.setGameMap(palletTown);

    }

    private void loadMaps() {
        heroHome2F = new HeroHome2F(handler, player);
        heroHome1F = new HeroHome1F(handler, player);
        palletTown = new PalletTown(handler, player);
        rivalHome1F = new RivalHome1F(handler, player);
        oaksLab1F = new OaksLab1F(handler, player);
    }

    @Override
    public void update() {
        handler.getGameMap().update();
    }

    @Override
    public void render(Graphics graphics) {
        handler.getGameMap().render(graphics);
    }

    public GameMap getPalletTown() {
        return palletTown;
    }

    public GameMap getHeroHome1F() {
        return heroHome1F;
    }

    public GameMap getHeroHome2F() {
        return heroHome2F;
    }

    public GameMap getRivalHome1F() {
        return rivalHome1F;
    }

    public GameMap getOaksLab1F() {
        return oaksLab1F;
    }
}
