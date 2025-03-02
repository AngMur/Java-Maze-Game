package org.maze.visual.components;

import javax.swing.*;

public class MazeJFrame extends JFrame{

    GamePanel gamePanel; //Panel de juego
    StartPanel startPanel; //Panel inicial

    //Contructor
    public MazeJFrame(){
        //Aplicamos las configuraciones del frame
        this.config();

        //Inicializamos los paneles que se mostrarán
        this.initPanels();

    }

    //Configuraciones del frame
    public void config(){
        //Titulo
        this.setTitle("Maze Game");
        //No se puede cambiar el tamaño
        this.setResizable(false);
        //Borramos la barra de opciones que trae por defecto
        this.setUndecorated(true);
        //Tamaño del frame
        this.setSize(805, 455);
        //Ajustamos su posición al centro de la pantalla
        this.setLocationRelativeTo(null);
        //Se termina el programa al cerrar la ventana
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Se vuelve visible
        this.setVisible(true);
    }

    //Inicializar los paneles
    public void initPanels(){
        //Creamos los paneles que se motrarán y los vinculamos con este frame
        startPanel = new StartPanel(this);
        gamePanel = new GamePanel(this);

        //Añadimos los paneles al frame
        this.add(startPanel);
        this.add(gamePanel);

        //Se muestra el panel inicial
        showStartPanel();
    }

    //Mostrar panel de juego
    public void showGamePanel(){
        //Cambiamos la visibilidad de los paneles
        this.startPanel.setVisible(false);
        this.gamePanel.setVisible(true);

        //Hacemos que el panel visible pueda atender los eventos del teclado
        this.gamePanel.requestFocus();
    }

    //Mostrar panel inicial
    public void showStartPanel(){
        //Cambiamos la visibilidad de los paneles
        this.startPanel.setVisible(true);
        this.gamePanel.setVisible(false);

        //Hacemos que el panel visible pueda atender los eventos del teclado
        this.startPanel.requestFocus();
    }

   

}
