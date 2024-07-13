import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        // Найти количество несовершеннолетних (т.е. людей младше 18 лет)
        long count = persons.stream()
                .filter(age -> age.getAge() < 18)
                .count();
        System.out.println(count);

        // Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет)
        List<String> conscripts = persons.stream()
                .filter(sex -> sex.getSex() == Sex.MAN)
                .filter(age -> age.getAge() > 17 & age.getAge() < 28)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(conscripts);


        // Получить отсортированный по фамилии список потенциально работоспособных людей
        // с высшим образованием в выборке
        List<Person> workablePeople = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getSex() == Sex.MAN ? person.getAge() > 17 & person.getAge() < 66 :
                        person.getAge() > 17 & person.getAge() < 61)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(workablePeople);


    }
}