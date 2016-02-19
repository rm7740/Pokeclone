package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import my.project.pokeclone.graphics.Animation;
import my.project.pokeclone.graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends LiveEntity{

    private Animation playerUp, playerDown, playerLeft, playerRight;
    private boolean isBoy;
    private boolean facingUp, facingDown, facingLeft, facingRight;
    private BufferedImage currentFrame;

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

    public void getInput() {
        yMove = 0;
        xMove = 0;
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
    }

    public Rectangle getBounds(int x, int y) {
        return new Rectangle((x), (y + 16), (width), (height - 16));
    }

    public void setTravelVector() {
        lastX = x;
        lastY = y;
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
        setAnimationFrame();
        handler.getGameCamera().centerOnEntity(this);
        setTravelVector();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(currentFrame, (x - handler.getGameCamera().getxOffset()), (y - handler.getGameCamera().getyOffset()), null, null);
    }
}
