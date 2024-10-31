import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class reader extends Thread {
    private String palavra; //string utilizada para armazenamento momentâneo da palavra lida
    private Random random; //para auxiliar nos acessos à posições aleatórias enquanto a thread estiver rodando
    private Set <Integer> indicesLidos; // Para rastrear quais índices já foram lidos, como o enunciado dita --> usando set essa checagem fica mais rápida

    public reader(){
        this.random = new Random();
        this.indicesLidos = new HashSet<>();
    }

    @Override
    public void run() {
        int posicao;
        for (int i = 0; i < 100; i++) {
            // gera um índice aleatório entre 0 e tamanho da base - 1 (esse indice será aquele a ser acessado)
            posicao = random.nextInt(BD.listaPalavras.length);
            try {
                while(indicesLidos.contains(posicao)){
                    posicao = random.nextInt(BD.listaPalavras.length); //reescolhendo uma posição para os casos em que o indice já foi acessado em uma das 100 iterações
                }
                palavra = BD.listaPalavras[posicao];
                indicesLidos.add(posicao);

            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Erro: índice fora dos limites do array.");
            } catch (NullPointerException e) {
                System.err.println("Erro: listaPalavras não foi inicializada.");
            }
        }
        //POE P SLEEP?
    }
}
