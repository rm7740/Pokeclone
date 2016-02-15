package my.project.pokeclone.display;

import my.project.pokeclone.input.KeyManager;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width, height;

    public GameWindow(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createWindow();
    }

    private void createWindow() {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new KeyManager());
    }
}
