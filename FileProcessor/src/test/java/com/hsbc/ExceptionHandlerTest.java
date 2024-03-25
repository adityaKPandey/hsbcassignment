package com.hsbc;

import com.hsbc.exception.FileReadException;
import com.hsbc.exception.FileWriteException;
import com.hsbc.exceptionhandler.ExceptionHandler;
import com.hsbc.exceptionhandler.FileReadExceptionHandler;
import com.hsbc.exceptionhandler.FileWriteExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {

  private ExceptionHandler readExceptionHandler = new FileReadExceptionHandler();
  private ExceptionHandler writeExceptionHandler = new FileWriteExceptionHandler();

  @Test
  void testReadExceptionHandling(){
    Assertions.assertThrows(FileReadException.class, () -> readExceptionHandler.handleException(new RuntimeException("Error in reading file") , "Default Error message"));
  }

  @Test
  void testWriteExceptionHandling(){
    Assertions.assertThrows(FileWriteException.class, () -> writeExceptionHandler.handleException(new RuntimeException("Error in writing file") , "Default Error message"));
  }
}
