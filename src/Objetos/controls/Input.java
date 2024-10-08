package Objetos.controls;

import helpers.Vector2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Input implements KeyListener {
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";

    private static List<String> heldDirections = new ArrayList<>();

    // Método para pegar a lista de direções atuais
    public Vector2 getInput() {
        if (heldDirections.isEmpty()) {
            return Vector2.vetorNulo();
        }

        int toMoveX = 0;
        int toMoveY = 0;

        for (String direction : heldDirections) {
            switch (direction) {
                case LEFT:
                    toMoveX--;
                    break;
                case RIGHT:
                    toMoveX++;
                    break;
                case UP:
                    toMoveY--;
                    break;
                case DOWN:
                    toMoveY++;
                    break;
            }
        }
        return new Vector2(toMoveX, toMoveY);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char input = e.getKeyChar();

        switch (input) {
            case 'w':
                onArrowPressed(UP);
                break;
            case 's':
                onArrowPressed(DOWN);
                break;
            case 'a':
                onArrowPressed(LEFT);
                break;
            case 'd':
                onArrowPressed(RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char input = e.getKeyChar();

        switch (input) {
            case 'w':
                onArrowReleased(UP);
                break;
            case 's':
                onArrowReleased(DOWN);
                break;
            case 'a':
                onArrowReleased(LEFT);
                break;
            case 'd':
                onArrowReleased(RIGHT);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não precisamos implementar isso para movimentação
    }

    // Métodos para adicionar/remover direções
    public void onArrowPressed(String direction) {
        if (!this.heldDirections.contains(direction)) {
            heldDirections.add(direction);
        }
    }

    public void onArrowReleased(String direction) {
        if (heldDirections.contains(direction)) {
            heldDirections.remove(direction);
        }
    }
}
