public class testeLeitoresEscritores {
    public static void main(String[] args) {
        // inicializa a base de dados com o arquivo bd.txt
        BD bd = new BD("bd.txt");

        // verifica se o arquivo foi carregado corretamente
        if (BD.listaPalavras == null || BD.listaPalavras.length == 0) {
            System.err.println("Erro: a base de dados não foi carregada. Verifique o arquivo bd.txt.");
            return; // interrompe a execução se não houver dados
        }

        // para cada proporção de leitores (de 0 a 100), executa o sistema 50 vezes
        for (int propLeitores = 0; propLeitores <= 100; propLeitores++) {
            long somaTempos = 0;

            // Executa o sistema 50 vezes para cada proporção e acumula o tempo total
            for (int i = 0; i < 50; i++) {
                listaThreads lista = new listaThreads(propLeitores);
                somaTempos += lista.executarThreads();
            }

            // calcula o tempo médio para a proporção atual de leitores
            long tempoMedio = somaTempos / 50;
            System.out.println("Proporção de leitores: " + propLeitores + "% - Tempo médio: " + tempoMedio + " ms");
        }
    }
}
