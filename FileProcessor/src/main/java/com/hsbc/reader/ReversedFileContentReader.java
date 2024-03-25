package com.hsbc.reader;

import static com.hsbc.Constants.NEW_LINE;

import com.hsbc.exceptionhandler.ExceptionHandler;
import com.hsbc.processor.Operation;
import com.hsbc.writer.FileContentWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ReversedFileContentReader implements ContentReader {

  private Operation textOperation;
  private ExceptionHandler exceptionHandler;

  private final Logger logger = Logger.getLogger(FileContentWriter.class.getName());


  public ReversedFileContentReader(Operation operation , ExceptionHandler exceptionHandler) {
    this.textOperation = operation;
    this.exceptionHandler = exceptionHandler;
  }

  @Override
  public String read(String filePath) throws Exception {

    logger.info("Reading file " + filePath);
    Stack<String> lineStack = new Stack<>();

    try (Stream<String> lines = getLines(filePath)) {
      lines.forEach(line -> lineStack.push(textOperation.reverse(line)));
      return popStack(lineStack);
    } catch (Exception e) {
      StringBuilder errorMessageBuilder = new StringBuilder().append("Error while reading file : ").append(
          filePath).append(System.lineSeparator());
      exceptionHandler.handleException(e,errorMessageBuilder.toString());
    }
    return null;
  }


  private Stream<String> getLines(String filePath) throws IOException {
    return Files.lines(Paths.get(filePath));
  }

  private String popStack(Stack<String> lineStack) {
    final StringBuffer reversedFile = new StringBuffer();

    while (!lineStack.empty()) {
      reversedFile.append(lineStack.pop());
      reversedFile.append(NEW_LINE);
    }

    return reversedFile.toString();
  }
}
