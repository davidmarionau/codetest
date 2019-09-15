package marion.david.data;

import marion.david.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private Person alan = new Person("Alan", 100, 150);
    private Person martin = new Person("Martin", 220, 100);
    private Person jamie = new Person("Jamie", 150);
    private Person alex = new Person("Alex", 275, 100);
    private Person steve = new Person("Steve", 400, 150);
    private Person david = new Person("David", 190, 400);

    private List<Person> personList = new ArrayList<>();

    public Database() {
        personList.add(alan);
        personList.add(martin);
        personList.add(jamie);
        personList.add(alex);
        personList.add(steve);
        personList.add(david);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void removePersonById(int id) {
        List<Person> tempPersonList = new ArrayList<>();
        tempPersonList.addAll(personList);
        tempPersonList.forEach(person -> {
            if(person.getId() == id) {
                personList.remove(person);
            }
        });
    }
}
