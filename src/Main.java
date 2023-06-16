import models.Anymal;
import models.DataBase;
import models.Gender;
import models.Person;
import service.AnymalServiceIMPL;
import service.PersonServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(
                List.of(new Person(1L,"Martina",23,Gender.FEMALE),
                        new Person(2L,"Nurik",67,Gender.MALE),
                        new Person(3L,"Daniel",67,Gender.MALE),
                        new Person(4L,"Nicol",67,Gender.FEMALE)));



        List<Anymal>anymals = new ArrayList<>(
                List.of(new Anymal(6L,"Cat",2,Gender.MALE),
                        new Anymal(4L,"Dog",3,Gender.FEMALE),
                        new Anymal(7L,"Cow",7,Gender.FEMALE),
                        new Anymal(9L,"Lion",5,Gender.MALE),
                        new Anymal(2L,"Mouse",2,Gender.MALE)));

        DataBase dataBase = new DataBase();
        PersonServiceIMPL personServiceIMPL = new PersonServiceIMPL(dataBase);
        AnymalServiceIMPL anymalServiceIMPL = new AnymalServiceIMPL(dataBase);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println();
            System.out.println("1. Add people:                      7. Add anymals:");
            System.out.println("2. Get by id:                       8. Get by id:");
            System.out.println("3. Get all:                         9. Get all:");
            System.out.println("4. Sort by name ->1.A-Z ->2.Z-A;    10. Sort by name ->1.A-Z ->2.Z-A;  :");
            System.out.println("5. Sort male ->1.Male->2.Female:    11. Sort male: ->1.Male->2.Female: ");
            System.out.println("6. Clear people:                    12. Clear anymals:");
            System.out.println();
            int number =scanner.nextInt();

        switch (number){
            case 1-> {System.out.println("Add people and anymals:");
                      System.out.println(personServiceIMPL.add(people));}
            case 2-> {System.out.println("Get by id:");
                      System.out.println(personServiceIMPL.getById(23L));}
            case 3-> {System.out.println("Get all:");
                      System.out.println(personServiceIMPL.getAll());}
            case 4-> {System.out.println("Sort by Name:");
                      System.out.println(personServiceIMPL.sortByName());}
            case 5-> {System.out.println("Sort male");
                      System.out.println(personServiceIMPL.filterByGender());}
            case 6-> {System.out.println("Clear people:");
                      System.out.println(personServiceIMPL.clear());
                     }

                case 7-> {System.out.println("Add people and anymals:");
                          System.out.println(anymalServiceIMPL.add(anymals));}
                case 8-> {System.out.println("Get by id:");
                          System.out.println(anymalServiceIMPL.getById(9L));}
                case 9-> {System.out.println("Get all:");
                          System.out.println(anymalServiceIMPL.getAll());}
                case 10-> {System.out.println("Sort by Name:");
                           System.out.println(anymalServiceIMPL.filterByGender());}
                case 11-> {System.out.println("Sort male");
                           System.out.println(anymalServiceIMPL.filterByGender());}
                case 12-> {System.out.println(anymalServiceIMPL.clear());}
            }



        }}
    }