package eu.kunas.pm4j.javafxsample.utilities;

import eu.kunas.pm4j.javafxsample.PmJavaFxApplication;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * This is an FXML Page Loader
 *
 * @author Ramazan
 */
public class PageLoader {

    public static Object loadContent(final String fxml) {
        try {
            final URL url = PmJavaFxApplication.class.getResource(fxml);
            final Object page = FXMLLoader.load(url, null, new JavaFXBuilderFactory());

            return page;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Object loadController(final String url) {
        final InputStream fxmlStream = null;
        try {
            final FXMLLoader loader = new FXMLLoader();

            try {
                loader.load(getClass().getResourceAsStream(url));
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return loader.getController();
        } finally {
            if (fxmlStream != null) {
                try {
                    fxmlStream.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
