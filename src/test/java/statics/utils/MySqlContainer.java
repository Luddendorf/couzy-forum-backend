package statics.utils;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class MySqlContainer extends MySQLContainer<MySqlContainer> {
  private static final String IMAGE_VERSION = "mysql:8.0";
  private static MySqlContainer container;

  public static MySqlContainer getInstance() {
    if (container == null) {
      container = new MySqlContainer().withReuse(true);
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("DB_URL", container.getJdbcUrl());
    System.setProperty("DB_USERNAME", container.getUsername());
    System.setProperty("DB_PASSWORD", container.getPassword());
    System.setProperty("DB_DRIVER_CLASS_NAME", container.getDriverClassName());
  }

  @Override
  public void stop() {
    // do nothing.
  }

  @DynamicPropertySource
  public static void overrideProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", container::getJdbcUrl);
    registry.add("spring.datasource.username", container::getUsername);
    registry.add("spring.datasource.password", container::getPassword);
    registry.add("spring.datasource.driver-class-name", container::getDriverClassName);
  }
}
