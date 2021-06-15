package com.cursera.data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.util.List;

public class ToJson{
  public static void jsonFile(List list){
    // Convert list to Json
    JsonArray jsonArray = new Gson().toJsonTree(list).getAsJsonArray();
    // Show json file as a string
    System.out.println(jsonArray.toString());
  }
}
