package converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.stream.Stream;

import static com.breeze.summer.utils.TimeUtilsService.getShortDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

// import static converter.DtoGenerator.getPostsList;

public class DtoConverterTest {

  @ParameterizedTest
  @MethodSource("getPostsList")
  void formattingShortDatesTest(String dateString, Instant instant) {
    assertEquals(dateString, getShortDate(instant));
  }

  private static Stream<Arguments> getPostsList() {
    return Stream.of(
        Arguments.of("14.01.2022", Instant.parse("2022-01-14T18:00:30.00Z")),
        Arguments.of("01.02.2019", Instant.parse("2019-02-01T18:00:30.00Z")));
  }
}
