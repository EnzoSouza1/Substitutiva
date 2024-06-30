package apijava;

import java.util.ArrayList;
import java.util.List;

public class threadExecutar {

    private static final String[] DADOS_CAPITAIS = {
            "Aracaju,-10.9167,-37.05",
            "Belem,-1.4558,-48.5039",
            "Belo_Horizonte,-19.9167,-43.9333",
            "Boa_Vista,2.81972,-60.67333",
            "Brasilia,-15.7939,-47.8828",
            "Campo_Grande,-20.44278,-54.64639",
            "Cuiaba,-15.5989,-56.0949",
            "Curitiba,-25.4297,-49.2711",
            "Florianopolis,-27.5935,-48.55854",
            "Fortaleza,-3.7275,-38.5275",
            "Goiania,-16.6667,-49.25",
            "Joao Pessoa,-7.12,-34.88",
            "Macapa,0.033,-51.05",
            "Maceio,-9.66583,-35.73528",
            "Manaus,-3.1189,-60.0217",
            "Natal,-5.7833,-35.2",
            "Palmas,-10.16745,-48.32766",
            "Porto_Alegre,-30.0331,-51.23",
            "Porto_Velho,-8.76194,-63.90389",
            "Recife,-8.05,-34.9",
            "Rio_Branco,-9.97472,-67.81",
            "Rio_de_Janeiro,-22.9111,-43.2056",
            "Salvador,-12.9747,-38.4767",
            "Sao_Luis,-2.5283,-44.3044",
            "Sao_Paulo,-23.55,-46.6333",
            "Teresina,-5.08917,-42.80194",
            "Vitoria,-20.2889,-40.3083"

    };

    private final int numeroDeThreads;
    private final int capitaisPorThread;

    public threadExecutar(int numeroDeThreads, int capitaisPorThread) {
        this.numeroDeThreads = numeroDeThreads;
        this.capitaisPorThread = capitaisPorThread;
    }

    public void executar() throws Exception {
        List<String[]> coordenadas = getLatitudeLongitude();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numeroDeThreads; i++) {
            int inicio = i * capitaisPorThread;
            int fim = Math.min(inicio + capitaisPorThread, coordenadas.size());
            List<String[]> listaT = coordenadas.subList(inicio, fim);

            Thread thread = new Thread(new Tarefa(listaT));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    private List<String[]> getLatitudeLongitude() {
        List<String[]> dados = new ArrayList<>();
        for (String linha : DADOS_CAPITAIS) {
            linha = linha.trim();
            String[] partes = linha.split(",");
            String cidade = partes[0].trim();
            String latitude = partes[1].trim();
            String longitude = partes[2].trim();
            dados.add(new String[]{cidade, latitude, longitude});
        }
        return dados;
    }
}
