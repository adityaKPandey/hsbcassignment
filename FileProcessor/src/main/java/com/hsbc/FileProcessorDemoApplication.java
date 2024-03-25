package com.hsbc;

import static com.hsbc.Constants.READ_PATH;
import static com.hsbc.Constants.WRITE_PATH;

import com.hsbc.exceptionhandler.FileReadExceptionHandler;
import com.hsbc.exceptionhandler.FileWriteExceptionHandler;
import com.hsbc.processor.TextOperation;
import com.hsbc.reader.ContentReader;
import com.hsbc.reader.ReversedFileContentReader;
import com.hsbc.writer.ContentWriter;
import com.hsbc.writer.FileContentWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileProcessorDemoApplication {

  public static void main(String [] args) throws Exception {
    ContentReader contentReader = new ReversedFileContentReader(new TextOperation(), new FileReadExceptionHandler());

    ContentWriter contentWriter = new FileContentWriter(new FileWriteExceptionHandler());

    contentReader.read(READ_PATH);

    try{
      Files.delete(Paths.get(WRITE_PATH));
    }catch (NoSuchFileException nfe){};

    contentWriter.write(contentReader.read(READ_PATH),WRITE_PATH);


        /*
    //TODO
    1. Local test execution
    2. Add unit tests - mock file operations,
    3. Push code to personal git https://github.com/adityaKPandey/hsbcassignment
    */

  }
}
