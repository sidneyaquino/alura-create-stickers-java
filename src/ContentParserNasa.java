import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentParserNasa implements ContentParser{
   public List<Content> Parse(String json){
      List<Content> contents = new ArrayList<>();

      // JsonParser parser = new JsonParserRegex();  
      JsonParser parser = new JsonParserJackson();
      List<Map<String, String>> list = parser.parse(json);

      for (Map<String,String> item : list) {
         var content = new Content(
            item.get("title"), 
            item.get("url")
         );
         contents.add(content);         
      }
      return contents;
   }
}