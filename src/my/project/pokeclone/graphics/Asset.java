package my.project.pokeclone.graphics;

import my.project.pokeclone.util.ImageFliper;
import my.project.pokeclone.util.ImageLoader;
import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage palletTown;
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;

    public static SpriteSheet heroHeroine;

    public static void init() {
        heroHeroine = new SpriteSheet(ImageLoader.loadImage("/textures/Game Boy Advance - Pokemon FireRed LeafGreen - Hero Heroine.png"));
        palletTown = ImageLoader.loadImage("/textures/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town.png");
        heroLeft = heroHeroine.crop(8, 88, 16, 32);
        heroRight = ImageFliper.flipHorizontally(heroLeft);
    }
}
