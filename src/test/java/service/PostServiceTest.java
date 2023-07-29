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
  void testFindPosts() {
    when(postService.findPostsByFilter(any(FilterPost.class)))
      .thenReturn(null);
    
    verify(postService).findPostsByFilter(any(FilterPost.class));
  }
}
