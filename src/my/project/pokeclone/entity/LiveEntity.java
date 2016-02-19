package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import java.awt.*;

public abstract class LiveEntity extends Entity{

    protected int speed;
    protected int xMove, yMove;
    protected int lastX = x;
    protected int lastY = y;

    public LiveEntity(Handler handler, int x, int y) {
        super(handler, x, y);
    }

    public abstract Rectangle getBounds(int x, int y);

    public boolean checkCollisionWithTile(int x, int y) {
        if (handler.getGameMap().getCollisionTile(x, y) == 1) return true;
        return false;
    }

    public boolean checkTileCollision() {
        bounds = getBounds(x, y);

        int upLeftX = bounds.x / 16;
        int upLeftY = bounds.y / 16;

        int upRightX = (bounds.x + bounds.width) / 16;
        int upRightY = bounds.y / 16;

        int downLeftX = bounds.x / 16;
        int downLeftY = (bounds.y + bounds.height) / 16;

        int downRightX = (bounds.x + bounds.width) / 16;
        int downRightY = (bounds.y + bounds.height) / 16;

        boolean upLeftCollision = checkCollisionWithTile(upLeftX, upLeftY);
        boolean upRightCollision = checkCollisionWithTile(upRightX, upRightY);
        boolean downLeftCollision = checkCollisionWithTile(downLeftX, downLeftY);
        boolean downRightCollision = checkCollisionWithTile(downRightX, downRightY);

        if (upLeftCollision || upRightCollision || downLeftCollision || downRightCollision) {
            return true;
        }
        return false;
    }

    public boolean checkEntityCollision() {
        boolean hasCollided = false;
        for (Entity entity: handler.getGameMap().getEntityManager().getEntities()) {
            if (entity == this) {
                continue;
            }
            if (this.getBounds(x, y).intersects(entity.getBounds(entity.getX(), entity.getY()))) {
                hasCollided = true;
            }
        }
        return hasCollided;
    }

    public void move() {
        moveX();
        moveY();
    }

    protected void moveY() {
        int previousY = y;
        y += yMove;
        if (checkEntityCollision()) {
            y = previousY;
        }
        if (checkTileCollision()) {
            y = previousY;
        }
    }

    protected void moveX() {
        int previousX = x;
        x += xMove;
        if (checkEntityCollision()) {
            x = previousX;
        }
        if (checkTileCollision()) {
            x = previousX;
        }
    }
}
