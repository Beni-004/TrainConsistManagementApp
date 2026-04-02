import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " -> " + capacity;
    }
}

<<<<<<<< HEAD:src/UseCase8TrainConsistMngmt.java
public class UseCase8TrainConsistMngmt {
========
public class UseCase9TrainConsistMngmt {
>>>>>>>> feature/UC9:src/UseCase9TrainConsistMngmt.java
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

<<<<<<<< HEAD:src/UseCase8TrainConsistMngmt.java
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        System.out.println("Filtered Bogies: " + filtered);
        System.out.println("Original Bogies: " + bogies);
========
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("Grouped Bogies: " + grouped);
>>>>>>>> feature/UC9:src/UseCase9TrainConsistMngmt.java
    }
}