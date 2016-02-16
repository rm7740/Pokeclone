package my.project.pokeclone.graphics;

import my.project.pokeclone.util.ImageLoader;
import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage palletTown;

    public static void init() {
        palletTown = ImageLoader.loadImage("/textures/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town.png");
    }
}
