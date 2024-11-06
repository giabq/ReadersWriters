// Solução baseada nos códigos disponíveis em: https://stackoverflow.com/questions/6531163/the-readers-writers-problem-priority

public class leitoresEscritoresController extends controller {
    private int leitoresAtivos = 0; // contador de leitores ativos
    private boolean escritorAtivo = false; // indica se existe algum escritor ativo

    // método para leitores entrarem na região crítica com prioridade
    public synchronized void entrarLeitura() {
        while (escritorAtivo) { // espera se houver um escritor ativo
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        leitoresAtivos++;
    }

    // método para leitores saírem da região crítica
    public synchronized void sairLeitura() {
        leitoresAtivos--;
        if (leitoresAtivos == 0) {
            notifyAll(); // notifica possíveis escritores que estão esperando
        }
    }

    // Método para escritores entrarem na região crítica com espera por leitores
    public synchronized void entrarEscrita() {
        while (leitoresAtivos > 0 || escritorAtivo) { // espera se há leitores ou outro escritor
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        escritorAtivo = true; // marca que há um escritor ativo
    }

    // método para escritores saírem da região crítica
    public synchronized void sairEscrita() {
        escritorAtivo = false; // marca que não há mais escritor ativo
        notifyAll(); // notifica leitores e escritores que estão esperando
    }
}
