import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SiteGatherer{


  private final String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Information/MonitoringSites/GroupName=London/Json";

  private List<Site> listOfSites;

  public SiteGatherer(){
    this.listOfSites = null;
  }
  public void query(){

    try{

      System.out.println("here");

      OkHttpClient client = new OkHttpClient();

      Request request = new Request.Builder()
      .url(API_URL_ENTRY)
      .build();

      Response response = client.newCall(request).execute();

      String responseAsString = response.body().string();
      //System.out.println(responseAsString);

      handleResponse(responseAsString);

    }catch(Exception e){

    }finally{

    }
  }



  private void handleResponse(String json){

    Gson gson = createGsonInstance();


    SiteInfo siteInfo = gson.fromJson(json, SiteInfo.class);

    List<Site> sites = siteInfo.getListOfSites();

    System.out.println("Number of sites found: " + sites.size());

    this.listOfSites = sites;
  }



  private Gson createGsonInstance(){
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Site.class, new SiteDeseraliser());
    Gson gson = gsonBuilder.create();
    return gson;
  }


  public List<Site> getListOfSites(){
    return this.listOfSites;
  }

}
