import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientBody {
   public String get(String url){
      try {
         var uri = URI.create(url);
         var request = HttpRequest.newBuilder(uri).GET().build();
         var client = HttpClient.newHttpClient();
         HttpResponse<String> response;
         response = client.send(request, BodyHandlers.ofString());

         return response.body();
         
      } catch (IOException | InterruptedException e) {
         throw new RuntimeException(e);
      }
   } 
}