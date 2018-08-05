package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;
/*this class creates pane that draws little line
 *this is for minimize button
 **/

public class LittleLine extends Pane {
    public LittleLine(){
        setMinSize(25,25);
        setMaxSize(25,25);
        Line line1 = new Line(5,15,20,15);
        line1.setStrokeWidth(2);
        line1.setStroke(Color.BLACK);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        getChildren().add(line1);

        //to make clear to user that area is button, change colors when mouse comes upon it
        setOnMouseEntered(e -> {line1.setStroke(Color.GRAY);});
        setOnMouseExited(e -> {line1.setStroke(Color.BLACK);});

        setOnMouseClicked(e -> ((Stage)(getScene().getWindow())).setIconified(true));
    }
}
