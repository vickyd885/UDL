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

/**
 * This class will test loading json data and
 * deserialising it, therefore it tests all the
 * JSON classes
 */
public class SiteJSONObjectsTest extends TestCase  {

   private String jsonData = null;
   private Gson gson = null;
   SiteInfo siteInfo = null;


   @Before
   public void setUp() {
     this.gson = createGsonInstance();

     try{
       this.jsonData = readFile("test/reference/sites.json",StandardCharsets.UTF_8);
       this.siteInfo = gson.fromJson(this.jsonData, SiteInfo.class);
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
   public void testJSONParent(){
     System.out.println("Testing JSON parent");
     assertNotNull(this.siteInfo);
   }

   @Test
   public void testSiteList(){
     System.out.println("Testing SiteReport");
     assertNotNull(this.siteInfo.getListOfSites());
   }

   @Test
   public void testSiteListLength(){
     System.out.println("Testing SiteList length");
     assertEquals(this.siteInfo.getListOfSites().size(), 1);
   }

   @Test
   public void testSiteGetDataManager(){
     System.out.println("Testing DataManger getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getDataManager(),
        "King's College London");
   }

   @Test
   public void testSiteSetDataManager(){
     System.out.println("Testing DataManger getter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setDataManager(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getDataManager(),
        input);
   }

   @Test
   public void testSiteGetDataOwner(){
     System.out.println("Testing DataOwner getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getDataOwner(),
        "Barking and Dagenham");
   }

   @Test
   public void testSiteSetDataOwner(){
     System.out.println("Testing DataOwner getter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setDataOwner(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getDataOwner(),
        input);
   }

   @Test
   public void testSiteGetDateClosed(){
     System.out.println("Testing DateClosed getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getDateClosed(),
        "2011-05-25 00:00:00");
   }

   @Test
   public void testSiteSetDateClosed(){
     System.out.println("Testing DataOwner getter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setDateClosed(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getDateClosed(),
        input);
   }


   // @Test
   // public void testListOfSitesExist(){
   //   System.out.println("Testing SiteList");
   //   assertNotNull(this.pollutionInfo.getSiteReport().getList());
   // }

   // @Test
   // public void testLongitudeSettingAndGetting(){
   //   System.out.println("Testing longitude setting and getting");
   //   String testLong = "LONGTEST";
   //   this.pollutionInfo.getSiteReport().setLongitgude(testLong);
   //   assertEquals(this.pollutionInfo.getSiteReport().getLongitude(), testLong);
   // }
   //
   // @Test
   // public void testLattitudeSettingAndGetting(){
   //   System.out.println("Testing Lattitude setting and getting");
   //   String testLat = "LATTEST";
   //   this.pollutionInfo.getSiteReport().setLongitgude(testLat);
   //   assertEquals(this.pollutionInfo.getSiteReport().getLatitude(), testLat);
   // }






   //tearDown used to close the connection or clean up activities
   public void tearDown() {

   }

   private Gson createGsonInstance(){
     GsonBuilder gsonBuilder = new GsonBuilder();
     gsonBuilder.registerTypeAdapter(Site.class, new SiteDeseraliser());
     Gson gson = gsonBuilder.create();
     return gson;
   }


   static String readFile(String path, Charset encoding) throws IOException
   {
       byte[] encoded = Files.readAllBytes(Paths.get(path));
       return new String(encoded, encoding);
   }
}
