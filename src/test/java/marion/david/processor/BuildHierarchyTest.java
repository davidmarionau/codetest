package marion.david.processor;

import marion.david.data.Database;
import marion.david.exceptions.EmptyListException;
import marion.david.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class BuildHierarchyTest {
    private BuildHierarchy buildHierarchy;

    @Before
    public void setup() {
        buildHierarchy = new BuildHierarchy();
        buildHierarchy.processHierachy();
    }

    @Test
    public void testCompanyListSize() throws EmptyListException {
        Database database = new Database();
        List<Person> result = buildHierarchy.getCompanyList();
        Assert.assertEquals(database.getPersonList().size(), result.size());
    }

    @Test(expected = EmptyListException.class)
    public void testExceptionOnNullData() throws EmptyListException {
        List<Person> companyList = buildHierarchy.getCompanyList();
        companyList.clear();
        buildHierarchy.getCompanyList();
    }

    @Test
    public void testLookUpDirectReportsForAlan() {
        Person testEntity = new Person("Alan", 100, 150);
        List<Person> result = buildHierarchy.lookUpDirectReports(testEntity, testEntity.getId());
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testLookUpDirectReportsForSteve() {
        Person testEntity = new Person("Steve", 400, 150);
        List<Person> result = buildHierarchy.lookUpDirectReports(testEntity, testEntity.getId());
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testManagerNameLookUpForAlan() {
        Person testEntity = new Person("Alan", 100, 150);
        Person result = buildHierarchy.lookUpManagerName(testEntity, testEntity.getManagerId());
        Assert.assertEquals("Jamie", result.getManagersName());
    }

    @Test
    public void testManagerNameLookUpForJamie() {
        Person testEntity = new Person("Jamie", 150);
        Person result = buildHierarchy.lookUpManagerName(testEntity, testEntity.getManagerId());
        Assert.assertNull(result.getManagersName());
    }
}
