import java.util.List;
import java.util.Map;

public interface JsonParser {
   public List<Map<String, String>> parse(String json);
}
