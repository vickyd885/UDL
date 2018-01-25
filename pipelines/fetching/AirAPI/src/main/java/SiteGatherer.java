import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;
import java.util.List;

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

    Gson gson = new Gson();

    Map<String, Object> jsonObject1 = gson.fromJson(json, Map.class);

    String json2 = jsonObject1.get("Sites").toString();

    //System.out.println(json2);
    List<Object> jsonObject2 = gson.fromJson(json2, List.class);

    for(Object o : jsonObject2){
      System.out.println(o);
    }

    // Map<String,Object> map = new HashMap<String,Object>();
    // map = (Map<String,Object>) gson.fromJson(json, map.getClass());



  }

}
