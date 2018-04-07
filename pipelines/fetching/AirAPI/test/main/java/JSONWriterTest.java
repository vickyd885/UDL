import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

// Java Data Structures
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Files;

public class JSONWriterTest extends TestCase  {

  private String data = "{'string':'json'}";
  private String folderName = "temp";
  private String filename = "test_file.json";

   @Before
   public void setUp() {
     new File(folderName).mkdirs();
   }

   @Test
   public void testJSOONFileSaving() {
     System.out.println("Testing file save");
     boolean error = false;
     String fileContents = null;
     try{
       JSONWriter.writeToJsonFile(this.data, folderName, filename);
       fileContents = readFile(folderName + "/" + filename, StandardCharsets.UTF_8);

     }catch(Exception e){
       //System.out.println("Exception thrown: "+e);
       error = true; // caught an error so fail
     }
     if(error) assertFalse(error); // fail if exception thrown

     System.out.println(fileContents);
     assertEquals(fileContents, this.data);
   }

   //tearDown used to close the connection or clean up activities
   public void tearDown() {
     File tempfile = new File(folderName + "/" + filename);
     File tempFolder = new File(folderName);

     tempfile.delete();
     tempFolder.delete();
   }

  static String readFile(String path, Charset encoding) throws IOException
  {
      byte[] encoded = Files.readAllBytes(Paths.get(path));
      return new String(encoded, encoding);
  }
}
