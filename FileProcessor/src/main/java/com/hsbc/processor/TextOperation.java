package com.hsbc.processor;

public class TextOperation implements Operation{

  @Override
  public String reverse(String text) {
     StringBuffer reversedText = new StringBuffer();

     for(int i = text.length() - 1 ; i > -1; i--)
         reversedText.append(text.charAt(i));

     return reversedText.toString();
  }
}
