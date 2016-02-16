package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;

public abstract class LiveEntity extends Entity{

    protected float speed;
    protected float xMove, yMove;

    public LiveEntity(Handler handler, float x, float y, int width, int height, float speed) {
        super(handler, x, y, width, height);
        this.speed = speed;
    }

    public void move() {
        moveX();
        moveY();
    }

    protected void moveY() {
        y = yMove;
    }

    protected void moveX() {
        x = xMove;
    }
}
