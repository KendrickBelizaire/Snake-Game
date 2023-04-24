//Bryam Sanchez
//Kendrick Belizaire

public class CollisionDetector {

    //Checks for collisions between the snake, food, and the board.
    public void checkCollision(Snake snake, Food food, Level level, Score score) {
        if (snake.intersects(food)) {
            snake.addSegment();
            food.generateNewLocation();
            score.increaseScore(level.getPointsPerFood());
        }
    
        if (snake.intersectsItself()) {
            snake.setDirection(Direction.NONE);
        }
    }
    }
    
    