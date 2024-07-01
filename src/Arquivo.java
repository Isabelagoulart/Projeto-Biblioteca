import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {
//dois metodos ler o arquivo e pra escrever o arquivo / ler o arquivo através de quebra de linha 
    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
//pega o arquivo que quer escrever e coloca o conteudo que quer passar. true serve pra poder ir escrevendo nas linhas vazias e não escrever em cima do que já havia digitado
    public static void escritor(String path, String content) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
        buffWrite.append(content).append("\n");
        buffWrite.close();
    }

}
