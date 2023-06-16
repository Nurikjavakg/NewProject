package service;

import models.Anymal;
import models.DataBase;
import models.Gender;
import models.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnymalServiceIMPL implements GenericService <Anymal> {
    private DataBase dataBase;

    public AnymalServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(List<Anymal> t) {
        dataBase.getAnymals().addAll(t);
        return null;
    }

    @Override
    public Anymal getById(Long id) {
        for (Anymal a:dataBase.getAnymals()) {
            if(a.getId().equals(id)){
                System.out.println(a);
            }

        }
        return null;
    }

    @Override
    public List<Anymal> getAll() {

        return dataBase.getAnymals();
    }

    @Override
    public List<Anymal> sortByName() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 3) {
            dataBase.getAnymals().sort(personComparator);
            System.out.println(dataBase.getAnymals());

        } else if (number == 4) {
            dataBase.getAnymals().sort(personComparator1);
            System.out.println(dataBase.getAnymals());
        }return null;

    }

    @Override
    public List<Anymal> filterByGender() {
        int number = new Scanner(System.in).nextInt();
        for (Anymal a:dataBase.getAnymals()) {
            if (number == 1 && a.getGender().equals(Gender.FEMALE)) {
                System.out.println(a);
            }else if(number==2 && a.getGender().equals(Gender.MALE)){
                System.out.println(a);
            }

        }return null;

    }

    @Override
    public List<Anymal> clear() {
        dataBase.getPeople().clear();
        return null;
    }
    public static Comparator<Anymal> personComparator=new Comparator<Anymal>() {
        @Override
        public int compare(Anymal o1, Anymal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator<Anymal>personComparator1 = new Comparator<Anymal>() {
        @Override
        public int compare(Anymal o1, Anymal o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
}
