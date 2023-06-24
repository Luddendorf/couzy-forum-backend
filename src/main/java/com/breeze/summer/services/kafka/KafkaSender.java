package com.breeze.summer.services.kafka;

import com.breeze.summer.dto.Category;
import com.breeze.summer.dto.Post;

public interface KafkaSender {

  /**
   * Send a post to facebook-stats topic
   * 
   * @param post post written by a user
   */
  void sendPost(Post post);

  /**
   * Send a category to facebook-categories topic
   * 
   * @param category some category of the forum
   */
  void sendCategory(Category category);
}
