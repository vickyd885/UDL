import java.io.FileWriter;
import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
* JSONWriter handles writing data to file
*/
public class JSONWriter{

  /**
   * Writes data to a file given a file path and a filename
   *
   * @param data     json data as a string
   * @param filePath destination file location
   * @param fileName name of file
   */
  public static void writeToJsonFile(String data, String filePath, String fileName){
    try {
      File f = new File(filePath);
      if(!f.exists()){
        f.mkdirs();
      }
      FileWriter fileWriter = new FileWriter(filePath + "/" + fileName);
      fileWriter.write(data);
      fileWriter.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
