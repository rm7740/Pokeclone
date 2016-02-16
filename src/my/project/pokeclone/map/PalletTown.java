package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import java.awt.image.BufferedImage;

public class PalletTown extends GameMap{

    public PalletTown(Handler handler, BufferedImage bufferedImage) {
        super(handler, bufferedImage);
        width = 384;
        height = 320;
    }
}
