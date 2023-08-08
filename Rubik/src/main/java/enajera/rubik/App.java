package enajera.rubik;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class App extends Application {

    private static final int CUBE_SIZE = 30;
    private static final int DIM = 3;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
//    private static final int DEEP = 500;
    private final SmartGroup root = new SmartGroup();
    PerspectiveCamera camera = new PerspectiveCamera(true);
    DoubleProperty angleX = new SimpleDoubleProperty(), angleY = new SimpleDoubleProperty();
    double anchorAngleX = 0, anchorAngleY = 0, anchorX, anchorY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);//You must to active the render scene
        primaryStage.setScene(scene);
        primaryStage.show();
        camera.setNearClip(5);//The first near object
        camera.setFarClip(3000);//The last far object
        camera.translateZProperty().set(-1000);//The camera moves to able to see the components
        scene.setCamera(camera);
        drawRubik();
//        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (e) -> eventStage(e));
        initMouseRotation(scene, root);

    }

//    public void eventStage(KeyEvent key) {
//        switch (key.getCode()) {
//            case W:
//                root.translateZProperty().set(root.getTranslateZ() + 20);
//                break;
//            case S:
//                root.translateZProperty().set(root.getTranslateZ() - 20);
//                break;
//            case Q:
//                root.rotateByX(-10);
//                break;
//            case E:
//                root.rotateByX(10);
//                break;
//            case D:
//                root.rotateByY(-10);
//                break;
//            case A:
//                root.rotateByY(10);
//                break;
//        }
//    }
    public void initMouseRotation(Scene scene, Group group) {
        Rotate xRotate = new Rotate(0, Rotate.X_AXIS);
        Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
        group.getTransforms().addAll(xRotate, yRotate);
        xRotate.angleProperty().bind(angleX);
        yRotate.angleProperty().bind(angleY);
        scene.setOnMousePressed((event) -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = angleX.get();
            anchorAngleY = angleY.get();
        });
        scene.setOnMouseDragged((event) -> {
            double deltaX = (anchorY - event.getSceneY());
            double deltaY = (anchorX - event.getSceneX());
            angleX.set(anchorAngleX - deltaX);
            angleY.set(anchorAngleY + deltaY);
        });
    }

    public void drawRubik() {
        Cube cube;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                for (int k = 0; k < DIM; k++) {
                    cube = new Cube(CUBE_SIZE);//You might to exchange this part for a matrix [DIM][DIM][DIM]
                    cube.setTranslateX((k + 1) * CUBE_SIZE);
                    cube.setTranslateY((j + 1) * CUBE_SIZE);
                    cube.setTranslateZ((i + 1) * CUBE_SIZE);
                    root.getChildren().add(cube);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
