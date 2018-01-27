
import java.util.LinkedList;




// This class should be the entry point for the ETL process
public class Execute{

  public static void main(String[] args) {

    SiteGatherer s = new SiteGatherer();
    s.query();

    System.out.println(s.getListOfSites().size());

    AirPollutionGatherer apg = new AirPollutionGatherer();

    apg.start(s.getListOfSites());
  }

  // returns all the sites as a linked list
}
