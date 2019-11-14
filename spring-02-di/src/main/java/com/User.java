package com;

public class User {
    private Dog dog;
    private Cat cat;

    public User(Dog dog, Cat cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "dog=" + dog +
                ", cat=" + cat +
                '}';
    }
}
