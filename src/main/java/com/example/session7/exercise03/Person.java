package main.java.com.example.session7.exercise03;

public class Person {
  private String name;
  private int age;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    if (age <= 0) {
        System.out.println("年齢の値は負の数できない。");
    } else {
        this.age = age;
    }
  }


}
