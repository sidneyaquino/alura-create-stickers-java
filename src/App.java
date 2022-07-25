import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        
        // IMDB
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        // String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        // ContentParser parser = new ContentParserIMDB();        

        // NASA
        // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        ContentParser parser = new ContentParserNasa();

        var body = new HttpClientBody();
        String json = body.get(url); 
        System.out.println(json);

        List<Content> contents = parser.Parse(json);
        System.out.println(contents.size());

        var sticker = new StickerGenarator();
        for (Content content : contents) {
            System.out.println(content.getTitle());

            sticker.create(new URL(content.getUrlImage()).openStream(), "TOPZERA!!!", content.getTitle());
        }
    }
}