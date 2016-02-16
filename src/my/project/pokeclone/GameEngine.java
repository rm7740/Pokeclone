package my.project.pokeclone;

import my.project.pokeclone.display.GameWindow;
import my.project.pokeclone.input.KeyManager;
import my.project.pokeclone.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameEngine implements Runnable{

    private boolean isRunning = false;
    private Thread thread;
    private GameWindow gameWindow;
    private String title;
    private int width, height;
    private Handler handler;
    private KeyManager keyManager;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    public GameEngine(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();
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
        bufferStrategy = gameWindow.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            gameWindow.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, width, height);

        if(State.getCurrentState() != null){
            State.getCurrentState().render(graphics);
        }
        bufferStrategy.show();
        graphics.dispose();
    }

    private void update() {
        keyManager.update();
        if(State.getCurrentState() != null){
            State.getCurrentState().update();
        }
    }

    private void init() {
        gameWindow = new GameWindow(title, width, height);
        gameWindow.getFrame().addKeyListener(keyManager);
        handler = new Handler(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}
