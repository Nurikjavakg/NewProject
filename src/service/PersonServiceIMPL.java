package service;

import models.DataBase;
import models.Gender;
import models.MyException;
import models.Person;
import service.GenericService;

import java.util.*;

public class PersonServiceIMPL implements GenericService <Person>{
    private final DataBase dataBase;

    public PersonServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(List<Person> t) {
        dataBase.getPeople().addAll(t);

        return "Person is successfully added";
    }

    @Override
    public Person getById(Long id) {
        for (Person p: dataBase.getPeople()) {
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return dataBase.getPeople();

    }

    @Override
    public List<Person> sortByName() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 1) {
            dataBase.getPeople().sort(personComparator);
            System.out.println(dataBase.getPeople());

        } else if (number == 2) {
            dataBase.getPeople().sort(personComparator1);
            System.out.println(dataBase.getPeople());
        }return null;
    }
    @Override
    public List<Person> filterByGender() {
        int number = new Scanner(System.in).nextInt();
        for (Person p:dataBase.getPeople()) {
            if (number == 1 && p.getGender().equals(Gender.FEMALE)) {
                    System.out.println(p);
                }else if(number==2 && p.getGender().equals(Gender.MALE)){
                System.out.println(p);
            }

            }return null;

    }

    @Override
    public List<Person> clear() {
        dataBase.getPeople().clear();
        return null;
    }
    public static Comparator<Person>personComparator=new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator<Person>personComparator1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
}


