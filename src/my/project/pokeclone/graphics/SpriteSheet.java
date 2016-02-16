package my.project.pokeclone.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage bufferedImage;

    public SpriteSheet(BufferedImage sheet) {
        this.bufferedImage = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return bufferedImage.getSubimage(x, y, width, height);
    }
}
