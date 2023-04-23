








//Bryam Sanchez
//Kendrick Belizaire

import java.util.LinkedList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Snake implements Drawable {

    private LinkedList<Rectangle> segments;
    private Direction direction;

    public Snake(int startX, int startY, Direction startDirection) {
        segments = new LinkedList<>();
        segments.add(new Rectangle(startX, startY, 10, 10));
        direction = startDirection;
    }
    //Moves the snake in the current direction and updates its position.
    public void update() {
        int dx = 0;
        int dy = 0;

        switch (direction) {
            case UP:
                dy = -10;
                break;
            case DOWN:
                dy = 10;
                break;
            case LEFT:
                dx = -10;
                break;
            case RIGHT:
                dx = 10;
                break;
            case NONE:
                break;
            default:
                break;
        }

        //Updates the position of each segment except the head
        for (int i = segments.size() - 1; i > 0; i--) {
            Rectangle segment = segments.get(i);
            Rectangle previousSegment = segments.get(i - 1);
            segment.setX(previousSegment.getX());
            segment.setY(previousSegment.getY());
        }

        //Moves the head segment in the current direction
        Rectangle head = segments.getFirst();
        head.setX(head.getX() + dx);
        head.setY(head.getY() + dy);
    }

    public void addSegment() {
        Rectangle lastSegment = segments.getLast();
        Rectangle newSegment = new Rectangle(lastSegment.getX(), lastSegment.getY(), 10, 10);
        newSegment.setFill(Color.GREEN);
        segments.add(newSegment);
    }

    //checks if the snake intersects with the rectangle.
    public boolean intersects(Rectangle other) {
        for (Rectangle segment : segments) {
            if (segment.getBoundsInParent().intersects(other.getBoundsInParent())) {
                return true;
            }
        }
    
        return false;
    }
    //Checks if the snake intersects with itself.
    public boolean intersectsItself() {
        Rectangle head = segments.get(0);
        for (int i = 1; i < segments.size(); i++) {
            Rectangle segment = segments.get(i);
            if (head.intersects(segment.getBoundsInLocal())) {
                return true;
            }
        }
        return false;
    }
    
    public LinkedList<Rectangle> getSegments() {
        return segments;
    }
    
    public int getLength() {
        return segments.size();
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    @Override
    public void draw() {
        for (Rectangle segment : segments) {
            segment.setFill(Color.WHITE);
            segment.setStroke(Color.GREEN);
        }
    }
    }
