package helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Resource {
    private Map<String,Path> imagePathsMap = new HashMap<>();
    private Map<String, BufferedImage> images = new HashMap<>();

    public Resource() {

    }

    public void buildImagesMap() {
        if(imagePathsMap.isEmpty()) {
            return;
        }
        imagePathsMap.forEach((key, value) -> {
            try {
                BufferedImage img = ImageIO.read(Files.newInputStream(value));
                images.put(key, img);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public Map<String, BufferedImage> getImages() {
        try{
            return images;
        } catch (InaccessibleObjectException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addToImagesPaths(String name, Path path) {
        if(name.isEmpty() || path != null) {
            imagePathsMap.put(name, path);
            return true;
        }
        return false;
    }

    public boolean removeFromImagesPath(String name) {
        if(!imagePathsMap.containsKey(name)) {
            return false;
        }
        imagePathsMap.remove(name);
        return true;
    }
}
