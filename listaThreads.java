import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listaThreads {
    public List <Thread> threads = new ArrayList<>();
    public listaThreads(int propR){ //propR define quantos Readers serão criados e com isso quantos Writers também!
        int i;
        for(i=0; i<propR ; i++){
            threads.add(new Thread(new reader())); //instanciamos propRs readers
        }
        for(; i<100; i++){ //usando de onde i parou para continuar instanciando threads para os writers!
            threads.add(new Thread(new writer())); //instanciamos 100-propRs writers
        }
        Collections.shuffle(threads); //embaralhando os objetos instanciados
    }
}
