package statics.utils;

import com.breeze.summer.dto.FilterPost;
import com.breeze.summer.dto.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResourceReaderUtil {
  private static final ObjectMapper objectMapper;

  static {
    JavaTimeModule module = new JavaTimeModule();
    LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer(
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

    module.addDeserializer(LocalDateTime.class, deserializer);
    objectMapper = Jackson2ObjectMapperBuilder.json()
        .modules(module)
        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .build();
  }

  public static String readFromFileToString(String filePath) throws IOException {
    File resource = new ClassPathResource(filePath).getFile();
    byte[] byteArray = Files.readAllBytes(resource.toPath());
    return new String(byteArray);
  }

  // posts
  public static FilterPost deserializeFilterPost(String json)
      throws JsonProcessingException {
    return objectMapper.readValue(json, new TypeReference<>() {
    });
  }

  public static Post deserializePost(String json)
      throws JsonProcessingException {
    return objectMapper.readValue(json, new TypeReference<>() {
    });
  }

  public static FilterPost getFilterPost() throws IOException {
    return deserializeFilterPost(
        readFromFileToString("/post/post-filter.json"));
  }

  public static FilterPost getFilterPostWithUserName() throws IOException {
    return deserializeFilterPost(
        readFromFileToString("/post/post-filter-user-name.json"));
  }

  public static Post getPostSimple() throws IOException {
    return deserializePost(
        readFromFileToString("/post/entity/post-entity.json"));
  }
}
