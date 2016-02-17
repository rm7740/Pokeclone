package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.graphics.Asset;

public class PalletTown extends GameMap{

    public PalletTown(Handler handler) {
        super(handler);
    }

    @Override
    protected void init() {
        bufferedImage = Asset.palletTown;
        width = Asset.palletTown.getWidth();
        height = Asset.palletTown.getHeight();
        tileSide = 16;

        loadCollisionTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Tile Map.txt");
    }
}
