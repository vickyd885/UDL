
import java.util.LinkedList;


import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// This class should be the entry point for the ETL process
public class Execute{

  private final static String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Information/MonitoringSites/GroupName=London/Json";


  public static void main(String[] args) {

    try {
      getSiteInformation();
    }catch(Exception e){
      //
    }

  }

  // returns all the sites as a linked list
  private static void getSiteInformation() throws IOException{
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
    .url(API_URL_ENTRY)
    .build();

    Response response = client.newCall(request).execute();

    String ans = response.body().string();
    System.out.println(ans);

  }
}
