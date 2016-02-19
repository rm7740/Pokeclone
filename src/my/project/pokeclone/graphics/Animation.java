package my.project.pokeclone.graphics;

import java.awt.image.BufferedImage;

public class Animation {

    private int frameCounter;
    private int frameIndex;
    private BufferedImage[] bufferedImages;

    public Animation(BufferedImage[] bufferedImages) {
        this.bufferedImages = bufferedImages;
        frameCounter = 0;
        frameIndex = 1;
    }

    public BufferedImage getAnimationFrame() {
       if (frameCounter > 20) {
           frameCounter = 0;
           frameIndex++;
           if (frameIndex == bufferedImages.length)
               frameIndex = 1;
       }
       frameCounter++;
        return bufferedImages[frameIndex];
    }

    public BufferedImage getFixedFrame() {
        return bufferedImages[0];
    }
}
