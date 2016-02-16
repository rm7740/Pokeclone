package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;
import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    public Entity(Handler handler ,float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void update();

    public abstract void render(Graphics graphics);
}
