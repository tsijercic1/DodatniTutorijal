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
        unbind();
        model.dodajStudenta(new Student());
        model.postaviTrenutnog(model.getStudenti().size()-1);
        bind();
    }

    public void obrisiAction() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaStudenti.setItems(model.getStudenti());
        listaStudenti.getSelectionModel()
                .selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        unbind();
                        model.postaviTrenutnog(newValue.intValue());
                        bind();
                    }
                });

    }

    private void unbind() {
        if(model.getTrenutniStudent()!=null) {
            imeField.textProperty()
                    .unbindBidirectional(model.getTrenutniStudent().imeProperty());
            prezimeField.textProperty()
                    .unbindBidirectional(model.getTrenutniStudent().prezimeProperty());
            indexField.textProperty()
                    .unbindBidirectional(model.getTrenutniStudent().indexProperty());
            datePicker.valueProperty()
                    .unbindBidirectional(model.getTrenutniStudent().datumRodjenjaProperty());
        }
    }

    private void bind() {
        imeField.textProperty()
                .bindBidirectional(model.getTrenutniStudent().imeProperty());
        prezimeField.textProperty()
                .bindBidirectional(model.getTrenutniStudent().prezimeProperty());
        indexField.textProperty()
                .bindBidirectional(model.getTrenutniStudent().indexProperty());
        datePicker.valueProperty()
                .bindBidirectional(model.getTrenutniStudent().datumRodjenjaProperty());
    }
}
