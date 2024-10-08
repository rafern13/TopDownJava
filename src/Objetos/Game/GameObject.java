package Objetos.Game;

import helpers.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    public Vector2 position = new Vector2(0, 0);
    private final List<GameObject> children = new ArrayList<>();

    public GameObject(Vector2 position) {
        this.position = position;
    }

    public GameObject() {

    }

    public void addChild(GameObject objeto) {
        if (objeto != null && !children.contains(objeto)) {
            children.add(objeto);
        }
    }

    public void removeChild(GameObject child) {
        children.remove(child);
    }

    public void stepEntry(Double timeStep, GameObject root) {
        children.forEach((GameObject x) -> x.stepEntry(timeStep, root));

        step(timeStep, root);
    }

    public void step(Double timeStep, GameObject root) {
    }

    public void draw(Graphics2D g) {
        drawImage(g);

        children.forEach(x -> x.drawImage(g));
    }


    public void drawImage(Graphics2D g) {
        g.clearRect(0,0, 0, 0);
    }




}
