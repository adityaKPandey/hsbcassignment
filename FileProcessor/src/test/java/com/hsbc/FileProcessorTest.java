package com.hsbc;

import com.hsbc.exception.FileReadException;
import com.hsbc.exceptionhandler.ExceptionHandler;
import com.hsbc.exceptionhandler.FileReadExceptionHandler;
import com.hsbc.exceptionhandler.FileWriteExceptionHandler;
import com.hsbc.processor.TextOperation;
import com.hsbc.reader.ContentReader;
import com.hsbc.reader.ReversedFileContentReader;
import com.hsbc.writer.ContentWriter;
import com.hsbc.writer.FileContentWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FileProcessorTest {
    private ContentReader reader;
    private ContentWriter writer;
    private ExceptionHandler readExceptionHandler;
    private ExceptionHandler writeExceptionHandler;


    @BeforeEach
    void setup(){
      readExceptionHandler = new FileReadExceptionHandler();
      writeExceptionHandler = new FileWriteExceptionHandler();
      reader = new ReversedFileContentReader(new TextOperation() , readExceptionHandler);
      writer = new FileContentWriter(writeExceptionHandler);
    }


    @Test
    void testReadFile_throwsException(){
        Assertions.assertThrows(FileReadException.class , () -> reader.read("dummyReadPath"));
    }

    @Test
    void testWriteFile() throws Exception{
        writer.write("out sample text" , "dummyWritePath");
    }

}
