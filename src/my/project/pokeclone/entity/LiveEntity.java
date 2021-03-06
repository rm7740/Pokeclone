package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class LiveEntity extends Entity{

    protected int speed;
    protected int xMove, yMove;
    protected int lastX = x;
    protected int lastY = y;
    protected boolean facingUp, facingDown, facingLeft, facingRight;
    protected BufferedImage currentFrame;

    public LiveEntity(Handler handler, int x, int y) {
        super(handler, x, y);
    }

    public Rectangle getBounds(int x, int y) {
        return new Rectangle((x), (y + 16), (width), (height - 16));
    }

    public boolean checkCollisionWithTile(int x, int y) {
        if (handler.getGameMap().getCollisionTile(x, y) == 1) return true;
        return false;
    }

    public boolean checkTileCollision() {
        bounds = getBounds(x, y);

        int upLeftX = bounds.x / 16;
        int upLeftY = bounds.y / 16;

        int upRightX = (bounds.x + bounds.width - 1) / 16;
        int upRightY = bounds.y / 16;

        int downLeftX = bounds.x / 16;
        int downLeftY = (bounds.y + bounds.height - 1) / 16;

        int downRightX = (bounds.x + bounds.width - 1) / 16;
        int downRightY = (bounds.y + bounds.height - 1) / 16;

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

    public boolean checkOutOfMap() {
        bounds = getBounds(x, y);
        int mapHeight = handler.getGameMap().getHeight();
        int mapWidth = handler.getGameMap().getWidth();
        return (bounds.y < 0 || bounds.x < 0 || (bounds.y + bounds.height) > mapHeight
                || (bounds.x + bounds.width) > mapWidth);

    }

    public void move() {
        moveX();
        moveY();
    }

    protected void moveY() {
        int previousY = y;
        y += yMove;
        if (checkOutOfMap()) {
            y = previousY;
        }
        if (checkEntityCollision()) {
            y = previousY;
        }
        if (checkTileCollision()) {
            y = previousY;
        }
        if (y % 16 == 0) yMove = 0;
    }

    protected void moveX() {
        int previousX = x;
        x += xMove;
        if (checkOutOfMap()) {
            x = previousX;
        }
        else if (checkEntityCollision()) {
            x = previousX;
        }
        else if (checkTileCollision()) {
            x = previousX;
        }
        if (x % 16 == 0) xMove = 0;
    }

    public abstract void setAnimationFrame();

    public abstract void useAI();

    public boolean isFacingUp() {
        return facingUp;
    }

    public boolean isFacingDown() {
        return facingDown;
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public boolean isFacingRight() {
        return facingRight;
    }
}
