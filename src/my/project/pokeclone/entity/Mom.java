package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import my.project.pokeclone.graphics.Asset;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mom extends LiveEntity{

    private BufferedImage momUp, momDown, momLeft, momRight;

    public Mom(Handler handler, int x, int y) {
        super(handler, x, y);
        width = 16;
        height = 32;
        speed = 0;

        facingLeft = true;
        momUp = Asset.momUp;
        momDown = Asset.momDown;
        momLeft = Asset.momLeft;
        momRight = Asset.momRight;
    }

    @Override
    public void setAnimationFrame() {
        if (facingUp) {
            currentFrame = momUp;
        }
        else if (facingDown) {
            currentFrame = momDown;
        }
        else if (facingLeft) {
           currentFrame = momLeft;
        }
        else if (facingRight) {
           currentFrame = momRight;
        }
    }

    @Override
    public void useAI() {}

    @Override
    public void react() {
        if (handler.getGameState().getPlayer().isFacingUp()) {
            facingDown = true;
            facingUp = facingLeft = facingRight = false;
        }
        if (handler.getGameState().getPlayer().isFacingDown()) {
            facingUp = true;
            facingDown = facingLeft = facingRight = false;
        }
        if (handler.getGameState().getPlayer().isFacingLeft()) {
            facingRight = true;
            facingUp = facingLeft = facingDown = false;
        }
        if (handler.getGameState().getPlayer().isFacingRight()) {
            facingLeft = true;
            facingUp = facingDown = facingRight = false;
        }
    }

    @Override
    public void update() {
        setAnimationFrame();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(currentFrame, (x - handler.getGameCamera().getxOffset()), (y - handler.getGameCamera().getyOffset()), null, null);
    }
}
