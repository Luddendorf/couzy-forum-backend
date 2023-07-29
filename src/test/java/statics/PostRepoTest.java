package statics;

import com.breeze.summer.dto.FilterPost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static statics.utils.ResourceReaderUtil.getFilterPost;

class PostRepoTest {
  private static FilterPost postReqPayload;

  @BeforeAll
  static void init() {
    try {
      postReqPayload = getFilterPost();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @BeforeEach
  void populateWithData() {

  }

  @AfterEach
  void cleanUp() {

  }
}
