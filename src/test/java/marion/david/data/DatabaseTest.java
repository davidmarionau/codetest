package marion.david.data;

import marion.david.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DatabaseTest {
    private Database database;

    @Before
    public void setup() {
        database = new Database();
    }

    @Test
    public void getDatabaseSize() {
        List<Person> personList = database.getPersonList();
        Assert.assertEquals(6, personList.size());
    }

    @Test
    public void addPersonTest() {
        Person john = new Person("John", 425, 400);
        database.addPerson(john);
        List<Person> personList = database.getPersonList();
        Assert.assertEquals(7, personList.size());
    }

    @Test
    public void removePersonTest() {
        database.removePersonById(190);
        List<Person> personList = database.getPersonList();
        Assert.assertEquals(5, personList.size());
    }

}
