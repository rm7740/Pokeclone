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
        loadCollisionTiles("res/map tiles/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town - Tile Map.txt");

        entityManager.addEntity(player);
    }
}
