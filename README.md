//Bryam Sanchez
//Kendrick Belizaire

//This class determines the game speed, the points per food, and the maximum level.
public class Level implements Updatable {
    
    private int currentLevel;
    private int maxLevel;
    private int scoreThreshold;
    private int pointsPerFood;
    private int gameSpeed;
    
    public Level() {
        currentLevel = 1;
        maxLevel = 3;
        scoreThreshold = 10;
        pointsPerFood = 1;
        gameSpeed = 60;
    }
    
    public int getGameSpeed() {
        return gameSpeed;
    }
    
    public int getPointsPerFood() {
        return pointsPerFood;
    }
    
    public int getMaxLevel() {
        return maxLevel;
    }
    
    public void update() {

        //Increases the game speed and score threshold for each level.
        if (scoreThreshold <= Score.getScore() && currentLevel < maxLevel) {
            currentLevel++;
            scoreThreshold *= 2;
            pointsPerFood *= 2;
            gameSpeed -= 10;
        }
    }
    public void updateLevel(int newLevel) {
        currentLevel = newLevel;
        
    }
    
}

