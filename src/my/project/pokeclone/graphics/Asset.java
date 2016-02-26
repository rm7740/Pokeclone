package my.project.pokeclone.graphics;

import my.project.pokeclone.util.ImageFliper;
import my.project.pokeclone.util.ImageLoader;

import java.awt.image.BufferedImage;

public class Asset {

    public static BufferedImage[] heroUp;
    public static BufferedImage[] heroDown;
    public static BufferedImage[] heroLeft;
    public static BufferedImage[] heroRight;
    public static BufferedImage momUp;
    public static BufferedImage momDown;
    public static BufferedImage momLeft;
    public static BufferedImage momRight;

    public static BufferedImage palletTown;
    public static BufferedImage heroHome1F;
    public static BufferedImage heroHome2F;
    public static BufferedImage rivalHome1F;
    public static BufferedImage oaksLab1F;

    public static SpriteSheet heroHeroine;
    public static SpriteSheet palletTownInteriors;
    public static SpriteSheet npcs;

    public static void init() {
        heroHeroine = new SpriteSheet(ImageLoader.loadImage("/textures/Game Boy Advance - Pokemon FireRed LeafGreen - Hero Heroine.png"));
        palletTownInteriors = new SpriteSheet(ImageLoader.loadImage("/textures/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town Interiors.png"));
        npcs = new SpriteSheet(ImageLoader.loadImage("/textures/Game Boy Advance - Pokemon FireRed LeafGreen - NPC's.png"));

        palletTown = ImageLoader.loadImage("/textures/Game Boy Advance - Pokemon FireRed LeafGreen - Pallet Town.png");
        heroHome1F = palletTownInteriors.crop(186, 5, 192, 144);
        heroHome2F = palletTownInteriors.crop(5, 5, 176, 144);
        rivalHome1F = palletTownInteriors.crop(5, 178, 208, 144);
        oaksLab1F = palletTownInteriors.crop(218, 178, 208, 208);

        heroDown = new  BufferedImage[3];
        heroDown[0] = heroHeroine.crop(24, 24, 16, 32);
        heroDown[1] = heroHeroine.crop(8, 24, 16, 32);
        heroDown[2] = heroHeroine.crop(40, 24, 16, 32);
        heroUp = new BufferedImage[3];
        heroUp[0] = heroHeroine.crop(24, 56, 16, 32);
        heroUp[1] = heroHeroine.crop(8, 56, 16, 32);
        heroUp[2] = heroHeroine.crop(40, 56, 16, 32);
        heroLeft = new BufferedImage[3];
        heroLeft[0] = heroHeroine.crop(24, 88, 16, 32);
        heroLeft[1] = heroHeroine.crop(8, 88, 16, 32);
        heroLeft[2] = heroHeroine.crop(40, 88, 16, 32);
        heroRight = new BufferedImage[3];
        heroRight[0] = ImageFliper.flipHorizontally(heroLeft[0]);
        heroRight[1] = ImageFliper.flipHorizontally(heroLeft[1]);
        heroRight[2] = ImageFliper.flipHorizontally(heroLeft[2]);
        momUp = npcs.crop(0, 0, 16, 32);
        momDown = npcs.crop(16, 0, 16, 32);
        momLeft = npcs.crop(32, 0, 16, 32);
        momRight = ImageFliper.flipHorizontally(momLeft);
    }
}
