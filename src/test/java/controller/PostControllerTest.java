package controller;

import com.breeze.summer.SpringTodoAppApplication;
import com.breeze.summer.controllers.PostControllerImpl;
import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.FoundPosts;
import com.breeze.summer.services.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static statics.utils.ResourceReaderUtil.deserializeFoundPosts;
import static statics.utils.ResourceReaderUtil.getFilterPostMaxParams;
import static statics.utils.ResourceReaderUtil.getFoundPosts;

// @AutoConfigureMockMvc
// @SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PostControllerImpl.class)
@MockBean(JpaMetamodelMappingContext.class)
@ContextConfiguration(classes = SpringTodoAppApplication.class)
class PostControllerTest {
  private static FilterPost postReq;
  private static FoundPosts foundPosts;

  @BeforeAll
  static void init() {
    try {
      postReq = getFilterPostMaxParams();
      foundPosts = getFoundPosts();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterEach
  void tearDown() {
    verifyNoMoreInteractions(postService);
  }

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PostService postService;

  @Test
  void findPostsByFilterReturnsPostsSuccessfully() throws Exception {
    when(postService.findPostsByFilter(any(FilterPost.class)))
    .thenReturn(foundPosts);

    MvcResult actualResponse = mockMvc.perform(post("/post/search", postReq))
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
      .andReturn();

    FoundPosts actualResponsePayload = deserializeFoundPosts(
      actualResponse.getResponse().getContentAsString()
    );

    verify(postService).findPostsByFilter(postReq);
    assertEquals(foundPosts, actualResponsePayload);
  }
}
