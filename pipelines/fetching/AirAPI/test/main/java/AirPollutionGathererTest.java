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


public class AirPollutionGathererTest extends TestCase  {

    private SiteGatherer siteGatherer;
    private AirPollutionGatherer apg;
    private String tempFolder = "testsuite_output";

    @Before
    public void setUp() {
     this.siteGatherer = new SiteGatherer();
     this.siteGatherer.query();

     this.apg = new AirPollutionGatherer(tempFolder);
    }

    @Test
    public void testBaseDIRisNotNull() {
      System.out.println("Testing BaseDIR is not null");
      assertEquals(tempFolder, this.apg.getBaseDir());
    }

    @Test
    public void testFileNameisNotNull() {
      System.out.println("Testing FILE_NAME is not null");
      assertEquals("airpollution.json", this.apg.getFileName());
    }

    @Test
    public void testGetFileWritePath(){
      System.out.println("Testing FILE_WRITE path");
      String expectedPath = this.apg.getBaseDir() + "/2015";
      assertEquals(this.apg.getFileWritePathPublic("2015"), expectedPath);
    }

    // @Test
    // public void testQueryingAPI(){
    //   System.out.println("Testing querying API endpoint");
    //   boolean error = false;
    //   try{
    //     this.apg.start(this.siteGatherer.getListOfSites());
    //   }catch (Exception e){
    //     error = true;
    //   }finally{
    //     File tempFile = new File(this.apg.getFileWritePathPublic("2015"));
    //     File createdFolder = new File(this.tempFolder);
    //     File createdFolder2 = new File("2015");
    //
    //     createdFolder2.delete();
    //     createdFolder.delete();
    //     tempFile.delete();
    //   }
    //   assertFalse(error);
    // }









    //tearDown used to close the connection or clean up activities
    public void tearDown() {

    }
}
