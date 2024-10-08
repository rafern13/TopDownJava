package Objetos.Hero;

import Objetos.Game.GameObject;
import Objetos.Sprites.Sprite;
import Objetos.controls.Input;
import helpers.LoadCharacterSprites;
import helpers.Vector2;

import java.awt.*;

public class Hero extends GameObject {
    public Sprite body;
    public Sprite shadow;
    private Sprite hero;
    public Input input = new Input();

    public Hero(Vector2 position) {
        super(position);
        initHero();
    }

    public Hero() {
        this(new Vector2(16 * 6, 16 * 5));
    }

    private void initHero() {
        body = new Sprite(
                LoadCharacterSprites.loadHero(),
                new Vector2(32, 32),
                this.position,
                3,
                8,
                1,
                1
        );
        hero = this.body;

        shadow = new Sprite(
                LoadCharacterSprites.loadShadow(),
                new Vector2(32, 32),
                new Vector2(this.body.position.x, this.body.position.y),
                1,
                1,
                0,
                1
        );

        body.addChild(shadow);
    }

    public void step(Double timeStep, GameObject root) {
        tryMove();
    }

    public void tryMove() {
        Vector2 direcoes = input.getInput();
        double toMoveX = direcoes.x;
        double toMoveY = direcoes.y;

        double magnitude = Math.sqrt(toMoveY * toMoveY + toMoveX * toMoveX);

        this.body.position.y += toMoveY;
        this.body.position.x += toMoveX;

    }

    public void drawImage(Graphics2D g) {
        int heroOffSetX = -8 * hero.scale;
        int heroOffSetY = -20 * hero.scale;
        g.drawImage(hero.getFrame(), hero.position.x + heroOffSetX, hero.position.y + heroOffSetY, hero.frameSize.x * hero.scale, hero.frameSize.y * hero.scale, null);
    }
}
