//Bryam Sanchez
//Kendrick Belizaire

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;

public class Game extends Application implements Updatable {

    // Constants for the size of the game board and game speed.
    private static final int BOARD_WIDTH = 600;
    private static final int BOARD_HEIGHT = 600;
    private static final int GAME_SPEED = 6;

    private Board board;
    private Snake snake;
    private Food food;
    private CollisionDetector collisionDetector;
    private Score score;
    private Level level;

    // Boolean flag to indicate if the game is running.
    private boolean gameRunning;

    // Animation timer to update the game
    private AnimationTimer gameLoop;

    //The start method initializes the game window, game objects, and game loop animation timer.
    @Override
    public void start(Stage primaryStage) 
    {
        // Create the root node and scene for the game window.
        Group root = new Group();
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT, Color.BLACK);

        // Create the game objects
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT, root);
        snake = new Snake(BOARD_WIDTH / 2, BOARD_HEIGHT / 2, Direction.RIGHT);
        food = new Food();
        collisionDetector = new CollisionDetector();
        score = new Score();
        level = new Level();

        // Set the game to be running.
        gameRunning = true;

        // Create the game loop animation timer.
        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 1000000000 / GAME_SPEED) {
                    update();
                    lastUpdate = now;
                }
            }
        };

        InputHandler inputHandler = new InputHandler(snake);
        scene.setOnKeyPressed(inputHandler);

        // Add the game objects to the scene.
        root.getChildren().add(board);
    if (!root.getChildren().contains(food)) {
    root.getChildren().add(food);
    }
    for (Node segment : snake.getSegments()) {
    if (!root.getChildren().contains(segment)) {
        root.getChildren().add(segment);
    }
    }

        // Set the scene and display the game window.
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the game loop animation timer.
        gameLoop.start();
    }

    public void draw() {
        
    }
    //The update method updates the game state by updating the snake, checking for collisions,updating the score, and updating the level.
    @Override
    public void update() {
        if (gameRunning) {
            snake.update();
            collisionDetector.checkCollision(snake, food, level, score);
            score.increaseScore(snake.getLength());
            level.updateLevel(Score.getScore());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}

