package demo02;

public class Bolt {
    private String name;

    @Override
    public String toString() {
        return "Bolt{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
