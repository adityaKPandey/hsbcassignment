package com.hsbc.exceptionhandler;

import com.hsbc.exception.FileWriteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriteExceptionHandler implements ExceptionHandler{

  private static final Logger logger = Logger.getLogger(FileWriteExceptionHandler.class.getName());

  @Override
  public void handleException(Exception e , String errorMessage) throws Exception {
    {
      StringBuilder errorMessageBuilder = new StringBuilder(errorMessage);
      logger.log(Level.SEVERE , errorMessageBuilder.append(e.getMessage()).toString());
      throw new FileWriteException(errorMessage);
    }
  }
}
