package com.hsbc;

import com.hsbc.processor.Operation;
import com.hsbc.processor.TextOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextOperationTest {

  private Operation operation = new TextOperation();

  @Test
  void testReverseOperation(){
      String input = "lorem.ipsum ";
      String expectedOutput = " muspi.merol";

      Assertions.assertEquals(operation.reverse(input) , expectedOutput);
  }
}
