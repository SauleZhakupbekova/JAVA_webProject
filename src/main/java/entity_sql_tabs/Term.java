package entity_sql_tabs;

import java.util.ArrayList;
import java.util.Objects;

public class Term {
    
    private int id;
    private String term;
    private String duration;
    private ArrayList<Discipline> discipline = new ArrayList<>();

    public Term() {
    }

    public Term(int id, String term, String duration, ArrayList<Discipline> discipline) {
        this.id = id;
        this.term = term;
        this.duration = duration;
        this.discipline = discipline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<Discipline> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(ArrayList<Discipline> discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Term term1 = (Term) o;
        return id == term1.id && Objects.equals(term, term1.term) && Objects.equals(duration, term1.duration) && Objects.equals(discipline, term1.discipline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, duration, discipline);
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", discipline=" + discipline +
                '}';
    }
}
