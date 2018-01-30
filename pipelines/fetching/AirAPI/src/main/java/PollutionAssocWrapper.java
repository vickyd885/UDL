import java.util.HashMap;

public class PollutionAssocWrapper{

  private HashMap<String, PollutionInfo> airPollutionHMap;

  public PollutionAssocWrapper(){
    this.airPollutionHMap = new HashMap<String, PollutionInfo>();
  }

  public void add(String siteCode, PollutionInfo pInfo){
    this.airPollutionHMap.put(siteCode, pInfo);
  }

  public void clean(){
    this.airPollutionHMap.clear();
  }
}
