package com.breeze.summer.services.kafka;

import com.breeze.summer.utils.log.Loggable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Loggable
public class KafkaTemplateService<T> {
  private Logger logger;
  private static final String TRACE_ID_HEADER_NAME = "traceId";

  @Autowired
  private KafkaTemplate<String, T> template;

  // @Autowired
  // private Tracer tracer;

  public KafkaTemplateService() {
  }

  public void sendKafkaMessage(String topicName, T messageObject) {

    // byte[] traceIdBytes = String.valueOf(this.tracer.currentSpan());
  }
}
