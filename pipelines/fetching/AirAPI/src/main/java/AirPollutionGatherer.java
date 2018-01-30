// based on the sites, find all the air pollution data
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class AirPollutionGatherer{

  private String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Annual/MonitoringReport/";

  private String BASE_DIRECTORY;

  private Gson gson;

  private PollutionAssocWrapper pWrapper;

  private List<String> years;

  public AirPollutionGatherer(String base_dir){
    this.BASE_DIRECTORY = base_dir;
    this.pWrapper = new PollutionAssocWrapper();
    this.gson = createGsonInstance();
    this.years = createListOfYears();
  }

  public void start(List<Site> sites){
    int i = 0;
    for(String year : this.years){

      for(Site site : sites){
        try{
          query(site.getSiteCode(), "2015");
        }catch(Exception e){

        }finally{
          i++;
          if(i > 2) break;
        }
      }
      save(getFileWritePath(year));
      this.pWrapper.clean();
    }


  }


  public void query(String siteCode, String year) throws IOException{

    String final_url = API_URL_ENTRY + "SiteCode=" + siteCode + "/Year=" + year;
    final_url += "/Json";

    System.out.println("Querying: "+final_url);
    OkHttpClient client = new OkHttpClient();
    Request request = new Request
    .Builder()
    .url(final_url)
    .build();

    Response response = client.newCall(request).execute();
    String responseAsString = response.body().string();

    handleResponse(responseAsString, siteCode);
  }

  private void handleResponse(String response, String siteCode){
    //System.out.println(response);
    if(response.equals("{\"SiteReport\":null}")) return;

    PollutionInfo pollutionInfo = this.gson.fromJson(response, PollutionInfo.class);
    this.pWrapper.add(siteCode, pollutionInfo);
  }

  private Gson createGsonInstance(){
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(PollutionItem.class, new PollutionItemDeserialiser());
    Gson gson = gsonBuilder.create();
    return gson;
  }

  public List<String> createListOfYears(){
    List<String> years = new LinkedList<String>();
    years.add("2014");
    years.add("2015");
    return years;
  }

  private String getFileWritePath(String year){
    return this.BASE_DIRECTORY + "/" + year + "/AirPollutionData.json";
  }

  private void save(String path){
    String data = this.gson.toJson(this.pWrapper, PollutionAssocWrapper.class);
    System.out.println("saved data" + data);
    JSONWriter.writeToJsonFile(data, path);
  }


}
