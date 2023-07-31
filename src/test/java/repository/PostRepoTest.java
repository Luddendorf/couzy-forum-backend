package repository;

import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.Post;
import com.breeze.summer.repositories.PostRepository;
import com.breeze.summer.services.PostService;
import com.breeze.summer.utils.log.Loggable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import statics.utils.MySqlContainer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static statics.utils.ResourceReaderUtil.getFilterPost;
import static statics.utils.ResourceReaderUtil.getPostSimple;

@Loggable
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ContextConfiguration(classes = PostRepoTestConfig.class)
class PostRepoTest {
  private static FilterPost postReqPayload;
  private static Post postFoundByName;

  @BeforeAll
  static void init() {
    try {
      postReqPayload = getFilterPost();
      postFoundByName = getPostSimple();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @BeforeEach
  void populateWithData() {
    postRepository.save(postFoundByName);
  }

  @AfterEach
  void cleanUp() {
    postRepository.deleteAll();
  }

  @AfterAll
  void stopAll() {
    mySqlContainer.stop();
  }

  @Autowired
  private PostRepository postRepository;
  @Autowired
  private PostService postService;

  public static MySqlContainer mySqlContainer = MySqlContainer.getInstance();

  @Test
  void postIsFoundByNameSuccessTest() {
    String expectedPostTitle = "Story of success";

    Post postFoundByName = postService.findByUserName(postReqPayload.getUserName());

    assertEquals(expectedPostTitle, postFoundByName.getTitle());
  }
}
