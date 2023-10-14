package service;

import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.repositories.PostRepository;
import com.breeze.summer.services.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

  // @BeforeAll
  void init() {
    // System.setProperty("SHOW_SQL", myContainer.getShowSql());
  }

  @AfterEach
  void tearDown() {
    verifyNoInteractions(postService);
  }

  @Mock
  PostRepository postRepository;

  @Mock
  EntityManager entityManager;

  @InjectMocks
  PostService postService;

  @Test
  @Cacheable
  void testFindPosts() {
    when(postService.findPostsByFilter(any(FilterPost.class)))
      .thenReturn(null);
    
    verify(postService).findPostsByFilter(any(FilterPost.class));
  }

  @Test
  void readJsonFileTest() {
    InputStream is = this.getClass().getResourceAsStream("request-to-magic-server.json");

  }
}
