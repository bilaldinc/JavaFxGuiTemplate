package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load root pane from fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Controller controller = new Controller();
        loader.setController(controller);
        Parent root = loader.load();

        // create scene
        Scene scene = new Scene(root, 600, 400, Color.TRANSPARENT);

        // add custom minimize and exit buttons
        controller.exit.getChildren().add(new LittleCross());
        controller.minimize.getChildren().add(new LittleLine());

        // screen drag variables & actions
        final WrappedDouble X = new WrappedDouble();
        final WrappedDouble Y = new WrappedDouble();
        scene.setOnMousePressed(e ->{X.x=e.getSceneX();Y.y=e.getSceneY();});
        scene.setOnMouseDragged(e ->{scene.getWindow().setX(e.getScreenX()-X.x); scene.getWindow().setY(e.getScreenY()-Y.y);});

        primaryStage.setTitle("Hello World");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private class WrappedDouble{
        double x, y;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
