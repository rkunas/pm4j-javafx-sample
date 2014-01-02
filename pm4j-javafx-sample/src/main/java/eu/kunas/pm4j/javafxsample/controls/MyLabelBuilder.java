package eu.kunas.pm4j.javafxsample.controls;

import eu.kunas.pm4j.javafxsample.utilities.PageLoader;

/**
 * Created by ramazan on 17.11.13.
 */
public class MyLabelBuilder {

    MyLabel control = null;

    public MyLabelBuilder(){
        this.control = (MyLabel) new PageLoader().loadController("/eu/kunas/pm4j/javafxsample/controls/MyLabel.fxml");
    }

    public MyLabel buidl(){
        return control;
    }
}
