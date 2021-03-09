package israel.healthapp.models;

import java.util.UUID;

public class User {
    UUID id;
    String birthday;
    double height;
    double weight;
    String gender;
    String fitnessLevel;

    public User(UUID id, String birthday, double height, double weight, String gender, String fitnessLevel) {
        this.id = id;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.fitnessLevel = fitnessLevel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(String fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }
}
