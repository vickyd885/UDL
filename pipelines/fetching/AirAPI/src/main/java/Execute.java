
import java.util.LinkedList;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;

// This class should be the entry point for the ETL process
public class Execute{

  private final String API_URL_ENTRY = "http://api.erg.kcl.ac.uk/AirQuality/Information/MonitoringSites/GroupName=London/Json";


  public static void main(String[] args) {

  }

  // returns all the sites as a linked list
  private LinkedList<Site> getSiteInformation(){

    HttpClient client = new HttpClient();
    GetMethod method = new GetMethod(API_URL_ENTRY);

  }
}
