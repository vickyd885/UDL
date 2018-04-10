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

// JSON library
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class PollutionJSONObjectTest extends TestCase  {

  private String jsonData = null;
  private Gson gson = null;
  PollutionInfo pInfo = null;

   @Before
   public void setUp() {
     this.gson = createGsonInstance();

     try{
       this.jsonData = readFile("test/reference/pollution.json",StandardCharsets.UTF_8);
       this.pInfo = gson.fromJson(this.jsonData, PollutionInfo.class);
     }catch( Exception e){
       System.out.println("Error occured reading reference file");
     }
   }

   @Test
   public void testFileExists() {
     System.out.println("Testing reference found");
     assertNotNull(this.jsonData);
   }

   @Test
   public void testJSONParentExits() {
     System.out.println("Testing JSON parent found");
     assertNotNull(this.pInfo);
   }

   @Test
   public void testSiteReport(){
     System.out.println("Testing SiteReport");
     assertNotNull(this.pInfo.getSiteReport());
   }

   @Test
   public void testPollutionListLength(){
     System.out.println("Testing PollutionItem list");
     assertEquals(this.pInfo.getList().size(),1);
   }


   @Test
   public void testLongitudeSettingAndGetting(){
     System.out.println("Testing longitude setting and getting");
     String testLong = "LONGTEST";
     this.pInfo.getSiteReport().setLongitgude(testLong);
     assertEquals(this.pInfo.getSiteReport().getLongitude(), testLong);
   }

   @Test
   public void testLattitudeSettingAndGetting(){
     System.out.println("Testing Lattitude setting and getting");
     String testLat = "LATTEST";
     this.pInfo.getSiteReport().setLatitude(testLat);
     assertEquals(this.pInfo.getSiteReport().getLatitude(), testLat);
   }

   @Test
   public void testGetSpeciesCode(){
     System.out.println("Testing get species code");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getSpeciesCode(),
      "NO2"
     );
   }

   @Test
   public void testSetSpeciesCode(){
     System.out.println("Testing set species code");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setSpeciesCode(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getSpeciesCode(),
      input
     );
   }

   @Test
   public void testGetReportItem(){
     System.out.println("Testing get ReportItem code");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getReportItem(),
      "0"
     );
   }

   @Test
   public void testSetReportItem(){
     System.out.println("Testing set ReportItem");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setReportItem(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getReportItem(),
      input
     );
   }

   @Test
   public void testGetReportItemName(){
     System.out.println("Testing get ReportItemName");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getReportItemName(),
      "Nitrogen Dioxide"
     );
   }

   @Test
   public void testSetReportItemName(){
     System.out.println("Testing set ReportItemName");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setReportItemName(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getReportItemName(),
      input
     );
   }

   @Test
   public void testGetAnnual(){
     System.out.println("Testing get Annual");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getAnnual(),
      "-999"
     );
   }

   @Test
   public void testSetAnnual(){
     System.out.println("Testing set Annual");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setAnnual(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getAnnual(),
      input
     );
   }


   @Test
   public void testGetMonth1(){
     System.out.println("Testing get Month1");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth1(),
      "-999"
     );
   }

   @Test
   public void testSetMonth1(){
     System.out.println("Testing set Month1");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth1(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth1(),
      input
     );
   }


   @Test
   public void testGetMonth2(){
     System.out.println("Testing get Month1");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth2(),
      "-999"
     );
   }

   @Test
   public void testSetMonth2(){
     System.out.println("Testing set Month2");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth2(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth2(),
      input
     );
   }


   @Test
   public void testGetMonth3(){
     System.out.println("Testing get Month3");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth3(),
      "-999"
     );
   }

   @Test
   public void testSetMonth3(){
     System.out.println("Testing set Month3");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth3(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth3(),
      input
     );
   }

   @Test
   public void testGetMonth4(){
     System.out.println("Testing get Month4");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth2(),
      "-999"
     );
   }

   @Test
   public void testSetMonth4(){
     System.out.println("Testing set Month4");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth4(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth4(),
      input
     );
   }

   @Test
   public void testGetMonth5(){
     System.out.println("Testing get Month5");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth5(),
      "-999"
     );
   }

   @Test
   public void testSetMonth5(){
     System.out.println("Testing set Month5");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth5(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth5(),
      input
     );
   }

   @Test
   public void testGetMonth6(){
     System.out.println("Testing get Month1");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth6(),
      "-999"
     );
   }

   @Test
   public void testSetMonth6(){
     System.out.println("Testing set Month6");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth6(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth6(),
      input
     );
   }

   @Test
   public void testGetMonth7(){
     System.out.println("Testing get Month7");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth7(),
      "-999"
     );
   }

   @Test
   public void testSetMonth7(){
     System.out.println("Testing set Month7");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth7(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth7(),
      input
     );
   }

   @Test
   public void testGetMonth8(){
     System.out.println("Testing get Month1");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth8(),
      "-999"
     );
   }

   @Test
   public void testSetMonth8(){
     System.out.println("Testing set Month8");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth8(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth8(),
      input
     );
   }

   @Test
   public void testGetMonth9(){
     System.out.println("Testing get Month9");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth9(),
      "-999"
     );
   }

   @Test
   public void testSetMonth9(){
     System.out.println("Testing set Month9");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth9(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth9(),
      input
     );
   }

   @Test
   public void testGetMonth10(){
     System.out.println("Testing get Month10");
     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth10(),
      "-999"
     );
   }

   @Test
   public void testSetMonth10(){
     System.out.println("Testing set Month10");
     String input = "input";
     this.pInfo.getSiteReport()
       .getList()
       .get(0)
       .setMonth10(input);

     assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth10(),
      input
     );
   }

    @Test
    public void testGetMonth11(){
      System.out.println("Testing get Month11");
      assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth11(),
       "-999"
      );
    }

    @Test
    public void testSetMonth11(){
      System.out.println("Testing set Month11");
      String input = "input";
      this.pInfo.getSiteReport()
        .getList()
        .get(0)
        .setMonth11(input);

      assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth11(),
       input
      );
    }


    @Test
    public void testGetMonth12(){
      System.out.println("Testing get Month12");
      assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth12(),
       "-999"
      );
    }

    @Test
    public void testSetMonth12(){
      System.out.println("Testing set Month11");
      String input = "input";
      this.pInfo.getSiteReport()
        .getList()
        .get(0)
        .setMonth12(input);

      assertEquals(this.pInfo.getSiteReport().getList().get(0).getMonth12(),
       input
      );
    }







   //tearDown used to close the connection or clean up activities
   public void tearDown() {

   }

   private Gson createGsonInstance(){
     GsonBuilder gsonBuilder = new GsonBuilder();
     gsonBuilder.registerTypeAdapter(PollutionItem.class, new PollutionItemDeserialiser());
     Gson gson = gsonBuilder.create();
     return gson;
   }


   static String readFile(String path, Charset encoding) throws IOException
   {
       byte[] encoded = Files.readAllBytes(Paths.get(path));
       return new String(encoded, encoding);
   }
}
