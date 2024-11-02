import java.util.Random;

public class writer extends Thread {
    private Random random;

    public writer() {
        this.random = new Random();
    }

    @Override
    public void run() {
        BD.controlador.entrarEscrita(); // entra na região crítica para escrita
        try {
            for (int i = 0; i < 100; i++) {
                int posicao = random.nextInt(BD.listaPalavras.length);
                BD.listaPalavras[posicao] = "MODIFICADO";
            }
            // dorme por 1ms após as 100 operações de escrita
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            BD.controlador.sairEscrita(); // sai da região crítica
        }
    }
}
