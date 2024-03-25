package com.hsbc.writer;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public interface ContentWriter {

  Logger logger = Logger.getLogger(ContentWriter.class.getName());

  default void create(String path) throws IOException {
    {
      File file = new File(path);
      if (!file.exists()) {
        logger.info("Create new file at path: " + path);
        file.createNewFile();
      }
    }
  }

  void write(String content, String path) throws Exception;
}
