package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.graphics.Asset;

public class HeroHome1F extends GameMap{

    public HeroHome1F(Handler handler, Player player) {
        super(handler, player);
    }

    @Override
    protected void init() {
        bufferedImage = Asset.heroHome1F;
        width = Asset.heroHome1F.getWidth();
        height = Asset.heroHome1F.getHeight();
        tileSide = 16;
        super.init();
        loadCollisionTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Hero Home 1F - Tile Map.txt");
        loadTeleportTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Hero Home 1F - Teleport Map.txt");

        entityManager.addEntity(player);

    }

    @Override
    public GameMap getDestinationMap(int marker) {
        GameMap destination = this;
        if (marker == 1) destination = handler.getGameState().getHeroHome2F();
        if (marker == 2) destination = handler.getGameState().getPalletTown();
        return destination;
    }

    @Override
    public int[] getDestinationPosition(int marker) {
        int[] position = {0, 0};
        if (marker == 1) {
            position[0] = 144;
            position[1] = 16;
        }
        if (marker == 2) {
            position[0] = 160;
            position[1] = 144;
        }
        return position;
    }
}
