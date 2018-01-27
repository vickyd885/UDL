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

public class SiteGatherer{


  private final static String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Information/MonitoringSites/GroupName=London/Json";

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

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Site.class, new SiteDeseraliser());
    Gson gson = gsonBuilder.create();

    SiteInfo siteInfo = gson.fromJson(json, SiteInfo.class);

    System.out.println(siteInfo);

    List<Site> sites = siteInfo.getListOfSites();

    int i = 0;
    for(Site s : sites){
      System.out.println(s);
      i++;
    }
    System.out.println(i);




  }

}
