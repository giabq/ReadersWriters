import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    static String[] listaPalavras;
    // Vamos adicionar uma instância do leitoresEscritoresControlador para que reader e writer possam acessar a base de dados
    static controller controlador;

    public BD(String path, int controllerType){
        List <String> linhas = new ArrayList<>(); //criando o String[] de forma genérica para usar as funcionalidades de util.List
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = reader.readLine()) != null) { //readline "quebra" ao encontrar um \n. quando o arquivo chegar ao fim, será lido 'null'
                linhas.add(linha); // Adiciona cada linha lida com sucesso ao arranjo
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        // Convertendo o ArrayList (de tipo genérico) para um array de Strings efetivamente para auxiliar em manipulações futuras
        listaPalavras = linhas.toArray(new String[0]);

        if(controllerType == 1){
            controlador = new leitoresEscritoresController();
        } else if(controllerType == 0){
            controlador = new fullBlockController();
        }
    }
}
