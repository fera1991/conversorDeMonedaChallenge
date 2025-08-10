import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public PeticionMoneda obtenerConversion(String base_code, String target_code, double amount){
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/c3aba8c66787bce89ce597de/pair/"+base_code+"/"+target_code+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), PeticionMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Se obtuvo un error al ejecutar la Consulta.");
        }
    }

}
