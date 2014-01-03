package eu.kunas.pm4j.javafxsample;

import eu.kunas.pm4j.javafxsample.controller.CustomerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * JavaFX and PM4J Example
 * <p/>
 * Created by ramazan
 */
public class PmJavaFxApplication extends Application {

    private Stage primaryStage;

    @SuppressWarnings("resource")
    @Override
    public void start(final Stage p) throws Exception {
        this.primaryStage = p;
        CustomerController controller = (CustomerController) loadController("/eu/kunas/pm4j/javafxsample/controller/CustomerController.fxml");

        Scene scene = new Scene((Parent) controller.getView(), 600, 400);
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        scene.getStylesheets().add("/style.css");
        this.primaryStage.setTitle("pm4j-javafx-sample");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch(args);
    }

    protected Object loadController(final String url) throws IOException {
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getResourceAsStream(url);
            final FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return loader.getController();
        } finally {
            if (fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }
}
