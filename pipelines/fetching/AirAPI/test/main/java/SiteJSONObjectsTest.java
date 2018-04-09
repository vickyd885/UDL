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
     System.out.println("Testing DataOwner setter");
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
     System.out.println("Testing DataOwner setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setDateClosed(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getDateClosed(),
        input);
   }

   @Test
   public void testSiteGetDateOpened(){
     System.out.println("Testing DateOpened getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getDateOpened(),
        "2007-03-16 00:00:00");
   }

   @Test
   public void testSiteSetDateOpened(){
     System.out.println("Testing DateOpened setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setDateOpened(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getDateOpened(),
        input);
   }

   @Test
   public void testSiteGetDisplayOffsetX(){
     System.out.println("Testing DisplayOffsetX getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getDisplayOffsetX(),
        "0");
   }

   @Test
   public void testSiteSetDisplayOffsetX(){
     System.out.println("Testing DisplayOffsetX setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setDisplayOffsetX(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getDisplayOffsetX(),
        input);
   }


   @Test
   public void testSiteGetDisplayOffsetY(){
     System.out.println("Testing DisplayOffsetY getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getDisplayOffsetY(),
        "0");
   }

   @Test
   public void testSiteSetDisplayOffsetY(){
     System.out.println("Testing DisplayOffsetY setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setDisplayOffsetY(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getDisplayOffsetY(),
        input);
   }

   @Test
   public void testSiteGetLatitude(){
     System.out.println("Testing Latitude getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getLatitude(),
        "51.540444");
   }

   @Test
   public void testSiteSetLatitude(){
     System.out.println("Testing Latitude setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setLatitude(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getLatitude(),
        input);
   }

   @Test
   public void testSiteGetLatitudeWGS84(){
     System.out.println("Testing LatitudeWGS84 getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getLatitudeWGS84(),
        "6717454.5833");
   }

   @Test
   public void testSiteSetLatitudeWGS84(){
     System.out.println("Testing LatitudeWGS84 setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setLatitudeWGS84(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getLatitudeWGS84(),
        input);
   }

   @Test
   public void testSiteGetLocalAuthorityCode(){
     System.out.println("Testing LocalAuthorityCode getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getLocalAuthorityCode(),
        "1");
   }

   @Test
   public void testSiteSetLocalAuthorityCode(){
     System.out.println("Testing LocalAuthorityCode setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setLocalAuthorityCode(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getLocalAuthorityCode(),
        input);
   }

   @Test
   public void testSiteGetLocalAuthorityName(){
     System.out.println("Testing LocalAuthorityName getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getLocalAuthorityName(),
        "Barking and Dagenham");
   }

   @Test
   public void testSiteSetLocalLocalAuthorityName(){
     System.out.println("Testing LocalAuthorityName setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setLocalAuthorityName(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getLocalAuthorityName(),
        input);
   }

   @Test
   public void testSiteGetLongitude(){
     System.out.println("Testing Longitude getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getLongitude(),
        "0.074418");
   }

   @Test
   public void testSiteSetLongitude(){
     System.out.println("Testing Longitude setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setLongitude(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getLongitude(),
        input);
   }

   @Test
   public void testSiteGetLongitudeWGS84(){
     System.out.println("Testing Longitude getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getLongitudeWGS84(),
        "8284.17386585");
   }

   @Test
   public void testSiteSetLongitudeWGS84(){
     System.out.println("Testing Longitude setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setLongitudeWGS84(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getLongitudeWGS84(),
        input);
   }

   @Test
   public void testSiteGetSiteCode(){
     System.out.println("Testing SiteCode getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteCode(),
        "BG3");
   }

   @Test
   public void testSiteSetSiteCode(){
     System.out.println("Testing SiteCode setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setSiteCode(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteCode(),
        input);
   }

   @Test
   public void testSiteGetSiteLink(){
     System.out.println("Testing SiteLink getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteLink(),
        "http://www.londonair.org.uk/london/asp/publicdetails.asp?site=BG3");
   }

   @Test
   public void testSiteSetSiteLink(){
     System.out.println("Testing SiteLink setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setSiteCode(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteCode(),
        input);
   }

   @Test
   public void testSiteGetSiteName(){
     System.out.println("Testing SiteName getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteName(),
     "Barking and Dagenham - North Street");
   }

   @Test
   public void testSiteSetSiteName(){
     System.out.println("Testing SiteName setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setSiteName(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteName(),
      input);
   }

   @Test
   public void testSiteGetSiteType(){
     System.out.println("Testing SiteType getter");
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteType(),
     "Kerbside");
   }

   @Test
   public void testSiteSetSiteType(){
     System.out.println("Testing SiteType setter");
     String input = "input";
     this.siteInfo.getListOfSites().get(0).setSiteType(input);
     assertEquals(this.siteInfo.getListOfSites().get(0).getSiteType(),
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
