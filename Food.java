//Bryam Sanchez
//Kendrick Belizaire

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food extends Rectangle implements Drawable {

private static final int FOOD_SIZE = 10;

public Food() {
    super(FOOD_SIZE, FOOD_SIZE, Color.RED);
    generateNewLocation();
}

public void generateNewLocation() {

    //Creates a new random object
    Random random = new Random();

    //gets a random x value
    int x = random.nextInt(450) / 10 * 10;

    //gets a random y value
    int y = random.nextInt(450) / 10 * 10;

    //sets the food's locations to the randomly generated values.
    setX(x);
    setY(y);
}

@Override
public void draw() {
    
}
}