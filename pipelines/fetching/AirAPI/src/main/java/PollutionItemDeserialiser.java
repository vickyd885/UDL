import java.lang.reflect.Type;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;


public class PollutionItemDeserialiser implements JsonDeserializer<PollutionItem> {

  @Override
  public PollutionItem deserialize(final JsonElement json,
                          final Type typeOfT,
                          final JsonDeserializationContext context)
      throws JsonParseException
  {


    final JsonObject jsonObject = json.getAsJsonObject();

    final String SpeciesCode = jsonObject.get("@SpeciesCode").getAsString();
    final String ReportItem = jsonObject.get("@ReportItem").getAsString();
    final String ReportItemName = jsonObject.get("@ReportItemName").getAsString();
    final String Month1 = jsonObject.get("@Month1").getAsString();
    final String Month2 = jsonObject.get("@Month2").getAsString();
    final String Month3 = jsonObject.get("@Month3").getAsString();
    final String Month4 = jsonObject.get("@Month4").getAsString();
    final String Month5 = jsonObject.get("@Month5").getAsString();
    final String Month6 = jsonObject.get("@Month6").getAsString();
    final String Month7 = jsonObject.get("@Month7").getAsString();
    final String Month8 = jsonObject.get("@Month8").getAsString();
    final String Month9 = jsonObject.get("@Month9").getAsString();
    final String Month10 = jsonObject.get("@Month10").getAsString();
    final String Month11 = jsonObject.get("@Month11").getAsString();
    final String Month12 = jsonObject.get("@Month12").getAsString();
    final String Annual = jsonObject.get("@Annual").getAsString();

    final PollutionItem pollutionItem = new PollutionItem();

    pollutionItem.setSpeciesCode(SpeciesCode);
    pollutionItem.setReportItem(ReportItem);
    pollutionItem.setReportItemName(ReportItemName);
    pollutionItem.setMonth1(Month1);
    pollutionItem.setMonth2(Month2);
    pollutionItem.setMonth3(Month3);
    pollutionItem.setMonth4(Month4);
    pollutionItem.setMonth5(Month5);
    pollutionItem.setMonth6(Month6);
    pollutionItem.setMonth7(Month7);
    pollutionItem.setMonth8(Month8);
    pollutionItem.setMonth9(Month9);
    pollutionItem.setMonth10(Month10);
    pollutionItem.setMonth11(Month11);
    pollutionItem.setMonth12(Month12);
    pollutionItem.setAnnual(Annual);

    return pollutionItem;
  }
}
