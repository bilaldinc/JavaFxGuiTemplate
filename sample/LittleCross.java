package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

/*this class creates pane that draws little cross
 *this is for close button
 **/
public class LittleCross extends Pane {
    public LittleCross(){
        setMinSize(25,25);
        setMaxSize(25,25);
        Line line1 = new Line(5,5,20,20);
        Line line2 = new Line(20,5,5,20);
        line1.setStrokeWidth(2);
        line2.setStrokeWidth(2);
        line1.setStroke(Color.BLACK);
        line2.setStroke(Color.BLACK);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        getChildren().addAll(line1,line2);

        //to make clear to user that area is button, change colors when mouse comes upon it
        setOnMouseEntered(e -> {line1.setStroke(Color.GRAY);line2.setStroke(Color.GRAY);});
        setOnMouseExited(e -> {line1.setStroke(Color.BLACK);line2.setStroke(Color.BLACK);});

        setOnMouseClicked(e ->{getScene().getWindow().hide(); System.exit(0);});
    }
}
