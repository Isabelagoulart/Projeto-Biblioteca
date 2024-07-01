package Sistema;//Imports
import Exceptions.LeitorNaoEncontradoException;
import Exceptions.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.Objects;

public interface Biblioteca {
    //Atributos
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Leitor> leitores = new ArrayList<>();

    //Métodos
    default void CadastrarLivro(Livro livro){
        livros.add(livro);
    }

    default void CadastrarLeitor(Leitor leitor){
        leitores.add(leitor);
    }

    default Leitor ProcurarLeitor(int cadastro) throws LeitorNaoEncontradoException {
        for (Leitor leitor : leitores) {
            if(Objects.equals(leitor.getCadastro(), cadastro)){
                System.out.println("Bem-vindo(a)!" + leitor.nome);
                return leitor;
            }
        }
        throw new LeitorNaoEncontradoException("Cadastro não encontrado");
    }

    default Livro ProcurarLivro(String nome) throws LivroNaoEncontradoException {
        for (Livro livro : livros) {
            if(Objects.equals(livro.nome, nome)){
                return livro;
            }
        }
        throw new LivroNaoEncontradoException("Livro não encontrado");
    }
}
