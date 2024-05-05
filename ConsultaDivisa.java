import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ConsultaDivisa {
    public Divisa buscaDivisa() {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/04a91cbef851de9d13c8c464/latest/USD");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(request.getInputStream()));
            JsonObject jsonobj = root.getAsJsonObject();

            String baseCode = jsonobj.get("base_code").getAsString();
            JsonObject conversionRatesJson = jsonobj.getAsJsonObject("conversion_rates");
            Map<String, Double> conversionRates = new HashMap<>();
            for (Map.Entry<String, JsonElement> entry : conversionRatesJson.entrySet()) {
                String currencyCode = entry.getKey();
                double rate = entry.getValue().getAsDouble();
                conversionRates.put(currencyCode, rate);
            }
            return new Divisa(baseCode, conversionRates);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
    /*Divisa buscaDivisa(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/04a91cbef851de9d13c8c464/latest/USD"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Divisa.class);
    }*/


