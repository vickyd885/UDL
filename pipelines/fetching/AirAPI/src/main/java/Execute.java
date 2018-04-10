import java.util.LinkedList;

/*
* Execute is the entry point for this Java package and initialises classes
* that will handle the API querying
*
*
* @author Vicky Dineshchandra
*/
public class Execute{

  /**
   * Main method initialises the SiteGatherer object to gather the list
   * of sites. This list of sites is then used to gather air pollution data
   * through the AirPollutionGatherer object
   *
   * @param args Any arguments passed into the program through STDIN
   */
  public static void main(String[] args) {

    SiteGatherer s = new SiteGatherer();
    s.query();

    System.out.println(s.getListOfSites().size());

    AirPollutionGatherer apg = new AirPollutionGatherer("output");

    apg.start(s.getListOfSites());
  }

}
