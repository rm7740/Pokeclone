package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameMap {

    private Handler handler;
    private int width, height;
    private BufferedImage bufferedImage;

    public GameMap(Handler handler, BufferedImage bufferedImage) {
        this.handler = handler;
        this.bufferedImage = bufferedImage;
    }

    public void update() {}

    public void render(Graphics graphics) {
        graphics.drawImage(bufferedImage, 0, 0, null, null);
    }
}
