package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Transitions {

    private InnerShadow ButtonEnterEffect;
    private InnerShadow ButtonDefaultEffect;

    public Transitions() {

    }

    public void ButtonEnterEffect(Event event){
        Node node = (Node)event.getSource();
        node.setEffect(ButtonEnterEffect);
    }

    public void ButtonLeaveEffect(Event event){
        Node node = (Node)event.getSource();
        node.setEffect(ButtonDefaultEffect);
    }

    public void TransiteWithEffect(Pane from, Pane to, long speed){
        FadeTransition ft2 = new FadeTransition(Duration.millis(speed), to);
        ft2.setFromValue(0);
        ft2.setToValue(1);
        ft2.setCycleCount(1);

        FadeTransition ft1 = new FadeTransition(Duration.millis(speed), from);
        ft1.setFromValue(1.0);
        ft1.setToValue(0);
        ft1.setCycleCount(1);
        ft1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                from.setVisible(false);
                from.setOpacity(1.0);
                to.setOpacity(0);
                to.setVisible(true);
                ft2.play();
            }
        });
        ft1.play();
    }

}
