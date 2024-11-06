public class fullBlockController extends controller {
    private boolean acessoAtivo = false; // indica se existe algum acesso ativo

    public synchronized void entrarLeitura(){
        while (acessoAtivo) { // espera se houver um escritor ativo
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        acessoAtivo = true;
    }
    public synchronized void sairLeitura() {
        acessoAtivo = false;
        notifyAll(); // notifica possíveis escritores que estão esperando
    }
    public synchronized void entrarEscrita() {
        while (acessoAtivo) { // espera se houver um escritor ativo
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        acessoAtivo = true;
    }
    public synchronized void sairEscrita() {
        acessoAtivo = false;
        notifyAll(); // notifica possíveis escritores que estão esperando
    }
}
