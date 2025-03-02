package org.maze.game.components;

import java.awt.event.*;

public class MyKeyAdapter extends KeyAdapter{

    GameManager gameManager;

    public MyKeyAdapter(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void keyPressed(KeyEvent k){
        switch (k.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                System.out.println("Mover arriba");
                gameManager.move(0);
                break;
        
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                System.out.println("Mover abajo");
                gameManager.move(1);

                break;
        
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                System.out.println("Mover izquierda");
                gameManager.move(2);

                break;
        
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                System.out.println("Mover derecha");
                gameManager.move(3);
                break;
        
            default:
                System.out.println("Otra tecla presionada");
        }
        
        
    }
}