//Bryam Sanchez
//Kendrick Belizaire

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler implements EventHandler<KeyEvent> {

private Snake snake;

//Gets the input from the user to move the snake.
public InputHandler(Snake snake) {
    this.snake = snake;
}
//Checks which key is pressed.
@Override
public void handle(KeyEvent event) {
    if (event.getCode() == KeyCode.UP) {
        snake.setDirection(Direction.UP);
    } else if (event.getCode() == KeyCode.DOWN) {
        snake.setDirection(Direction.DOWN);
    } else if (event.getCode() == KeyCode.LEFT) {
        snake.setDirection(Direction.LEFT);
    } else if (event.getCode() == KeyCode.RIGHT) {
        snake.setDirection(Direction.RIGHT);
    }
}
}



