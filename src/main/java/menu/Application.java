package menu;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Service());
        controller.start();
    }
}
