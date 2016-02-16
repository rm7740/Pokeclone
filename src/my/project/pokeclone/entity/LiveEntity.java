package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;

public abstract class LiveEntity extends Entity{

    protected int speed;
    protected int xMove, yMove;

    public LiveEntity(Handler handler, int x, int y) {
        super(handler, x, y);
    }

    public boolean checkEntityCollision(int x, int y) {
        return false;
    }

    public void move() {
        moveX();
        moveY();
    }

    protected void moveY() {
        y += yMove;
    }

    protected void moveX() {
        x += xMove;
    }
}
