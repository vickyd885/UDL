// based on the sites, find all the air pollution data
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AirPollutionGatherer{

  private String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Annual/MonitoringReport/";



  public void start(List<Site> sites){
    for(Site s : sites){

      try{
        query(s.getSiteCode(), "2015");
      }catch(Exception e){

      }finally{

      }

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

    handleResponse(responseAsString);
  }


  private void handleResponse(String response){

    System.out.println(response);
    if(response.equals("{\"SiteReport\":null}")) return;

    Gson gson = createGsonInstance();

    PollutionInfo pollutionInfo = gson.fromJson(response, PollutionInfo.class);

    System.out.println(pollutionInfo);

    List<PollutionItem> plist = pollutionInfo.getList();

    System.out.println(plist.size());
  }

  private Gson createGsonInstance(){
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(PollutionItem.class, new PollutionItemDeserialiser());
    Gson gson = gsonBuilder.create();
    return gson;
  }


}
