package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected int x, y;
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Handler handler ,int x, int y) {
        this.handler = handler;
        this.x = x;
        this.y = y;
    }

    public abstract Rectangle getBounds(int x, int y);

    public abstract void react();

    public abstract void update();

    public abstract void render(Graphics graphics);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
