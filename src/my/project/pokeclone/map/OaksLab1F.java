package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.graphics.Asset;

public class OaksLab1F extends GameMap{

    public OaksLab1F(Handler handler, Player player) {
        super(handler, player);
    }

    protected void init() {
        bufferedImage = Asset.oaksLab1F;
        width = Asset.oaksLab1F.getWidth();
        height = Asset.oaksLab1F.getHeight();
        tileSide = 16;
        super.init();
        loadCollisionTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Oak's Lab 1F - Tile Map.txt");
        loadTeleportTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Oak's Lab 1F - Teleport Map.txt");

        entityManager.addEntity(player);

    }

    @Override
    public GameMap getDestinationMap(int marker) {
        GameMap destination = this;
        if (marker == 1) destination = handler.getGameState().getPalletTown();
        return destination;
    }

    @Override
    public int[] getDestinationPosition(int marker) {
        int[] position = {0, 0};
        if (marker == 1) {
            position[0] = 256;
            position[1] = 208;
        }
        return position;
    }
}
