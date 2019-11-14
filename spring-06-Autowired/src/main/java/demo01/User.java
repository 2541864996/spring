package demo01;

public class User {
    private Cat cat;
    private Dog dog;

    public User() {
    }

    public User(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
