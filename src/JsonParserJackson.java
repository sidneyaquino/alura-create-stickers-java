import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;


public class JsonParserJackson implements JsonParser{

   public List<Map<String, String>> parse(String json){
      List<Map<String, String>> items = new ArrayList<>();
      Map<String, String> item = new HashMap<>();
      boolean startItems = false;

      try {
         JsonToken jsonToken;
         JsonFactory factory = new JsonFactory();
         com.fasterxml.jackson.core.JsonParser parser = factory.createParser(json);
         
         while(!parser.isClosed()){
            jsonToken = parser.nextToken();

            if (jsonToken != null){
               if (!startItems){
                  startItems = jsonToken.toString().equals("START_ARRAY");
               }else{              
                  switch (jsonToken.toString()) {
                     case "END_ARRAY":
                        startItems = false;
                        break;

                     case "VALUE_STRING":
                        String key = parser.getCurrentName();
                        String value = parser.getText();
                        item.put(key, value);                        
                        break;
                     
                     case "END_OBJECT":
                        items.add(item);
                        item = new HashMap<>();
                        break;
                  }
               }
            }
         }   
      } catch (IOException e) {
         e.printStackTrace();
      }
      return items;
   }
}
