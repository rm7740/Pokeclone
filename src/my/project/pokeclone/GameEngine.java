package my.project.pokeclone;

import my.project.pokeclone.display.GameWindow;

public class GameEngine implements Runnable{

    private boolean isRunning = false;
    private Thread thread;
    private GameWindow gameWindow;
    private String title;
    private int width, height;
    private Handler handler;

    public GameEngine(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void start() {
        if (isRunning) return;
        isRunning = true;

        thread = new Thread(this);
        thread.run();
    }

    public void stop() {
        if (!isRunning) return;
        isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();

        int fps = 60;
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int updates = 0;

        while(isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpdate;
            timer += (now - lastTime);
            lastTime = now;
            if (delta >= 1) {
                update();
                render();
                updates++;
                delta--;
            }
            if(timer >= 1000000000){
                System.out.println("Updates and frames: " + updates);
                timer = 0;
                updates = 0;
            }
        }
        stop();
    }

    private void render() {

    }

    private void update() {

    }

    private void init() {
        gameWindow = new GameWindow(title, width, height);
        handler = new Handler(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }
}
