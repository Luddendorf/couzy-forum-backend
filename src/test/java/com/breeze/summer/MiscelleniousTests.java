package com.breeze.summer;

import com.breeze.Eatable;
import com.breeze.summer.dto.Post;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// @SpringBootTest
class MiscelleniousTests implements Eatable {

  @Test
  void someSnippets() {

    int mark = 6;
    double speed = 18.87;
    boolean hasPaid = true;

    Post goodPost = new Post();
    goodPost.setText("It was a nice evening");
    goodPost.setUserName("Bob");
    goodPost.setTitle("Sunday story");
    goodPost.setState(12);

    System.out.println(goodPost);

    changeTitle(goodPost);
    changeState(goodPost);

    System.out.println(goodPost);

  }

  private Post changeTitle(Post post) {
    post.setTitle("Fairy tale");
    return post;
  }

  private Post changeState(Post post) {
    post.setState(1);
    return post;
  }

  @Test
  void primitivesWrappers() {

    int amount = 4;
    double temperature = 23.31D;
    long totalSum = 543L;

    System.out.println(totalSum);

    Integer orderAmount = 875;
    Double premium = 54.34;

    String orderPrice = "54.20";
    Double price = Double.parseDouble(orderPrice);

  }

  @Test
  void stringPractice() {
    String name = "Tom";
    Integer age = 21;
    String greeting = "Hello, " + "friend.";

    String intro = "Hello, my name is " + name + ". I am " + age
        + " years old";

    String intro2 = String.format("Hello, my name is %s. I am %d years old",
        name, age);

    // System.out.println(intro2);

    String fruit1 = "apple";
    String fruit2 = "apple";

    Boolean areEqual = fruit1 == fruit2;

    Boolean areEqualOldStyle = fruit1.equals(fruit2);

    // System.out.println(areEqual);
    // System.out.println(areEqualOldStyle);

    String plum = "plum";

    Boolean isPFruit = plum.startsWith("p", 0);

    System.out.println("Does is starts with p: " + isPFruit);

    Integer myPrice = 34;
    String priceAsString = String.valueOf(myPrice);

    String plumUpperCase = plum.toUpperCase();
    System.out.println(plumUpperCase);
  }

  @Test
  void mathPractice() {
    Integer maxNumber = Math.max(5, 75);

    Double myRandom = Math.random();

    System.out.println(myRandom);

    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Audi");
    cars.add("Lanos");
    cars.add("Toyota");

    Iterator iterator = cars.iterator();

    // while (iterator.hasNext()) {
    // System.out.println("I am driving " + iterator.next());
    // }

    List<String> pupils = Arrays.asList("Bob", "Ben", "Tom");

    for (int i = 0; i < pupils.size(); i++) {
      // System.out.println("My name is " + pupils.get(i));
    }

    List<String> vegies = List.of("potato", "tomato", "carrot");

    int counter = 0;
    for (String vegie : vegies) {
      // System.out.println("My vegie is: " + vegie + ". Its number is: " + counter);
      counter++;
    }

    vegies.forEach(vegetable -> {
      // System.out.println("The vegetable name is " + vegetable);
    });

    for (int i = 0; i < 5; i++) {
      System.out.println("Roll number " + (i + 1)
          + ". Result is: " + makeRandomRoll(1, 6));
    }
  }

  private Integer makeRandomRoll(Integer min, Integer max) {
    return min + (int) (Math.random() * ((max - min) + 1));
  }

  @Override
  public Double calculatePrice(Double price, Double discount) {
    return null;
  }

  @Override
  public String makeDescription(Integer fruitId) {
    return null;
  }

}