package marion.david;

import marion.david.model.Person;
import marion.david.processor.BuildHierarchy;
import java.util.List;


public class App {
    public static void main(String[] args) {
        BuildHierarchy buildHierachy = new BuildHierarchy();
        buildHierachy.processHierachy();
        List<Person> hierachy = buildHierachy.getHierachy();
        hierachy.forEach(entity -> {
            System.out.println("Person: " + entity.getName());
            System.out.println("Managers Name: " + entity.getManagersName());
            System.out.println("Direct Reports: " + entity.getDirectReports());
            System.out.println("- - - - - - - - - -");
        });
    }
}

