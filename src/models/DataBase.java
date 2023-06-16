package models;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Person> people = new ArrayList<>();
    private List<Anymal>anymals = new ArrayList<>();

    public DataBase(List<Person> people, List<Anymal> anymals) {
        this.people = people;
        this.anymals = anymals;
    }
    public DataBase(){

    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Anymal> getAnymals() {
        return anymals;
    }

    public void setAnymals(List<Anymal> anymals) {
        this.anymals = anymals;
    }
}
