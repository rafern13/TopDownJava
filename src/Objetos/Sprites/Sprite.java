package Objetos.Sprites;

import Objetos.Game.GameObject;
import helpers.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Sprite extends GameObject {
    public BufferedImage resource;
    public Vector2 frameSize;
    private int hFrames = 1;
    private int vFrames = 1;
    public int actualFrame = 0;
    public int scale = 1;
    private final Map<Integer, Vector2> frameMap = new HashMap<>();
    int frameCount = 0;
    int v = vFrames;
    int h = hFrames;

    public Sprite(BufferedImage resource, Vector2 frameSize, Vector2 position, int hFrames, int vFrames, int actualFrame, int scale) {
        super(position);
        this.frameSize = frameSize;
        this.resource = resource;
        this.hFrames = hFrames;
        this.vFrames = vFrames;
        this.actualFrame = actualFrame;
        this.scale = scale;
        buildFrameMap();
    }

    public Sprite(BufferedImage resource, Vector2 frameSize) {
        this.frameSize = frameSize;
        this.resource = resource;
    }

    public BufferedImage getFrame() {
        BufferedImage image = getResource();
        Vector2 initialPositions = this.frameMap.get(this.actualFrame);
        if(initialPositions == null) {
            initialPositions = Vector2.vetorNulo();
        }
        return image.getSubimage(initialPositions.x, initialPositions.y, this.frameSize.x, this.frameSize.y);
    }

    public BufferedImage getResource() {
        return this.resource;
    }

    public void step(Double timeStep, GameObject root) {

    }

    public void drawImage(Graphics2D g) {
        BufferedImage frame = this.getFrame();
        if (frame != null) {
            g.drawImage(frame, this.position.x, this.position.y, this.frameSize.x, this.frameSize.y, null);
        }
    }

    private void buildFrameMap() {

        for ( v = 0; v < this.vFrames; v++) {
            for (h = 0; h < this.hFrames; h++) {
                int xPos = h * this.frameSize.x;
                int yPos = v * this.frameSize.y;

                frameMap.put(frameCount, new Vector2(xPos, yPos));
                frameCount++;
            }
        }

    }

}
