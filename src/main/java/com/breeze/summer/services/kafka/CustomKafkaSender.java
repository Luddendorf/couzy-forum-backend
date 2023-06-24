package com.breeze.summer.services.kafka;

import com.breeze.summer.dto.Category;
import com.breeze.summer.dto.Post;
import com.breeze.summer.utils.log.Loggable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

@Loggable
public class CustomKafkaSender implements KafkaSender {

  @Value("${facebook.topic-statistics}")
  private String topicPost;

  @Value("${facebook.topic-categories}")
  private String topicCategory;

  private Logger logger;

  private final KafkaTemplateService<Post> kafkaPostTemplateService;
  private final KafkaTemplateService<Category> kafkaCategoryTemplateService;

  public void sendPost(Post post) {
    try {
      kafkaPostTemplateService.sendKafkaMessage(topicPost + "-dev", post);
      logger.info("Post was sent to " + topicPost + " with ID " + post.getPostId());
    } catch (Exception ex) {
      logger.info("Failed to send post with ID " + post.getPostId() + " to topic "
          + topicPost);
    }
  }

  public void sendCategory(Category category) {
    try {
      kafkaCategoryTemplateService.sendKafkaMessage(topicCategory + "-dev", category);
      logger.info("Category was sent to " + topicCategory + " with ID "
          + category.getCategoryId());
    } catch (Exception ex) {
      logger.info("Failed to send category with ID " + category.getCategoryId()
          + " to topic " + topicCategory);
    }
  }
}
