package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.graphics.Asset;

public class PalletTown extends GameMap{

    public PalletTown(Handler handler, Player player) {
        super(handler, player);
    }

    @Override
    protected void init() {
        bufferedImage = Asset.palletTown;
        width = Asset.palletTown.getWidth();
        height = Asset.palletTown.getHeight();
        tileSide = 16;
        super.init();
        loadCollisionTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Tile Map.txt");
        loadTeleportTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Teleport Map.txt");

        entityManager.addEntity(player);
    }

    @Override
    public GameMap getDestinationMap(int marker) {
        GameMap destination = this;
        if (marker == 1) destination = handler.getGameState().getHeroHome1F();
        if (marker == 2) destination = handler.getGameState().getRivalHome1F();
        if (marker == 3) destination = handler.getGameState().getOaksLab1F();
        return destination;
    }

    @Override
    public int[] getDestinationPosition(int marker) {
        int[] position = {0, 0};
        if (marker == 1) {
            position[0] = 48;
            position[1] = 96;
        }
        if (marker == 2) {
            position[0] = 64;
            position[1] = 96;
        }
        if (marker == 3) {
            position[0] = 96;
            position[1] = 160;
        }
        return position;
    }
}
