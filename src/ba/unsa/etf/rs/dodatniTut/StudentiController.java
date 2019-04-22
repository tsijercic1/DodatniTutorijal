package ba.unsa.etf.rs.dodatniTut;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class StudentiController implements Initializable {

    private StudentiModel model;

    public TextField imeField;
    public TextField prezimeField;
    public TextField indexField;
    public DatePicker datePicker;
    public ListView<Student> listaStudenti;

    public StudentiController(StudentiModel model) {
        this.model=model;
    }

    public void dodajAction() {

    }

    public void obrisiAction() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaStudenti.setItems(model.getStudenti());

    }
}
