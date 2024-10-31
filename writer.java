import java.util.Random;

public class writer extends Thread {
    private Random random; //para auxiliar nos acessos à posições aleatórias enquanto a thread estiver rodando
    public writer(){
        this.random = new Random();
    }
    @Override
    public void run() {
        int posicao;
        for (int i = 0; i < 100; i++) {
            // gera um índice aleatório entre 0 e tamanho da base - 1 (esse indice será aquele a ser acessado)
            posicao = random.nextInt(leitor.listaPalavras.length);
            try {
                leitor.listaPalavras[posicao] = "MODIFICADO";
            } catch (InterruptedException e) {
                //nao sei ainda como lidar com o catch....
            }
        }
        //POE P SLEEP
    }
}
