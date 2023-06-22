package com.breeze.summer;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.breeze.summer.utils.TimeUtilsService.getDateTimeNow;

public class SmallTest extends CollectionsTest {
  // public String name = "Joe";
  // public Integer price = 50;

  public static final String FORCAST_TYPE = "Standard";
  public static final Integer ITEMS_PER_PAGE = 20;
  public static final Double DISCOUNT;

  static {
    DISCOUNT = 0.1;
  }

  @Test
  public void arrayListTest() {
    var a = 5F;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss Z");

    String dateTime = getDateTimeNow().format(formatter);

    System.out.println("Now is: " + dateTime);

    Double result = Math.sqrt(9);

    Integer max = Math.max(1, 5);

    Double floor = Math.floor(15.78F);
    System.out.println(floor);

    Integer remainder = 20 % 7;
    System.out.println(remainder);

  }

  public static void setItemsPerPage(Integer numberPerPage) {
    // ITEMS_PER_PAGE = numberPerPage;
  }

  public ArrayList<String> makeWorkers() {
    ArrayList<String> workers = new ArrayList<>();

    // populate ArrayList:
    workers.add("Tom");
    workers.add("Tim");
    workers.add("Jamal");
    workers.add("Kemal");

    List<String> newWorkers = List.of("Den", "Sam", "Tom");

    // get element of ArrayList by index
    String firstWorker = workers.get(0);

    // find element by value:
    int indexOfTim = workers.indexOf("Tim");

    // update element:
    workers.set(0, "Samuel");
    System.out.println("New first worker is: " + workers.get(0));

    // remove element:
    workers.remove(3);

    // get size of ArrayList
    int numberOfWorkers = workers.size();

    // iterate through list:
    for (int i = 0; i < workers.size(); i++) {

      System.out.print(workers.get(i) + " ");
    }

    // remove all:
    workers.clear();
  }

  public HashMap<String, String> makePlayersList() {
    HashMap<String, String> players = new HashMap<>();
    players.put("player1", "Bob Johnson");
    players.put("player2", "Steven McArthur");

    return players;
  }
}
