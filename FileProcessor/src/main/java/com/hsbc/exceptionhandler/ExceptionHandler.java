package com.hsbc.exceptionhandler;

public interface ExceptionHandler {
  void handleException(Exception e , String errorMessage) throws Exception;
}
