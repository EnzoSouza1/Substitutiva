package apijava;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class AnaliseDadosClimaticos {

    private final String jsonString;
    private final String capital;

    public AnaliseDadosClimaticos(String jsonString, String capital) {
        this.jsonString = jsonString;
        this.capital = capital;
    }

    private List<Object[]> agruparDadosPorDia() {
        List<Object[]> resultado = new ArrayList<>();
        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            JSONObject hourly = jsonObj.getJSONObject("hourly");
            JSONArray tempos = hourly.getJSONArray("time");
            JSONArray temperaturas = hourly.getJSONArray("temperature_2m");

            TreeMap<String, List<Double>> agrupamentoPorDia = new TreeMap<>();

            for (int i = 0; i < tempos.length(); i++) {
                String tempoCompleto = tempos.getString(i);
                double temperatura = temperaturas.getDouble(i);
                String dia = tempoCompleto.split("T")[0];
                agrupamentoPorDia.computeIfAbsent(dia, k -> new ArrayList<>()).add(temperatura);
            }

            for (Map.Entry<String, List<Double>> entrada : agrupamentoPorDia.entrySet()) {
                resultado.add(new Object[]{entrada.getKey(), entrada.getValue()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void exibirEstatisticasDiarias() {
        List<Object[]> dadosAgrupados = agruparDadosPorDia();
        System.out.println(capital);
        for (Object[] diaTemperaturas : dadosAgrupados) {
            String dia = (String) diaTemperaturas[0];
            List<Double> temperaturas = (List<Double>) diaTemperaturas[1];

            double max = Collections.max(temperaturas);
            double min = Collections.min(temperaturas);
            double media = temperaturas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            System.out.printf("Dia: %s, Máxima: %.2f, Mínima: %.2f, Média: %.2f%n", dia, max, min, media);
        }
    }
}
