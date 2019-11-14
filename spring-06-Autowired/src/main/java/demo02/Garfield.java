package demo02;

public class Garfield {
    private String name;

    @Override
    public String toString() {
        return "Garfield{" +
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
