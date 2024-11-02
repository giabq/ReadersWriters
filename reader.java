import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class reader extends Thread {
    private String palavra;
    private Random random;
    private Set<Integer> indicesLidos;

    public reader() {
        this.random = new Random();
        this.indicesLidos = new HashSet<>();
    }

    @Override
    public void run() {
        BD.controlador.entrarLeitura(); // entra na região crítica para leitura
        try {
            for (int i = 0; i < 100; i++) {
                int posicao = random.nextInt(BD.listaPalavras.length);
                while (indicesLidos.contains(posicao)) {
                    posicao = random.nextInt(BD.listaPalavras.length);
                }
                palavra = BD.listaPalavras[posicao];
                indicesLidos.add(posicao);
            }
            // dorme por 1ms após as 100 operações de leitura
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            BD.controlador.sairLeitura(); // sai da região crítica
        }
    }
}
