package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import my.project.pokeclone.graphics.Animation;
import my.project.pokeclone.graphics.Asset;
import my.project.pokeclone.map.GameMap;

import java.awt.*;

public class Player extends LiveEntity{

    private Animation playerUp, playerDown, playerLeft, playerRight;
    private boolean isBoy;

    public Player(Handler handler, int x, int y, boolean isBoy) {
        super(handler, x, y);
        this.isBoy = isBoy;
        width = 16;
        height = 32;
        speed = 1;
        facingDown = true;
        setGender(isBoy);
    }

    private void setGender(boolean isBoy) {
        if (isBoy) {
            playerUp = new Animation(Asset.heroUp);
            playerDown = new Animation(Asset.heroDown);
            playerLeft = new Animation(Asset.heroLeft);
            playerRight = new Animation(Asset.heroRight);
        }
    }

    public void setTravelVector() {
        lastX = x;
        lastY = y;
    }

    public void getInput() {
        if (handler.getKeyManager().up) {
            if (facingUp) {
                yMove = -speed;
            }
            else {
                facingUp = true;
                facingDown = facingLeft = facingRight = false;
            }
        }
        if (handler.getKeyManager().down) {
            if (facingDown) {
                yMove = speed;
            }
            else {
                facingDown = true;
                facingUp = facingLeft = facingRight = false;
            }
        }
        if (handler.getKeyManager().left) {
            if (facingLeft) {
                xMove = -speed;
            }
            else {
                facingLeft = true;
                facingUp = facingDown = facingRight = false;
            }
        }
        if (handler.getKeyManager().right) {
            if (facingRight) {
                xMove = speed;
            }
            else {
                facingRight = true;
                facingUp = facingDown = facingLeft = false;
            }
        }
        if (handler.getKeyManager().aButton) {
            interact();
        }
    }

    private void interact() {
        if (facingUp) {
            handler.getGameMap().getEntityManager().getEntities().stream()
                                                                 .filter(e -> e.getX() == x)
                                                                 .filter(e -> e.getY() == y - 16)
                                                                 .forEach(Entity::react);
        }
        if (facingDown) {
            handler.getGameMap().getEntityManager().getEntities().stream()
                                                                 .filter(e -> e.getX() == x)
                                                                 .filter(e -> e.getY() == y + 16)
                                                                 .forEach(Entity::react);
        }
        if (facingLeft) {
            handler.getGameMap().getEntityManager().getEntities().stream()
                                                                 .filter(e -> e.getY() == y)
                                                                 .filter(e -> e.getX() == x - 16)
                                                                 .forEach(Entity::react);
        }
        if (facingLeft) {
            handler.getGameMap().getEntityManager().getEntities().stream()
                                                                 .filter(e -> e.getY() == y)
                                                                 .filter(e -> e.getX() == x + 16)
                                                                 .forEach(Entity::react);
        }
    }

    public boolean checkPortalTile() {
        bounds = getBounds(x, y);
        int xTileCoordinate = bounds.x / 16;
        int yTileCoordinate = bounds.y / 16;
        return (handler.getGameMap().getCollisionTile(xTileCoordinate, yTileCoordinate) == 7);
    }

    public void teleport() {
        if (checkPortalTile()) {
            int xTileCoordinate = bounds.x / 16;
            int yTileCoordinate = bounds.y / 16;
            int destination = handler.getGameMap().getTeleportTile(xTileCoordinate, yTileCoordinate);
            GameMap destinationMap = handler.getGameMap().getDestinationMap(destination);
            int[] coordinates = handler.getGameMap().getDestinationPosition(destination);
            handler.setGameMap(destinationMap);
            x = coordinates[0];
            y = coordinates[1];
            xMove = 0;
            yMove = 0;
        }
    }

    public void setAnimationFrame() {
        if (facingUp) {
            if (y != lastY) currentFrame = playerUp.getAnimationFrame();
            else currentFrame = playerUp.getFixedFrame();
        }
        else if (facingDown) {
            if (y != lastY) currentFrame = playerDown.getAnimationFrame();
            else currentFrame = playerDown.getFixedFrame();
        }
        else if (facingLeft) {
            if (x != lastX) currentFrame = playerLeft.getAnimationFrame();
            else currentFrame = playerLeft.getFixedFrame();
        }
        else if (facingRight) {
            if (x != lastX) currentFrame = playerRight.getAnimationFrame();
            else currentFrame = playerRight.getFixedFrame();
        }
    }

    @Override
    public void update() {
        getInput();
        move();
        teleport();
        setAnimationFrame();
        handler.getGameCamera().centerOnEntity(this);
        setTravelVector();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(currentFrame, (x - handler.getGameCamera().getxOffset()), (y - handler.getGameCamera().getyOffset()), null, null);
    }

    @Override
    public void react() {}

    @Override
    public void useAI() {}
}
