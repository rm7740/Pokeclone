package my.project.pokeclone.state;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.map.GameMap;
import my.project.pokeclone.map.HeroHome1F;
import my.project.pokeclone.map.HeroHome2F;
import my.project.pokeclone.map.PalletTown;

import java.awt.*;

public class GameState extends State{

    private GameMap palletTown;
    private GameMap heroHome1F;
    private GameMap heroHome2F;
    private Player player;

    public GameState(Handler handler) {
        super(handler);
        player = new Player(handler, 192, 32, true);

        loadMaps();
        handler.setGameMap(palletTown);

    }

    private void loadMaps() {
        heroHome2F = new HeroHome2F(handler, player);
        heroHome1F = new HeroHome1F(handler, player);
        palletTown = new PalletTown(handler, player);
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
}
