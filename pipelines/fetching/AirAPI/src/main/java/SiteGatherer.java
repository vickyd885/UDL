// Networking libaries
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// JSON Library
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


// Java Data Structures
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * SiteGatherer calls the TFL Air Pollution API to retrieve a list of site codes
 * which represent air polluton sites
 *
 * SiteGatherer provides a getter for List<Site> listOfSites, the Site object
 * abstracts away the particular information.
 */
public class SiteGatherer{

  // This endpoint retrieves site codes
  private final String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Information/MonitoringSites/GroupName=London/Json";

  // Holds the site code
  private List<Site> listOfSites;

  /**
   * SiteGatherer Constructor initialises the listOfSites variable
   */
  public SiteGatherer(){
    this.listOfSites = null;
  }

  /**
   * query() makes a HTTP request to the API endpoint and progresses to
   * handle the response to extract the required information.
   *
   * @exception Exception is thrown if HTTP call fails
   */
  public void query(){
    try{

      // Initialise HTTP client
      OkHttpClient client = new OkHttpClient();

      // Build request on the API endpoint
      Request request = new Request.Builder()
      .url(API_URL_ENTRY)
      .build();

      // Call the API and record a response
      Response response = client.newCall(request).execute();

      // Convert response to string
      String responseAsString = response.body().string();

      // Handle the response
      handleResponse(responseAsString);

    }catch(Exception e){
      System.out.println("An error occured whilst querying API!");
    }finally{
      //
    }
  }


  /**
   * Given the HTTP response from the API, extract useful information and update
   * listOfSites
   * @param json json strong from HTTP response
   */
  private void handleResponse(String json){


    Gson gson = createGsonInstance();

    // Create sites from json string
    SiteInfo siteInfo = gson.fromJson(json, SiteInfo.class);

    // Get list of sites from the siteInfo object
    List<Site> sites = siteInfo.getListOfSites();

    System.out.println("Number of sites found: " + sites.size());
    this.listOfSites = sites;
  }


  /**
   * Creates and returns GSON object with the SiteDeseraliser which defines
   * how to deseerialise the response into a Java Object
   *
   * @return gson instance
   */
  private Gson createGsonInstance(){
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Site.class, new SiteDeseraliser());
    Gson gson = gsonBuilder.create();
    return gson;
  }

  /**
   * Gets list of sites
   * @return list of sites
   */
  public List<Site> getListOfSites(){
    return this.listOfSites;
  }
}
