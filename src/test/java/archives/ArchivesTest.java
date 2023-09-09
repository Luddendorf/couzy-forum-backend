package archives;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//@Profile("dev")
public class ArchivesTest {
  private static final String CONTENT = "It was a long and lonesome road...";

  @Test
  void archiveWritingTest() {
    List<Pair<String, byte[]>> files = new ArrayList<Pair<String, byte[]>>();
    String extension = "txt";

    for (int i = 0; i < 3; i++) {

      String fileName = "autumn-" + (i + 1);
      byte[] fileContent = ((i + 1) + ". " + CONTENT).getBytes();
      files.add(Pair.of(fileName, fileContent));
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ZipOutputStream zos = new ZipOutputStream(baos)) {

      for (Pair<String, byte[]> file : files) {
        ZipEntry entry = new ZipEntry(file.getKey() + "." + extension);
        zos.putNextEntry(entry);
        zos.write(file.getValue());
        zos.closeEntry();
      }

      zos.close();
    } catch (IOException e) {
      System.out.println("Error while creating zip archive" + e);
    }

    try {
      Path archivePath = Paths.get("./src/test/resources/archives/my-super-archive.zip");
      Files.write(archivePath, baos.toByteArray());
      baos.close();
    } catch (IOException exception) {
      System.out.println("Error while writing zip archive" + exception);
    }
  }

  @Test
  void archiveReadingTest() {
    StringBuilder strBuilder = new StringBuilder();
    byte[] buffer = new byte[1024];
    int read = 0;
    ZipEntry entry;

    try {
      Path path = Paths.get("./src/test/resources/archives/my-super-archive.zip");
      byte[] mySuperZip = Files.readAllBytes(path);

      ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(mySuperZip), StandardCharsets.UTF_8);

      while ((entry = zis.getNextEntry()) != null) {
        System.out.println("Zip entry " + entry.getName() + " . Size = " + entry.getSize());

        while ((read = zis.read(buffer, 0, 1024)) >= 0) {
          strBuilder.append(new String(buffer, 0, read));
        }
        strBuilder.append(System.lineSeparator());

        if (entry.getName().startsWith("Document_6")) {
          break;
        }
      }
      zis.close();

      Path autumnAllPath = Paths.get("./src/test/resources/merged-text/autumn-all.txt");
      Files.write(autumnAllPath, strBuilder.toString().getBytes());
    } catch (IOException e) {
      System.out.println("Error while reading from archive.");
    }
  }
}
