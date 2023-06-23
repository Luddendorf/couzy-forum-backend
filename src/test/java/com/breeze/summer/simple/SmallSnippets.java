package com.breeze.summer.simple;

// import com.breeze.summer.dto.Post;
import org.junit.jupiter.api.Test;

public class SmallSnippets {
  public static final String URL_TO_WIKI_SERVER = "https://www.wikipedia.org";

  @Test
  public void stringsTest() {

    // Post post1 = new Post();
    // Post post2 = new Post();

    // System.out.println(myFirstChar);

    char myFirstChar = 'a';
    int myMark = 10;
    long myId = 10L;
    float myPrice = 15.65F;
    double myExactPrice = 15.6543535153454534D;
    boolean isRegistered = true;

    String myText = "Bla-bla";
    String answer = "Bla-bla";
    String userInput = "Sunglasses Samsung new CoLLecTion     ";
    String story = "Once upon a time far-far away. It was a sunny day.";

    boolean isPasswordOk = myText.equals(answer);

    boolean isStartingWithB = myText.startsWith("B");

    boolean isEndingWithA = myText.endsWith("a");

    String searchString = userInput.toLowerCase();

    String trimmedInput = searchString.trim();

    String[] myWords = story.split(" ");

    Integer phonePrice = 15;
    Integer myNewPrice = Integer.parseInt("18");

    Double myUpdatedSpoonPrice = 12.46445435D;
    Long numberOfStarsOfClassG = 590345834058345L;

    String announcement = "Our new price is: " + String.valueOf(myUpdatedSpoonPrice);
    myFirstChar = 'b';

    int startOfSecondSentence = story.indexOf(".");

    String secondSentence = story.substring(startOfSecondSentence + 1);
    System.out.println(secondSentence);

  }

  @Test
  public void objectPractice() {

    Man tom = new Man("Tom", 25);
    Man joe = new Man("Joe", 26);
    String newName = "Donald";
    Integer playerMoney = 1000;

    System.out.println("Tom is: " + tom);
    System.out.println("Current money is: " + playerMoney);

    Man newMan = editName(tom, newName);
    Integer moneyLeft = takeCommission(playerMoney);

    System.out.println("Tom is: " + tom);
    System.out.println("Current money is: " + playerMoney);
  }

  public Integer takeCommission(Integer money) {
    return money - 10;
  }

  public Man editName(Man man, String newName) {
    man.setName(newName);

    return man;
  }

  /**
   * Greeting generator.
   * 
   * @param name name of the hero
   * @return greeting string
   */
  public String makeGreeting(String name) {
    return "Hello, dear " + name;
  }

  public void makeNoise() {
    System.out.println("Hello!");
  }
}

/*
 * PascalCase ItIsWritingLikeThis
 * 
 * camelCase itIsListThis
 * 
 * snake_case it_is_like_this
 * 
 * kebab-case it-is-like-this
 * 
 * constants MY_FORCAST_TYPE = "standard"
 */