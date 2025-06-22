package SingletonPattern.Code;

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from the Singleton instance! HashCode: " + this.hashCode());
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        singleton1.showMessage();
        singleton2.showMessage();
        if (singleton1 == singleton2) {
            System.out.println("Both references point to the same Singleton instance.");
        } else {
            System.out.println("Different instances exist. Singleton pattern is not implemented correctly.");
        }
    }
}
