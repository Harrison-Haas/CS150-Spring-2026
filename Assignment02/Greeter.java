public class Greeter {
    private String name;

    public Greeter(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return "Welcome, " + name + "!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
