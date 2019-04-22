package ba.unsa.etf.rs.dodatniTut;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StudentiModel model = new StudentiModel();
        StudentiController controller = new StudentiController(model);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setController(controller);

        Parent root = loader.load();
        primaryStage.setTitle("Studenti");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.toFront();
    }


    public static void main(String[] args) {
        Student a = new Student("meho",
                "mehic", "18000", LocalDate.now());
        System.out.println(a);
        launch(args);
    }
}
