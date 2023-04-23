//Bryam Sanchez
//Kendrick Belizaire

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board extends Rectangle implements Drawable {

//Constructs the Board.
public Board(int width, int height, Group root) {
    super(width, height);
    setFill(Color.BLACK);
    setStroke(Color.WHITE);
    root.getChildren().add(this);
}

@Override
public void draw() {

}
}


