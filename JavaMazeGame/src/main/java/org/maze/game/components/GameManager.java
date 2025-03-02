package org.maze.game.components;

import org.maze.visual.components.GamePanel;


public class GameManager {
    int levelIndex = 0; //En que nivel esta
    Levels levelsPointer = new Levels(); //Apuntador de la clase niveles
    int[][] level; //Matriz del nivel actual
    int[] current; //Posición actual
    int[] destiny; //Posición destino
    GamePanel gamePanel; //Panel donde se mostrarán los movimientos

    //Constructor 
    public GameManager(GamePanel gamePanel){
        //Vinculamos el panel visual al momento de crear un gestor de juego
        this.gamePanel = gamePanel;
        //Inicializamos el nivel inicial
        initNewLevel();

    }

    //Inicializador de niveles
    public void initNewLevel(){
        //Verificamos sí ya se ha alcanzado el número máximo de niveles
        if(this.levelIndex >= this.levelsPointer.maxLevels){
            this.levelIndex = 0; //Reiniciamos el contador de niveles a su valor inicial
            this.gamePanel.gameOver(); //Se aplica el proceso de GameOver
        }

        //Obtenemos la matriz atribuida al nivel en el que se encuentra el jugador
        this.level = this.levelsPointer.getLevel(this.levelIndex);

        //Obtenemos las posiciones iniciales y destino del nivel
        int[][] positions = this.levelsPointer.getPositions(this.levelIndex);
        this.current = positions[0]; //Posición  inicial
        this.destiny = positions[1]; //Posición destino

        //Después de inicializar cada nivel mostramos los cambios en el gamePanel
        this.gamePanel.repaint();
    }

    //Obtenemos la dirección en la que se quiere mover el jugador y hacemos el proceso movimiento
    public void move(int direction){
        //Definimos los cambios que se harían en las filas y columnas dependiendo de las direcciones posibles
        int[][] moves = { 
            {-1,0}, //UP
            {1,0}, //DOWN
            {0,-1}, //LEFT
            {0,1}, //RIGHT
        };
        //Verificamos si es posible moverse en esa dirección 
        if(isPossibleMove(moves[direction][0], moves[direction][1])){
            //De ser el caso 

            //Borramos el rastro del jugador de la posición actual
            this.level[this.current[0]][this.current[1]] = 0;

            //Cambiamos la posición actual a la nueva
            this.current[0] += moves[direction][0];
            this.current[1] += moves[direction][1];

            //Dejamos el rastro del jugador en la nueva posición
            this.level[this.current[0]][this.current[1]] = 2;

            //Verificamos si el jugador ya terminó el nivel
            if(isFinished()){
                //Indicamos que se acabó el nivel
                System.out.println("Nivel terminado");
                //Vamos al siguiente nivel
                this.levelIndex++;
                initNewLevel();
            }

        }
        //Mostramos los cambios
        gamePanel.repaint();
    }

    //Para que sea posible moverse en esa posición debe contener 0 o 3
    public boolean isPossibleMove(int row, int column){
        //Verificamos cual sería la siguiente posición aplicando los cambios y guardamos el valor que contenga
        int next = this.level[this.current[0] + row][this.current[1] + column];
        //¿Ese posición está libre?
        return next == 0 || next == 3;
    }

    //Si el rastro del jugador está en la posición destino el nivel termino 
    public boolean isFinished(){
        return this.level[this.destiny[0]][this.destiny[1]] == 2;
    }

    //Comparte la matriz del nivel actual
    public int[][] getCurrentLevel(){
        return this.level;
    }

}
