package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.EntityManager;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameMap {

    protected Handler handler;
    protected int width, height;
    protected BufferedImage bufferedImage;
    protected int xOffset, yOffset;
    protected EntityManager entityManager;

    public GameMap(Handler handler, BufferedImage bufferedImage) {
        this.handler = handler;
        this.bufferedImage = bufferedImage;

        entityManager = new EntityManager(handler);
    }

    public void update() {}

    public void render(Graphics graphics) {
        graphics.drawImage(bufferedImage, xOffset, yOffset, null, null);
    }
}
