import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

// Java Data Structures
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


public class SiteGathererTest extends TestCase  {

  private SiteGatherer siteGatherer;

   @Before
   public void setUp() {
     this.siteGatherer = new SiteGatherer();
   }

   @Test
   public void testListOfSitesIsNotNull() {
     System.out.println("Testing not null");
     boolean error = false;
     try{
       this.siteGatherer.query();
     }catch(Exception e){
       error = true; // caught an error so fail
     }
     if(error) assertFalse(error);

     assertNotNull(this.siteGatherer.getListOfSites());
   }

   @Test
   public void testHTTPCall() {
     System.out.println("Testing HTTP call to the end point");
     boolean error = false;
     try{
       this.siteGatherer.query();
     }catch(Exception e){
       error = true; // caught an error so fail
     }
     assertFalse(error);
   }

   //tearDown used to close the connection or clean up activities
   public void tearDown() {

   }
}
