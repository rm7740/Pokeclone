package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import my.project.pokeclone.graphics.Asset;

import java.awt.*;

public class Player extends LiveEntity{

    public Player(Handler handler, int x, int y) {
        super(handler, x, y);
        width = 16;
        height = 32;
        speed = 2;
    }

    public void getInput() {
        yMove = 0;
        xMove = 0;
        if (handler.getKeyManager().up) yMove = -speed;
        if (handler.getKeyManager().down) yMove = speed;
        if (handler.getKeyManager().left) xMove = -speed;
        if (handler.getKeyManager().right) xMove = speed;
    }

    @Override
    public void update() {
        getInput();
        move();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Asset.heroRight, x, y, null, null);
    }
}
