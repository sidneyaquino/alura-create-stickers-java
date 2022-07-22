import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {
        
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://api.mocki.io/v2/549a5d8b";
        var uri = URI.create(url);
        var request = HttpRequest.newBuilder(uri).GET().build();
        var client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        // System.out.println(body);

        var parser = new JsonParser();
        List<Map<String, String>> movies = parser.parse(body);
        // System.out.println(movies.size());

        System.out.println();
        for (Map<String,String> movie : movies) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }
    }
}      