package org.maze.visual.components;

import org.maze.game.components.GameManager;
import org.maze.game.components.MyKeyAdapter;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    MazeJFrame parentFrame;
    GameManager gameManager;
    //Colores
    Color wall = new Color(191, 58, 63);
    Color player = new Color(255, 255, 255);
    Color destiny = new Color(255, 252, 87);
    //Configuracion de los bloques dentro de la pantalla
    int blockWidth = 35;
    int blockHeight = 35;

    public GamePanel(MazeJFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.gameManager = new GameManager(this);
        this.config();
        this.setFocusable(true);
        addKeyListener(new MyKeyAdapter(gameManager));
    }

    public void config() {
        this.setSize(parentFrame.getWidth(), parentFrame.getHeight());
        this.setBackground(new Color(0, 0, 0));
    }

    public void gameOver() {
        this.parentFrame.showStartPanel();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        int[][] gameMatrix = this.gameManager.getCurrentLevel();

        for (int row = 0; row < gameMatrix.length; row++) {
            for (int column = 0; column < gameMatrix[0].length; column++) {
                if (gameMatrix[row][column] == 1) {
                    drawWall(g, wall, column, row);
                }
                else if (gameMatrix[row][column] == 3) {
                    drawWall(g, destiny, column, row);
                }
                else if (gameMatrix[row][column] == 2) {
                    drawPlayer(g, column, row);
                }
            }
        }
    }

    private void drawWall(Graphics g, Color color, int column, int row) {
        g.setColor(color);
        g.fillRect(column * blockWidth, row * blockHeight, blockWidth, blockHeight);
        g.setColor(Color.black);
    }

    private void drawPlayer(Graphics g, int column, int row) {
        g.setColor(player);
        g.fillOval(column * blockWidth, row * blockHeight, blockWidth, blockHeight);
        g.setColor(Color.black);
        g.drawOval(column * blockWidth, row * blockHeight, blockWidth, blockHeight);
    }

} 
