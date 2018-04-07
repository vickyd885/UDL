import java.util.List;

/**
 * SiteInfo abstracts SiteSchema and Site
 * This exists to deal with the nasty JSON structure of the JSON String
 */
public class SiteInfo {
  private SitesSchema Sites;

  public List<Site> getListOfSites(){
    return Sites.getList();
  }
}


/**
 * Contains a list of sites and provides an getter to that list of sites
 */
class SitesSchema{
  private List<Site> Site;
  public List<Site> getList(){
    return Site;
  }
}

/**
 * Site object maintains site data and provides setters/getters to manipulate
 * this data. This object is the most verbose representation of the API
 * endpoint
 */
class Site{

  private String DataManager;
  private String DataOwner;
  private String DateClosed;
  private String DateOpened;
  private String DisplayOffsetX;
  private String DisplayOffsetY;
  private String Latitude;
  private String LatitudeWGS84;
  private String LocalAuthorityCode;
  private String LocalAuthorityName;
  private String Longitude;
  private String LongitudeWGS84;
  private String SiteCode;
  private String SiteLink;
  private String SiteName;
  private String SiteType;

  /**
   * Defines how to print the object
   * @return [description]
   */
  @Override
  public String toString(){
    return SiteCode;
  }

	/**
	* Returns value of DataManager
	* @return
	*/
	public String getDataManager() {
		return DataManager;
	}

	/**
	* Sets new value of DataManager
	* @param
	*/
	public void setDataManager(String DataManager) {
		this.DataManager = DataManager;
	}

	/**
	* Returns value of DataOwner
	* @return
	*/
	public String getDataOwner() {
		return DataOwner;
	}

	/**
	* Sets new value of DataOwner
	* @param
	*/
	public void setDataOwner(String DataOwner) {
		this.DataOwner = DataOwner;
	}

	/**
	* Returns value of DateClosed
	* @return
	*/
	public String getDateClosed() {
		return DateClosed;
	}

	/**
	* Sets new value of DateClosed
	* @param
	*/
	public void setDateClosed(String DateClosed) {
		this.DateClosed = DateClosed;
	}

	/**
	* Returns value of DateOpened
	* @return
	*/
	public String getDateOpened() {
		return DateOpened;
	}

	/**
	* Sets new value of DateOpened
	* @param
	*/
	public void setDateOpened(String DateOpened) {
		this.DateOpened = DateOpened;
	}

	/**
	* Returns value of DisplayOffsetX
	* @return
	*/
	public String getDisplayOffsetX() {
		return DisplayOffsetX;
	}

	/**
	* Sets new value of DisplayOffsetX
	* @param
	*/
	public void setDisplayOffsetX(String DisplayOffsetX) {
		this.DisplayOffsetX = DisplayOffsetX;
	}

	/**
	* Returns value of DisplayOffsetY
	* @return
	*/
	public String getDisplayOffsetY() {
		return DisplayOffsetY;
	}

	/**
	* Sets new value of DisplayOffsetY
	* @param
	*/
	public void setDisplayOffsetY(String DisplayOffsetY) {
		this.DisplayOffsetY = DisplayOffsetY;
	}

	/**
	* Returns value of Latitude
	* @return
	*/
	public String getLatitude() {
		return Latitude;
	}

	/**
	* Sets new value of Latitude
	* @param
	*/
	public void setLatitude(String Latitude) {
		this.Latitude = Latitude;
	}

	/**
	* Returns value of LatitudeWGS84
	* @return
	*/
	public String getLatitudeWGS84() {
		return LatitudeWGS84;
	}

	/**
	* Sets new value of LatitudeWGS84
	* @param
	*/
	public void setLatitudeWGS84(String LatitudeWGS84) {
		this.LatitudeWGS84 = LatitudeWGS84;
	}

	/**
	* Returns value of LocalAuthorityCode
	* @return
	*/
	public String getLocalAuthorityCode() {
		return LocalAuthorityCode;
	}

	/**
	* Sets new value of LocalAuthorityCode
	* @param
	*/
	public void setLocalAuthorityCode(String LocalAuthorityCode) {
		this.LocalAuthorityCode = LocalAuthorityCode;
	}

	/**
	* Returns value of LocalAuthorityName
	* @return
	*/
	public String getLocalAuthorityName() {
		return LocalAuthorityName;
	}

	/**
	* Sets new value of LocalAuthorityName
	* @param
	*/
	public void setLocalAuthorityName(String LocalAuthorityName) {
		this.LocalAuthorityName = LocalAuthorityName;
	}

	/**
	* Returns value of Longitude
	* @return
	*/
	public String getLongitude() {
		return Longitude;
	}

	/**
	* Sets new value of Longitude
	* @param
	*/
	public void setLongitude(String Longitude) {
		this.Longitude = Longitude;
	}

	/**
	* Returns value of LongitudeWGS84
	* @return
	*/
	public String getLongitudeWGS84() {
		return LongitudeWGS84;
	}

	/**
	* Sets new value of LongitudeWGS84
	* @param
	*/
	public void setLongitudeWGS84(String LongitudeWGS84) {
		this.LongitudeWGS84 = LongitudeWGS84;
	}

	/**
	* Returns value of SiteCode
	* @return
	*/
	public String getSiteCode() {
		return SiteCode;
	}

	/**
	* Sets new value of SiteCode
	* @param
	*/
	public void setSiteCode(String SiteCode) {
		this.SiteCode = SiteCode;
	}

	/**
	* Returns value of SiteLink
	* @return
	*/
	public String getSiteLink() {
		return SiteLink;
	}

	/**
	* Sets new value of SiteLink
	* @param
	*/
	public void setSiteLink(String SiteLink) {
		this.SiteLink = SiteLink;
	}

	/**
	* Returns value of SiteName
	* @return
	*/
	public String getSiteName() {
		return SiteName;
	}

	/**
	* Sets new value of SiteName
	* @param
	*/
	public void setSiteName(String SiteName) {
		this.SiteName = SiteName;
	}

	/**
	* Returns value of SiteType
	* @return
	*/
	public String getSiteType() {
		return SiteType;
	}

	/**
	* Sets new value of SiteType
	* @param
	*/
	public void setSiteType(String SiteType) {
		this.SiteType = SiteType;
	}
}
