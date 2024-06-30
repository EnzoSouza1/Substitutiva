package apijava;

public class Main {

    public static void main(String[] args) {

        long incio = System.nanoTime();
        int numeroDeThreads = 9; //adicionar o numero de threads
        int capitaisPorThread = 3; //adicionar o numero capitais por threads
        threadExecutar executor = new threadExecutar(numeroDeThreads, capitaisPorThread);
        try {
            executor.executar();
        } catch (Exception e) {

            System.err.println("Erro ao executar o processo: " + e.getMessage());
            e.printStackTrace();
        }
        long fim = System.nanoTime();
        long tempo = fim - incio;
        System.out.println("O tempo total de duração foi de: " + tempo);
    }
}