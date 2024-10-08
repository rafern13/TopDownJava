package view;

import Objetos.Game.GameObject;
import Objetos.Game.Source;
import Objetos.Hero.Hero;
import Objetos.controls.Input;
import helpers.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.Paths;

public class GameWindow extends JFrame {
    private Vector2 frameSize = new Vector2(320, 180);
    private int originalWidth = frameSize.x;
    private int originalHeight = frameSize.y;
    private int scaleFactor = 4;
    private ImagePanel displayPanel;
    private BufferedImage renderBuffer;
    private Source lvl1 = new Source(Paths.get("C:\\Users\\rafsf\\Documents\\repos\\TopDownJava\\TopDownJava-main\\public\\sprites\\Level1"));
    private GameObject mainscene = lvl1.mainScene;
    public Hero hero = new Hero();
    Input input = hero.input;
    public GameWindow() {
        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(originalWidth * scaleFactor, originalHeight * scaleFactor);

        // Criação do buffer de renderização
        renderBuffer = new BufferedImage(originalWidth, originalHeight, BufferedImage.TYPE_INT_ARGB);
        displayPanel = new ImagePanel(renderBuffer);
        displayPanel.setBounds(0, 0, originalWidth * scaleFactor, originalHeight * scaleFactor);

        add(displayPanel);
        this.addKeyListener(input);
        setVisible(true);
    }

    public GameWindow(Vector2 frameSize, int scaleFactor) {
        this();
        this.originalHeight = frameSize.y;
        this.originalWidth = frameSize.x;
        this.scaleFactor = scaleFactor;
    }

    public void update(double timeStep) {
        mainscene.stepEntry(timeStep, mainscene);
    }

    public void reDraw() {
        Graphics2D g2d = renderBuffer.createGraphics();
        drawImage(g2d);
        g2d.dispose();
        displayPanel.repaint();

    }


    public void drawImage(Graphics2D g) {
        mainscene.draw(g);
    }


}
