package statics;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static com.breeze.summer.utils.TimeUtilsService.getShortDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateFormatterTest {

  @Test
  void getDateInShortFormat() {
    String expectedDate = "14.01.2022";
    Instant instant = Instant.parse("2022-01-14T18:00:30.00Z");

    String actualDate = getShortDate(instant);

    assertEquals(expectedDate, actualDate);
  }
}
