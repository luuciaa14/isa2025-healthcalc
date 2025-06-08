package healthcalc;

public class Person {
    private int height;
    private float weight;
    private int age;
    private Gender gender;

    public Person(int height, float weight, int age, Gender gender) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
