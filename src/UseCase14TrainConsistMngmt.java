class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    String type;
    int capacity;

    PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    void display() {
        System.out.println(type + " - Capacity: " + capacity);
    }
}

public class UseCase14TrainConsistMngmt {

    public static PassengerBogie createBogie(String type, int capacity)
            throws InvalidCapacityException {
        return new PassengerBogie(type, capacity);
    }

    public static void main(String[] args) {
        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);   // exception
            PassengerBogie b3 = new PassengerBogie("First Class", -10);

            b1.display();
            b2.display();
            b3.display();
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            PassengerBogie b4 = new PassengerBogie("First Class", 24);
            b4.display();
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}