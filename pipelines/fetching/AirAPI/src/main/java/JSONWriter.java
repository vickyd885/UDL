/*
* FileWriter writes the json object to file
* the hardcoded file location is "/output"
*/

import java.io.FileWriter;
import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriter{

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
