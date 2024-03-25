package com.hsbc.writer;

import com.hsbc.exceptionhandler.ExceptionHandler;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class FileContentWriter implements ContentWriter {

  private final Logger logger = Logger.getLogger(FileContentWriter.class.getName());
  private ExceptionHandler exceptionHandler;

  public FileContentWriter(ExceptionHandler exceptionHandler) {
    this.exceptionHandler = exceptionHandler;
  }

  @Override
  public void write(String content, String path) throws Exception {
    try {
      Path outPath = Paths.get(path) ;
      create(path);
      logger.info("Writing to path : " + path);
      Files.write(outPath, content.getBytes(StandardCharsets.UTF_8),
          StandardOpenOption.APPEND);
    } catch (Exception e) {
      StringBuilder errorMessageBuilder = new StringBuilder("Error occurred while writing to path ").append(
          path);
      exceptionHandler.handleException(e , errorMessageBuilder.toString());
    }
  }


}
