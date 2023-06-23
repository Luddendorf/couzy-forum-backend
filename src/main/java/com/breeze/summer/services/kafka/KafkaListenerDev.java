package com.breeze.summer.services.kafka;

import com.breeze.summer.dto.Category;
import com.breeze.summer.utils.log.Loggable;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/** Kafka listener for dev. */
@Service
@Loggable
@Profile("dev")
@RequiredArgsConstructor
public class KafkaListenerDev {
  private Logger logger;

  @KafkaListener(topics = "#{'${facebook.topic-statistics}'}" + "-"
      + "#{'${deployment.env}'}", properties = { "spring.json.value.default.type=com.breeze.summer.dto.Category" })
  public void saveFacebookStatistics(
      @Header("traceId") String activityId, @Payload Category category) {
    logger.info("Received category from Facebook statistics with ID {}",
        category.getCategoryId());
    // processing and saving message...
  }
}
