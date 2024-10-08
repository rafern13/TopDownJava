package Objetos.Game;

import view.GameWindow;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameLoop {
    private Long animationId = ThreadLocalRandom.current().nextLong();
    private boolean isRunning = false;
    private double lastFrameTime = 0;
    private double currentTime = 0;
    private static GameWindow thisGame = null;
    private double timeStep = (double) 1000 / 60; // Ajustado para 60 FPS
    private int updateCount = 0; // Contador de atualizações
    private long lastCountTime = System.currentTimeMillis(); // Tempo do último contador
    private Graphics2D updateGraphics = null;

    private GameLoop(GameWindow game) {
        thisGame = game;
    }

    public void setFps(int fps) {
        this.timeStep = (double) 1000 / fps;
    }

    public double getFps() {
        return 1000 / timeStep;
    }

    public static GameLoop getInstance(GameWindow game) {
            return new GameLoop(game);

    }

    public void mainLoop(Long animationId) {
        if (!animationId.equals(this.animationId) || !isRunning) {
            return;
        }

        while (isRunning) {
            // Tempo atual
            double currentTimeMillis = System.currentTimeMillis();
            double deltaTime = currentTimeMillis - this.lastFrameTime;
            this.lastFrameTime = currentTimeMillis;
            this.currentTime += deltaTime;

            // Contador de atualizações
            while (this.currentTime >= this.timeStep) {
                thisGame.update(this.timeStep);

                this.currentTime -= this.timeStep;
                updateCount++; // Incrementa o contador de atualizações
                thisGame.reDraw();

            }



            // Verifica se um segundo se passou para imprimir o número de atualizações
            if (System.currentTimeMillis() - lastCountTime >= 1000) {
                System.out.println("Atualizações em 1s: " + updateCount);
                updateCount = 0; // Reinicia o contador
                lastCountTime = System.currentTimeMillis(); // Atualiza o tempo do contador
            }

            // Para não sobrecarregar a CPU
            try {
                Thread.sleep(1); // Espera 1 milissegundo antes de continuar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            lastFrameTime = System.currentTimeMillis(); // Inicializa lastFrameTime
            mainLoop(this.animationId); // Chama o loop principal
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
        }
    }
}
