import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    static String[] listaPalavras;
    public BD(String path){
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
    }
}
