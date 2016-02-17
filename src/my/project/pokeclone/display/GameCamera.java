package my.project.pokeclone.display;

import my.project.pokeclone.Handler;
import my.project.pokeclone.entity.Entity;

public class GameCamera {

    private Handler handler;
    private int xOffset;
    private int yOffset;

    public GameCamera(Handler handler) {
        this.handler = handler;
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX() + (entity.getWidth() / 2) - (handler.getGameWidth() / 2);
        yOffset = entity.getY() + (entity.getHeight() / 2) -(handler.getGameHeight() / 2);
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }
}
