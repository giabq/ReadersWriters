import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listaThreads {
    public List <Thread> threads;
    public listaThreads(int propR){ //propR define quantos Readers serão criados e com isso quantos Writers também!
        threads = new ArrayList<>();
        int i;
        for(i=0; i<propR ; i++){
            threads.add(new Thread(new reader())); //instanciamos propRs readers
        }
        for(; i<100; i++){ //usando de onde i parou para continuar instanciando threads para os writers!
            threads.add(new Thread(new writer())); //instanciamos 100-propRs writers
        }
        Collections.shuffle(threads); //embaralhando os objetos instanciados
    }
    //método que gerencia a execução sequencial das threads
    public long executarThreads() {
        long startTime = System.currentTimeMillis(); // marca o início do tempo

        // inicia todas as threads (em paralelo)
        for(Thread thread: threads){
            thread.start();
        }

        // aguarda todas as threads terminarem
        for(Thread thread: threads){
            try{
                thread.join(); // isso faz com que o programa aguarda a conclusão de cada thread antes de continuar
            } catch(Exception e){
                Thread.currentThread().interrupt();
            }
        }
         long endTime = System.currentTimeMillis(); // marca o fim do tempo
         return endTime - startTime; // retorna o tempo total de execução
    }
}