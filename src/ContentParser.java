import java.util.List;

public interface ContentParser {
   public List<Content> Parse(String json);
}