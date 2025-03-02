package org.maze.visual.components;

import javax.swing.*;

import java.awt.*;

public class StartPanel extends JPanel{

    MazeJFrame parentFrame; //Frame donde se muestra el panel
    JLabel titleLabel = new JLabel("Java Maze Game", JLabel.CENTER); //Titulo del panel
    JButton startButton = new JButton("Play"); //Boton de inicio
    JButton leaveButton; //Boton de inicio

    //Contructor 
    public StartPanel(MazeJFrame parentFrame){
        //Guardamos la vinculación con el frame en donde se muestra 
        this.parentFrame = parentFrame;
        //Aplicamos configuracion
        this.config();
        //Inicializamos los componentes del panel
        this.initIcon();
        this.initTitle();
        this.initStartButton();
        this.initLeaveButton();
    }

    //Configuraciones del panel inicial
    public void config(){
        this.setLayout(null);
        this.setSize(parentFrame.getWidth(), parentFrame.getHeight());
        this.setBackground(new Color( 0,0,0));
    }

    //Inicializar el titulo
    public void initTitle(){
        //Posicioamiento y tamaño
        this.titleLabel.setBounds(0,200, parentFrame.getWidth(), 100);

        //Estilos del titulo
        this.titleLabel.setForeground(new Color(191, 58, 63));
        this.titleLabel.setFont(new Font("Playball", Font.BOLD, 50));

        //Añadimos el label al panel
        this.add(titleLabel);
    }

    //Inicializar Icon
    public void initIcon(){
        // Cargar la imagen en un ImageIcon
        ImageIcon imageIcon = new ImageIcon( getClass().getResource("/CoffeeIcon.jpg") );

        // Crear el JLabel y asignarle la imagen
        JLabel label = new JLabel(imageIcon);

        // Ajustamos posición y tamaño del label 
        label.setBounds(0,30, parentFrame.getWidth(), 200);
    
        // Añadimos este componente al panel
        this.add(label);
    }

    //Inicializar el botón
    public void initStartButton(){
        //Posicionamiento y tamaño
        int buttonWidth = 150;
        int buttonHeight = 80;
        int xPosition = (parentFrame.getWidth() / 2) - (buttonWidth / 2);
        int yPosition = 320;
        this.startButton.setBounds(xPosition, yPosition, buttonWidth, buttonHeight);

        //Estilos del botón
        this.startButton.setForeground(new Color(17, 17, 17));
        this.startButton.setBackground(new Color(255, 255, 255 ));
        this.startButton.setFont(new Font("Playball", Font.BOLD, 30));

        //Evento al dar click al botón: se muestra el panel de juego
        this.startButton.addActionListener(e -> parentFrame.showGamePanel());

        //Añadimos el botón al panel
        this.add(this.startButton);
    }

    private void initLeaveButton(){
        // Cargar la imagen en un ImageIcon
        ImageIcon imageIcon = new ImageIcon( getClass().getResource("/ExitIcon.png") );

        leaveButton = new JButton(imageIcon);

        //Posicionamiento y tamaño
        int buttonWidth = 30;
        int buttonHeight = 30;
        int xPosition = parentFrame.getWidth() - 40;
        int yPosition = 10;
        this.leaveButton.setBounds(xPosition, yPosition, buttonWidth, buttonHeight);

        //Estilos del botón
        this.leaveButton.setBackground(new Color(0, 0, 0));
        this.leaveButton.setFocusPainted(false);
        this.leaveButton.setFocusable(false);
        this.leaveButton.setBorderPainted(false);
        this.leaveButton.setContentAreaFilled(false);
        this.leaveButton.setBorderPainted(false);

        //Evento al dar click al botón: se cierra el juego
        this.leaveButton.addActionListener(e -> System.exit(0));

        //Añadimos el botón al panel
        this.add(this.leaveButton);
    }

    
}
