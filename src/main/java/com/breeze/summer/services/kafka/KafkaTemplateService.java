package com.breeze.summer.services.kafka;

import com.breeze.summer.utils.log.Loggable;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.nio.charset.StandardCharsets;

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
    // this.tracer.currentSpan().context().traceId();
    byte[] traceIdBytes = String.valueOf("hello").getBytes(StandardCharsets.UTF_8);

    ProducerRecord<String, T> record = new ProducerRecord(topicName, messageObject);
    record.headers().add(TRACE_ID_HEADER_NAME, traceIdBytes);

    ListenableFuture<SendResult<String, T>> sendResultFuture = this.template.send(record);

    sendResultFuture.addCallback(new ListenableFutureCallback<SendResult<String, T>>() {
      public void onSuccess(SendResult<String, T> result) {
      }

      public void onFailure(Throwable ex) {
        logger.error("Error when sending Kafka message", ex);
      }
    });

  }
}
