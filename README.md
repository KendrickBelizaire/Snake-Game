


//Bryam Sanchez
//Kendrick Belizaire

import javafx.animation.AnimationTimer;

//Updates and renders the game continuously.
public class GameLoop extends AnimationTimer {

private Game game;

public GameLoop(Game game) {
    this.game = game;
}

@Override
public void handle(long now) {
    game.update();
    game.draw();
}

}
