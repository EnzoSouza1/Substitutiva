package apijava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteAPI {

    public String obterDadosClimaticos(double latitude, double longitude) throws Exception {
        latitude = corrigirFormato(latitude);
        longitude = corrigirFormato(longitude);

        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature_2m&start_date=2024-04-01&end_date=2024-04-30&timezone=America/Sao_Paulo";


        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            resposta.append(inputLine);
        }
        in.close();

        return resposta.toString();
    }

    private double corrigirFormato(double valor) {
        String valorString = String.valueOf(valor);
        if (valorString.contains(",")) {
            valorString = valorString.replace(",", ".");
        }
        return Double.parseDouble(valorString);
    }
}
