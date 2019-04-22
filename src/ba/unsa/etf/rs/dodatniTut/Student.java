package ba.unsa.etf.rs.dodatniTut;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

    private SimpleStringProperty ime=new SimpleStringProperty(""),prezime=new SimpleStringProperty("");
    private SimpleStringProperty index= new SimpleStringProperty("");
    private SimpleObjectProperty<LocalDate> datumRodjenja =new SimpleObjectProperty<>();

    public Student() { }

    public Student(String ime, String prezime,String index,LocalDate datumRodjenja) {
        this.ime.set(ime);
        this.prezime.set(prezime);
        this.index.set(index);
        this.datumRodjenja.set(datumRodjenja);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja.get();
    }

    public SimpleObjectProperty<LocalDate> datumRodjenjaProperty() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja.set(datumRodjenja);
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime();
    }
}
