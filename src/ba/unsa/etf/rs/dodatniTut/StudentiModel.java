package ba.unsa.etf.rs.dodatniTut;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class StudentiModel {
    private ObservableList<Student> studenti = FXCollections.observableArrayList();
    private SimpleObjectProperty<Student> trenutniStudent = new SimpleObjectProperty<>();


    public StudentiModel() {
        napuni();
    }

    private void napuni() {
        studenti.add(new Student("Meho","Mehić",18252,
                LocalDate.now()));
        studenti.add(new Student("Šemso","Šemsić",18253,
                LocalDate.now().minusMonths(3)));
        trenutniStudent.set(studenti.get(0));
    }

    void dodajStudenta(Student student) {
        studenti.add(student);
        trenutniStudent.set(studenti.get(studenti.size()-1));
    }

    void izbrisiStudenta(){
        int index = studenti.indexOf(trenutniStudent.get());
        studenti.remove(index);
        if(studenti.size()!=0){
            trenutniStudent.set(studenti.get(0));}
        else{
            trenutniStudent.set(null);
        }
    }

    void postaviTrenutnog(int i){
        trenutniStudent.set(studenti.get(i));
    }

    public ObservableList<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(ObservableList<Student> studenti) {
        this.studenti = studenti;
    }

    public Student getTrenutniStudent() {
        return trenutniStudent.get();
    }

    public SimpleObjectProperty<Student> trenutniStudentProperty() {
        return trenutniStudent;
    }

    public void setTrenutniStudent(Student trenutniStudent) {
        this.trenutniStudent.set(trenutniStudent);
    }
}
