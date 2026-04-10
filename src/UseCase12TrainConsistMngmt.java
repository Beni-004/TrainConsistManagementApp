import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " -> " + cargo;
    }
}

public class UseCase12TrainConsistMngmt {
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.getType().equals("Cylindrical")
                        || b.getCargo().equals("Petroleum"));
    }

    public static void main(String[] args) {
        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean isSafe = isTrainSafe(bogies);

        System.out.println("Train Safety Compliance: " + isSafe);
    }
}