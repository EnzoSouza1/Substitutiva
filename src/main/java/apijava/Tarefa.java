package apijava;

import java.util.List;

public class Tarefa implements Runnable {
    private final List<String[]> coordenadas;

    public Tarefa(List<String[]> coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public void run() {
        ClienteAPI clienteAPI = new ClienteAPI();
        for (String[] coordenada : coordenadas) {
            double latitude = Double.parseDouble(coordenada[1]);
            double longitude = Double.parseDouble(coordenada[2]);

            try {
                String dadosClimaticos = clienteAPI.obterDadosClimaticos(latitude, longitude);
                AnaliseDadosClimaticos analise = new AnaliseDadosClimaticos(dadosClimaticos, coordenada[0]);
                analise.exibirEstatisticasDiarias();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
