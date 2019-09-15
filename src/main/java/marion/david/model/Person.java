package marion.david.model;

import java.util.List;

public class Person {
    private String name;
    private int id;
    private int managerId;
    private String managersName;
    private List<Person> directReports;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name, int id, int managerId) {
        this.name = name;
        this.id = id;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }


    public String getManagersName() {
        return managersName;
    }

    public void setManagersName(String managersName) {
        this.managersName = managersName;
    }

    public List<Person> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Person> directReports) {
        this.directReports = directReports;
    }

    @Override
    public String toString() {
        return name;
    }
}
