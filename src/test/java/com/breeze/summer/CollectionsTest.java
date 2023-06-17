package com.breeze.summer;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {

  @Test
  void makeSumTest() {
    // arrange
    Integer firstMark = 15;
    Integer secondMark = 10;
    Integer expectedResult = 25;
    // action
    Integer actualResult = makeSum(firstMark, secondMark);
    // assert
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void conditionalExecutionTest() {
    Integer ageChild = 12;
    Integer ageAdult = 21;
    Integer ageOld = 81;

    assertEquals(false, checkUserAge(ageChild));
    assertEquals(true, checkUserAge(ageAdult));
    assertEquals(false, checkUserAge(ageOld));
  }

  @Test
  void checkUseTest() {
    assertEquals(true, checkCredentialsBetter("my-login", "password"));
  }

  @Test
  void ternaryOperatorTest() {
    String message;
    Integer age = 4;

    message = (age > 18) ? "You are adult" : "You are too young";

    System.out.println(message);
  }

  @Test
  void switchTest() {
    String monday = "Monday";
    String tuesday = "Tuesday";
    String wednesday = "Wednesday";
    String thursday = "Thursday";
    String friday = "Friday";
    String saturday = "Saturday";
    String sunday = "Sunday";

    findDay(monday);
    findDay(sunday);
  }

  private Integer makeSum(Integer num1, Integer num2) {
    return num1 + num2;
  }

  private Boolean checkUserAge(Integer age) {

    if (age < 18) {
      System.out.println("Sorry, You are too young, access denied.");
      return false;
    }

    if (age > 18 && age < 80) {
      System.out.println("You can pass. Have a nice time.");
      return true;
    } else {
      System.out.println("Sorry, we do not serve people with age over 80.");
      return false;
    }
    // Comparison operators:
    // equals(), == , <, <=, >, >=, &&, ||

    // revert boolean - !

    // methods for work with String - startWith, endWith, toUpperCase(),
    // toLowerCase(),
    // equals(), StringUtils.isNotBlank(), Objects.isNull(), Object.nonNull()
  }

  private Boolean checkUser(String userName, Integer age) {

    if (userName.isBlank() && age < 18 && age > 80) {
      return false;
    }

    if (userName.startsWith("John", 0) && age == 24) {
      return false;
    }
    return true;
  }

  private Boolean checkCredentials(String login, String password) {
    if (StringUtils.isNotBlank(login)) {
      if (StringUtils.isNotBlank(password)) {

        System.out.println("User is authorized successfully.");
        return true;
      } else {
        System.out.println("User provided no password");
        return false;
      }
    } else {
      System.out.println("User gave no login");
      return false;
    }
  }

  private Boolean checkCredentialsBetter(String login, String password) {
    if (StringUtils.isBlank(login)) {
      System.out.println("User gave no login");
      return false;
    }
    if (StringUtils.isBlank(password)) {
      System.out.println("User provided no password");
      return false;
    }
    System.out.println("User is authorized successfully.");
    return true;
  }

  private void findDay(String day) {
    switch (day) {
      case "Monday":
        System.out.println("Monday");
        break;
      case "Tuesday":
        System.out.println("Tuesday");
        break;
      case "Wednesday":
        System.out.println("Wednesday");
        break;
      case "Thursday":
        System.out.println("Thursday");
        break;
      case "Friday":
        System.out.println("Friday");
        break;
      case "Saturday":
      case "Sunday":
        System.out.println("Week-end has come.");
        break;
      default:
        System.out.println("Unknown day");
        break;
    }
  }
}
