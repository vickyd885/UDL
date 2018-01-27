import java.lang.reflect.Type;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


public class SiteDeseraliser implements JsonDeserializer<Site> {

  @Override
  public Site deserialize(final JsonElement json,
                          final Type typeOfT,
                          final JsonDeserializationContext context)
      throws JsonParseException
  {


    final JsonObject jsonObject = json.getAsJsonObject();

    final String DataManager = jsonObject.get("@DataManager").getAsString();
    final String DataOwner = jsonObject.get("@DataOwner").getAsString();
    final String DateClosed = jsonObject.get("@DateClosed").getAsString();
    final String DateOpened = jsonObject.get("@DateOpened").getAsString();
    final String DisplayOffsetX = jsonObject.get("@DisplayOffsetX").getAsString();
    final String DisplayOffsetY = jsonObject.get("@DisplayOffsetY").getAsString();
    final String Latitude = jsonObject.get("@Latitude").getAsString();
    final String LatitudeWGS84 = jsonObject.get("@LatitudeWGS84").getAsString();
    final String LocalAuthorityCode = jsonObject.get("@LocalAuthorityCode").getAsString();
    final String LocalAuthorityName = jsonObject.get("@LocalAuthorityName").getAsString();
    final String Longitude = jsonObject.get("@Longitude").getAsString();
    final String LongitudeWGS84 = jsonObject.get("@LongitudeWGS84").getAsString();
    final String SiteCode = jsonObject.get("@SiteCode").getAsString();
    final String SiteLink = jsonObject.get("@SiteLink").getAsString();
    final String SiteName = jsonObject.get("@SiteName").getAsString();
    final String SiteType = jsonObject.get("@SiteType").getAsString();


    final Site site = new Site();

    site.setDataManager(DataManager);
    site.setDataOwner(DataOwner);
    site.setDateClosed(DateClosed);
    site.setDateOpened(DateOpened);
    site.setDisplayOffsetX(DisplayOffsetX);
    site.setDisplayOffsetY(DisplayOffsetY);
    site.setLatitude(Latitude);
    site.setLatitudeWGS84(LatitudeWGS84);
    site.setLocalAuthorityCode(LocalAuthorityCode);
    site.setLocalAuthorityName(LocalAuthorityName);
    site.setLongitude(Longitude);
    site.setLongitudeWGS84(LongitudeWGS84);
    site.setSiteCode(SiteCode);
    site.setSiteLink(SiteLink);
    site.setSiteName(SiteName);
    site.setSiteType(SiteType);


    return site;
  }
}
