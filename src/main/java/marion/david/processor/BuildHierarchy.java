package marion.david.processor;

import marion.david.data.Database;
import marion.david.exceptions.EmptyListException;
import marion.david.model.Person;
import java.util.ArrayList;
import java.util.List;

public class BuildHierarchy {
    private Database data = new Database();

    public List<Person> getCompanyList() throws EmptyListException {
        if(!data.getPersonList().isEmpty()) {
            return data.getPersonList();
        } else {
            throw new EmptyListException("No data available to build hierarchy");
        }

    }

    public void processHierachy() {
        try {
            for (Person person: getCompanyList()) {
                lookUpManagerName(person, person.getManagerId());
                lookUpDirectReports(person, person.getId());
            }
        } catch (EmptyListException error) {
            System.out.println(error.getMessage());
        }
    }

    public List<Person> lookUpDirectReports(Person person, int getId) {
        List<Person> personList = new ArrayList<>();
        try {
            getCompanyList().forEach(personInList -> {
                if(personInList.getManagerId() == getId) {
                    personList.add(personInList);
                    person.setDirectReports(personList);
                }
            });
        } catch (EmptyListException error) {
            System.out.println(error.getMessage());
        }

        return personList;
    }

    public Person lookUpManagerName(Person person, int managerId) {
        try {
            getCompanyList().forEach(personInList -> {
                if(personInList.getId() == managerId) {
                    person.setManagersName(personInList.getName());
                }
            });
        } catch (EmptyListException error) {
            System.out.println(error.getMessage());
        }

        return person;
    }

    public List<Person> getHierachy() {
        return data.getPersonList();
    }
}
