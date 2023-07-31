package repository;

import com.breeze.summer.repositories.PostRepository;
import com.breeze.summer.services.PostService;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

public class PostRepoTestConfig {

  @Bean
  public PostService postService(PostRepository postRepository,
      EntityManager entityManager) {
    return new PostService(postRepository, entityManager);
  }
}
