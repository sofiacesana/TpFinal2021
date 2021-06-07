import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class ToJson<T> {
  // Create a generic List
  List<T> list = new ArrayList<T>();
  // Convert list to Json
  JsonArray jsonArray = new Gson().toJsonTree(list).getAsJsonArray();

  public static void main(JsonArray jsonArray)throws Exception {
    // Show json file as a string
    System.out.println(jsonArray.toString());
  }
}
