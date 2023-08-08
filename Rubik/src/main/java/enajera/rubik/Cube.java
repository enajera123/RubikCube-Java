package enajera.rubik;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

/**
 *
 * @author estebannajera
 */
public class Cube extends Group {

//    private Point1.5D point;
    private int length;
    private Rectangle up;
    private Rectangle down;
    private Rectangle right;
    private Rectangle left;
    private Rectangle back;
    private Rectangle front;

//    public Cube(float x, float y, float z, int square_size, Color color) {
//
//        point = new Point1.5D(x, y, z);
//        length = square_size;
////        translate(point.getX(), point.getY(), point.getZ());
//
//    }

    public Cube(int squareSize) {
        length = squareSize;
        drawCube();
        getChildren().addAll(back,front,right,left,up,down);
//getChildren().addAll(back,front,left);
    }

    public void translate(double x, double y, double z) {
        setTranslateX(x);
        setTranslateY(y);
        setTranslateZ(z);

    }

    public void drawCube() {
        up = new Rectangle(length, length);
        up.setStroke(Color.BLACK);
        up.setStrokeWidth(1.5);
        down = new Rectangle(length, length);
        down.setStroke(Color.BLACK);
        down.setStrokeWidth(1.5);
        front = new Rectangle(length, length);
        front.setStroke(Color.BLACK);
        front.setStrokeWidth(1.5);
        back = new Rectangle(length, length);
        back.setStroke(Color.BLACK);
        back.setStrokeWidth(1.5);
        left = new Rectangle(length, length);
        left.setStroke(Color.BLACK);
        left.setStrokeWidth(1.5);
        right = new Rectangle(length, length);
        right.setStroke(Color.BLACK);
        right.setStrokeWidth(1.5);
        //Front
        
        front.setFill(Color.WHITE);
        //Back face
        back.setTranslateZ(length);
        back.setFill(Color.YELLOW);
        //Up Face
        up.setRotationAxis(Rotate.X_AXIS);
        up.setRotate(90);
        up.setTranslateY(-(length/2));
        up.setTranslateZ((length/2));
        up.setFill(Color.ORANGE);
        //Down Face
        down.setRotationAxis(Rotate.X_AXIS);
        down.setRotate(90);
        down.setTranslateY((length/2));
        down.setTranslateZ((length/2));
        down.setFill(Color.RED);
        //Left
        right.setRotationAxis(Rotate.Y_AXIS);
        right.setRotate(90);
        right.setTranslateX((length/2));
        right.setTranslateZ((length/2));
        right.setFill(Color.BLUE);
        //Right
        left.setRotationAxis(Rotate.Y_AXIS);
        left.setRotate(90);
        left.setTranslateX(-(length/2));
        left.setTranslateZ((length/2));
        left.setFill(Color.GREEN);

    }

}
