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

        getIntoMapLimits();
    }

    public void getIntoMapLimits() {
        if (xOffset < 0) xOffset = 0;
        if (xOffset > (handler.getGameMap().getWidth() - handler.getGameWidth())) {
            xOffset = (handler.getGameMap().getWidth() - handler.getGameWidth());
        }

        if (yOffset < 0) yOffset = 0;
        if (yOffset > (handler.getGameMap().getHeight() - handler.getGameHeight())) {
            yOffset = (handler.getGameMap().getHeight() - handler.getGameHeight());
        }
    }

    public int getxOffset() {
        return xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }
}
