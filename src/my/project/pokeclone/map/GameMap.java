package my.project.pokeclone.map;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.EntityManager;
import my.project.pokeclone.entity.Player;
import my.project.pokeclone.util.TextFileLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameMap {

    protected Handler handler;
    protected int width, height;
    protected BufferedImage bufferedImage;
    protected EntityManager entityManager;
    protected int[][] collisionTiles;
    protected int[][] teleportTiles;
    protected int horizontalTiles, verticalTiles;
    protected int tileSide;
    protected Player player;

    public GameMap(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entityManager = new EntityManager(handler);
        init();
    }

    protected abstract void init();

    public void update() {
        entityManager.update();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(bufferedImage, (-handler.getGameCamera().getxOffset()), (-handler.getGameCamera().getyOffset()), null, null);
        entityManager.render(graphics);
    }

    public void loadCollisionTiles(String path) {
        loadTiles(collisionTiles, path);
    }

    public void loadTeleportTiles(String path) {
        loadTiles(teleportTiles, path);
    }

    private void loadTiles(int[][] tiles, String path) {
        String mapFile = TextFileLoader.loadFileAsString(path);
        String[] tokens = mapFile.split("\\s+");

        horizontalTiles = width / tileSide;
        verticalTiles = height / tileSide;

        collisionTiles = new int[horizontalTiles][verticalTiles];
        for(int y = 0; y < verticalTiles; y++){
            for(int x = 0; x < horizontalTiles; x++){
                tiles[x][y] = Integer.parseInt(tokens[x + (y * horizontalTiles)]);
            }
        }
    }

    public int getCollisionTile(int x, int y) {
        return collisionTiles[x][y];
    }

    public int getTeleportTile(int x, int y) {
        return teleportTiles[x][y];
    }

    public abstract GameMap getDestinationMap(int marker);

    public abstract int[] getDestinationPosition(int marker);

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
