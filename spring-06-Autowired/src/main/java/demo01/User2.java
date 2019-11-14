package demo01;

public class User2 {
    private Dog dog;
    private Cat cat;

    public User2() {
    }

    public User2(Dog dog, Cat cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
