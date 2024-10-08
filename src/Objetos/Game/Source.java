package Objetos.Game;

import Objetos.Hero.Hero;
import Objetos.Sprites.Sprite;
import helpers.LoadCharacterSprites;
import helpers.Resource;
import helpers.Vector2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Source {
    private String levelName = "Start";
    private List<String> itemsNames = List.of("sky", "ground", "hero-sheet");
    private Resource level;
    public GameObject mainScene;

    public Source(Path levelPath) {
        buildLevelResource(levelPath);
        buildMainScene();
    }

    private void buildLevelResource(Path levelPath) {
        level = new Resource();
        itemsNames.forEach(x -> {
            String pathString = levelPath.toString() + "\\" + x + ".png";
            Path newPath = Paths.get(pathString);
            level.addToImagesPaths(x, newPath);
        });
        level.buildImagesMap();

    }

    private void buildMainScene() {
        mainScene = new GameObject(new Vector2(0, 0));
        Sprite skySprite = new Sprite(
                level.getImages().get("sky"),
                new Vector2(320, 180)
        );
        mainScene.addChild(skySprite);

        Sprite groundSprite = new Sprite(
                level.getImages().get("ground"),
                new Vector2(320, 180)
        );
        mainScene.addChild(groundSprite);

        Hero hero = new Hero();
        mainScene.addChild(hero);

    }


}
