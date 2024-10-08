package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(BufferedImage img) {
        this.image = img;
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Escalando a imagem para caber no painel
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
