package ba.unsa.etf.rs.dodatniTut;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String ime,prezime;
    private Integer index;
    private LocalDate datumRođenja;

    public Student() {
    }

    public Student(String ime, String prezime,Integer index,LocalDate datumRođenja) {
        this.ime=ime;
        this.prezime=prezime;
        this.index=index;
        this.datumRođenja = datumRođenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public LocalDate getDatumRođenja() {
        return datumRođenja;
    }

    public void setDatumRođenja(LocalDate datumRođenja) {
        this.datumRođenja = datumRođenja;
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime() + " (" + getIndex() + ")" + " - " +
                getDatumRođenja().format(DateTimeFormatter.ofPattern("dd. M. yyyy"));
    }
}
