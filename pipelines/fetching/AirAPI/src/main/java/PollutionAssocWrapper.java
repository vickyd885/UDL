import java.util.HashMap;
/**
 * PollutionAssocWrapper contains a HashMap which is populated with
 * the API endpoints
 *
 */
public class PollutionAssocWrapper{

  // the hashmap to contain all airpollution data
  private HashMap<String, PollutionInfo> airPollutionHMap;

  /**
   * PollutionAssocWrapper Constructor
   */
  public PollutionAssocWrapper(){
    this.airPollutionHMap = new HashMap<String, PollutionInfo>();
  }

  /**
   * Adds entries to the hashmap given some sitecode and polution info for that
   * site code
   * @param siteCode siteCode as determined by the AirPollution api
   * @param pInfo    PollutionInfo
   */
  public void add(String siteCode, PollutionInfo pInfo){
    this.airPollutionHMap.put(siteCode, pInfo);
  }

  /**
   * Clears all entries from the HashMap for the next entry
   */
  public void clean(){
    this.airPollutionHMap.clear();
  }
}
