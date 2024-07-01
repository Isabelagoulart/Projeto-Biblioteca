import Exceptions.LeitorNaoEncontradoException;
import Exceptions.LivroNaoDisponivelException;
import Exceptions.LivroNaoEncontradoException;
import Sistema.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LeitorNaoEncontradoException, LivroNaoEncontradoException, LivroNaoDisponivelException, IOException {
        //Criando sistema da biblioteca
        Biblioteca sistema = new SistemaBiblioteca(); // aqui aplica o polimosfismo, objeto biblioteca do tipo sistema biblioteca
        Leitor leitorCadastrado;
        Livro livroPego;
        //liga scanner
        Scanner scanner; //Entrada de dados vazia
        String sair = null;

        //Carregando livros e leitores de arquivos
        Arquivo.leitor("leitores.txt");
        Arquivo.leitor("livros.txt");

        //Inicializando
        System.out.println("Entrar no sistema? (S/N)");
        scanner = new Scanner(System.in);

        //Entrando no sistema
        while (sair == null) {
            //Inicializando variáveis
            leitorCadastrado = null;
            livroPego = null;
            sair = null;

            //Cadastrando livros
            while (scanner.hasNext()) {
                System.out.println("Cadastrando livros");

                System.out.println("Digite o nome do livro: ");
                scanner = new Scanner(System.in);
                String nomeLivro = scanner.nextLine();

                System.out.println("Digite o nome do autor: ");
                scanner = new Scanner(System.in);
                String autor = scanner.nextLine();

                System.out.println("Digite a quantidade de livros: ");
                scanner = new Scanner(System.in);
                int quantidadeLivros = scanner.nextInt();

                Livro livro = new Livro(nomeLivro, autor, quantidadeLivros);
                sistema.CadastrarLivro(livro);

                //Escrevendo livro no arquivo
                Arquivo.escritor("livros.txt", (livro.nome + " - " + livro.autor));

                //Saindo do loop de livros
                System.out.println("Caso deseje sair digite 'Sair Livro' ou qualquer valor para continuar");
                scanner = new Scanner(System.in);
                sair = scanner.nextLine();
                if (sair.equals("Sair Livro")) break;
            }

            //Cadastrando leitores
            while (scanner.hasNext()) {
                System.out.println("Cadastrando leitor");

                System.out.println("Digite o nome do Leitor: ");
                scanner = new Scanner(System.in);
                String nomeLeitor = scanner.nextLine();

                System.out.println("Digite o cadatro do Leitor (4 digitos): ");
                scanner = new Scanner(System.in);
                int cadastro = scanner.nextInt();

                Leitor leitor = new Leitor(nomeLeitor);
                leitor.setCadastro(cadastro);
                sistema.CadastrarLeitor(leitor);

                //Escrevendo leitor no arquivo
                Arquivo.escritor("leitores.txt", (leitor.nome + " - " + leitor.getCadastro()));

                //Saindo do loop de leitores
                System.out.println("Caso deseje sair digite 'Sair Leitor' ou qualquer valor para continuar");
                scanner = new Scanner(System.in);
                sair = scanner.nextLine();
                if (sair.equals("Sair Leitor")) break;
            }

            //Leitor pegando livro
            System.out.println("Para pegar um livro é necessário ser cadastrado.");
            System.out.println("Por favor entre com seu cadastro: ");
            while (leitorCadastrado == null) {
                scanner = new Scanner(System.in);
                leitorCadastrado = sistema.ProcurarLeitor(scanner.nextInt());
            }

            System.out.println("Insira o nome do livro a ser pego: ");
            while (livroPego == null) {
                scanner = new Scanner(System.in);
                livroPego = sistema.ProcurarLivro(scanner.nextLine());
            }

            leitorCadastrado.PegarLivro(livroPego); //Pegando livro

            //Saindo do sistema
            System.out.println("Para sair do sistema digite 'Sair', caso contrário o sistema será reiniciado.");
            scanner = new Scanner(System.in);
            sair = scanner.nextLine();
        }

        System.out.println("Fim do programa");
    }
}
