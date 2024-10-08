package helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadCharacterSprites {
    private static Path hero = Paths.get("./public/sprites/characters/hero-sheet.png");
    private static Path shadow = Paths.get("./public/sprites/characters/shadow.png");

    public static BufferedImage loadHero() {
        try {
            BufferedImage image = ImageIO.read(Files.newInputStream(hero));
            return image;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage loadShadow() {
        try {
            return ImageIO.read(Files.newInputStream(shadow));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
