//Bryam Sanchez
//Kendrick Belizaire

//Keeps track of the player's score. 
public class Score implements Updatable {

    private static final int POINTS_PER_FOOD = 1;

    private static int score;
    
    public Score() {
        score = 0;
    }
    
    public void increaseScore(int points) {
        score += POINTS_PER_FOOD;
    }
    
    public static int getScore() {
        return score;
    }
    
    @Override
    public void update() {
        
    }
    }
    
    