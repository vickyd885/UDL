// Networking libaries
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// Data Structures
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

// JSON library
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Given a list of site codes, it queries for AirPollution data from the API
 * This data is then represented as a HashMap and written to a json file
 */
public class AirPollutionGatherer{

  // API endpoint URL
  private String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Annual/MonitoringReport/";

  // File data
  private String BASE_DIRECTORY;
  private String FILE_NAME = "airpollution.json";

  private Gson gson;

  // Parent class for json data
  private PollutionAssocWrapper pWrapper;

  // List of years to query over (user defined)
  private List<String> years;

  /**
   * AirPollutionGatherer Constructor
   * @param base_dir requires the directory for the files to be saved
   */
  public AirPollutionGatherer(String base_dir){
    this.BASE_DIRECTORY = base_dir;
    this.pWrapper = new PollutionAssocWrapper();
    this.gson = createGsonInstance();
    this.years = createListOfYears();
  }


  /**
   * Given a list of sites (from SiteGatherer), it begins querying the API
   * for those site codes. The actual querying implmentation is found in
   * query(). Querying happens for every site code, every year that is defined.
   *
   * At the end, the data is aved
   * @param sites A list of sites from SiteGatherer
   */
  public void start(List<Site> sites){
    int i = 0;
    for(String year : this.years){
      for(Site site : sites){
        try{
          query(site, year);
          System.out.println("Searching for " + site + " and year: " + year);
        }catch(Exception e){
          System.out.println("Error querying site");

        }finally{
          i++;
          // uncomment for debugging purposes
          //if(i > 2) break;
        }
      }

      save(getFileWritePath(year));
      this.pWrapper.clean(); // deletes all entries in the hashmap
    }
  }


  /**
   * Given a site and a year, the AirPollution API is queried
   * @param  site        Site
   * @param  year        Year as string
   * @throws IOException Exception on any error
   */
  public void query(Site site, String year) throws IOException{

    String siteCode = site.getSiteCode();

    // Construct the final URL endpoint
    String final_url = API_URL_ENTRY + "SiteCode=" + siteCode + "/Year=" + year;
    final_url += "/Json";

    System.out.println("Querying: "+final_url);

    // Create HTTP client and build request
    OkHttpClient client = new OkHttpClient();
    Request request = new Request
    .Builder()
    .url(final_url)
    .build();

    Response response = client.newCall(request).execute();
    String responseAsString = response.body().string();

    // Handles from the URL endpoint
    handleResponse(responseAsString, site);
  }

  /**
   * Handles the response from the API call. This goes onto save this data
   * to a hashmap once it has been deserialised
   * @param response [description]
   * @param site     [description]
   */
  private void handleResponse(String response, Site site){
    //System.out.println(response);
    if(response.equals("{\"SiteReport\":null}")) return;

    String siteCode = site.getSiteCode();

    // deserialize response
    PollutionInfo pollutionInfo = this.gson.fromJson(response, PollutionInfo.class);

    // We save long/Latitude from the original site object
    pollutionInfo.getSiteReport().setLatitude(site.getLatitude());
    pollutionInfo.getSiteReport().setLongitgude(site.getLongitude());

    this.pWrapper.add(siteCode, pollutionInfo);
  }


  /**
   * Creates a GSON instance with Pollution PollutionItemDeserialiser
   * @return GSON instance
   */
  private Gson createGsonInstance(){
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(PollutionItem.class, new PollutionItemDeserialiser());
    Gson gson = gsonBuilder.create();
    return gson;
  }

  /**
   * Creates list of years to query
   * @return list of years to query
   */
  public List<String> createListOfYears(){
    List<String> years = new LinkedList<String>();
    //years.add("2014");
    years.add("2015");
    return years;
  }

  /**
   * Constructs and returns the file writing path
   * @param  year year as a string
   * @return final endpoint
   */
  private String getFileWritePath(String year){
    return this.BASE_DIRECTORY + "/" + year;
  }

  /**
   * Saves data to file given to path
   * @param path location to save file
   */
  private void save(String path){
    String data = this.gson.toJson(this.pWrapper, PollutionAssocWrapper.class);
    System.out.println("saving to " + path);
    JSONWriter.writeToJsonFile(data, path, this.FILE_NAME);
  }

}
