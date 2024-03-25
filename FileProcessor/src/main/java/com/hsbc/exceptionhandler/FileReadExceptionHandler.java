package com.hsbc.exceptionhandler;

import com.hsbc.exception.FileReadException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReadExceptionHandler implements ExceptionHandler{

  private static final Logger logger = Logger.getLogger(FileReadExceptionHandler.class.getName());

  @Override
  public void handleException(Exception e , String errorMessage) throws Exception {
    {
      StringWriter exceptionWriter = new StringWriter();
      PrintWriter exceptionPrinter = new PrintWriter(exceptionWriter);
      e.printStackTrace(exceptionPrinter);
      StringBuilder errorMessageBuilder = new StringBuilder().append(errorMessage);
      logger.log(Level.SEVERE , errorMessageBuilder.append(exceptionWriter.toString()).toString());
      throw new FileReadException(errorMessage);
    }
  }
}
