package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.EntityManager;
import my.project.pokeclone.util.TextFileLoader;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameMap {

    protected Handler handler;
    protected int width, height;
    protected BufferedImage bufferedImage;
    protected int xOffset, yOffset;
    protected EntityManager entityManager;
    protected int[][] collisionTiles;
    protected int horizontalTiles, verticalTiles;
    protected int tileSide;

    public GameMap(Handler handler) {
        this.handler = handler;
        entityManager = new EntityManager(handler);
        init();
    }

    protected abstract void init();

    public void update() {}

    public void render(Graphics graphics) {
        graphics.drawImage(bufferedImage, xOffset, yOffset, null, null);
    }

    public void loadCollisionTiles(String path) {
        String mapFile = TextFileLoader.loadFileAsString(path);
        String[] tokens = mapFile.split("\\s+");

        horizontalTiles = width / tileSide;
        verticalTiles = height / tileSide;

        collisionTiles = new int[horizontalTiles][verticalTiles];
        for(int y = 0; y < verticalTiles; y++){
            for(int x = 0; x < horizontalTiles; x++){
                collisionTiles[x][y] = Integer.parseInt(tokens[x + (y * horizontalTiles)]);
            }
        }
    }

    public int getCollisionTile(int x, int y) {
        return collisionTiles[x][y];
    }
}
