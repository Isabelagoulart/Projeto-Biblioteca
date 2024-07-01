package Sistema;

import Exceptions.LeitorNaoEncontradoException;
import Exceptions.LivroNaoEncontradoException;

public class SistemaBiblioteca implements Biblioteca{
    //Atributos
    public static Boolean vazio = false; //Variavel para quantidade de livro = 0

    //Métodos
    @Override
    public void CadastrarLeitor(Leitor leitor) {
        Biblioteca.super.CadastrarLeitor(leitor);
    }

    @Override
    public void CadastrarLivro(Livro livro) {
        Biblioteca.super.CadastrarLivro(livro);
    }

    @Override
    public Leitor ProcurarLeitor(int cadastro) throws LeitorNaoEncontradoException {
        return Biblioteca.super.ProcurarLeitor(cadastro);
    }

    @Override
    public Livro ProcurarLivro(String nome) throws LivroNaoEncontradoException {
        return Biblioteca.super.ProcurarLivro(nome);
    }
}
