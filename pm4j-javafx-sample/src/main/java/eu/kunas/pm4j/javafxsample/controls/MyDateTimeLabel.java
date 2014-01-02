package eu.kunas.pm4j.javafxsample.controls;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

import org.joda.time.LocalDateTime;

public class MyDateTimeLabel extends Label {

    private Timeline clockTimeLine = null;

    public MyDateTimeLabel() {
        super();
        getStyleClass().add("timelabel");
        this.clockTimeLine = new Timeline();
        this.clockTimeLine.setCycleCount(Timeline.INDEFINITE);
        this.clockTimeLine.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler() {

            @Override
            public void handle(final Event arg0) {
                final LocalDateTime localDate = LocalDateTime.now();
                setText(localDate.toString("dd.MM.yyyy HH:mm:ss"));
            }

        }));
        this.clockTimeLine.playFromStart();

    }
}
