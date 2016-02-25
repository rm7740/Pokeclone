package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.graphics.Asset;

public class HeroHome2F extends GameMap{

    public HeroHome2F(Handler handler, Player player) {
        super(handler, player);
    }

    @Override
    protected void init() {
        bufferedImage = Asset.heroHome2F;
        width = Asset.heroHome2F.getWidth();
        height = Asset.heroHome2F.getHeight();
        tileSide = 16;
        super.init();
        loadCollisionTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Hero Home 2F - Tile Map.txt");
        loadTeleportTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Hero Home 2F - Teleport Map.txt");

        entityManager.addEntity(player);

    }
    @Override
    public GameMap getDestinationMap(int marker) {
        GameMap destination = this;
        if (marker == 1) destination = handler.getGameState().getHeroHome1F();
        return destination;
    }

    @Override
    public int[] getDestinationPosition(int marker) {
        int[] position = {0, 0};
        if (marker == 1) {
            position[0] = 128;
            position[1] = 16;
        }
        return position;
    }
}
