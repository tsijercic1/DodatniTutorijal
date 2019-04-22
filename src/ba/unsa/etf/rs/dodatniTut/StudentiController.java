package ba.unsa.etf.rs.dodatniTut;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        model.dodajStudenta(new Student());
        listaStudenti.getSelectionModel().selectLast();
    }

    public void obrisiAction() {
        model.izbrisiStudenta();
        listaStudenti.getSelectionModel().clearSelection();
        listaStudenti.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaStudenti.setItems(model.getStudenti());
        listaStudenti.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                model.setTrenutniStudent(newValue);
                listaStudenti.refresh();
            }
        });

        model.trenutniStudentProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                if (oldValue != null) {
                    unbind(oldValue);
                }
                if (newValue == null) {
                    imeField.setText("");
                    prezimeField.setText("");
                    indexField.setText("");
                    datePicker.getEditor().setText("");
                }else{
                    bind(newValue);
                }
            }
        });

    }

    private void bind(Student value) {
        imeField.textProperty()
                .bindBidirectional(value.imeProperty());
        prezimeField.textProperty()
                .bindBidirectional(value.prezimeProperty());
        indexField.textProperty()
                .bindBidirectional(value.indexProperty());
        datePicker.valueProperty()
                .bindBidirectional(value.datumRodjenjaProperty());
    }

    private void unbind(Student value) {
        imeField.textProperty()
                .unbindBidirectional(value.imeProperty());
        prezimeField.textProperty()
                .unbindBidirectional(value.prezimeProperty());
        indexField.textProperty()
                .unbindBidirectional(value.indexProperty());
        datePicker.valueProperty()
                .unbindBidirectional(value.datumRodjenjaProperty());
    }

}
