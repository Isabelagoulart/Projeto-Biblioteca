package Sistema;

import Exceptions.LivroNaoDisponivelException;

import java.util.ArrayList;

public class Leitor{
    //Atributos
    public String nome;
    private int cadastro;
    private ArrayList<Livro> livrosLidos = new ArrayList<>();

    //Construtor
    public Leitor(String nome){
        this.nome = nome;
    }

    //Metodos
    public void PegarLivro(Livro livro) throws LivroNaoDisponivelException {
        if(livro.getnLivres() > 0 && !livro.vazio) { //Verificando se este livro está disponível
            livro.setnLivres(livro.getnLivres() - 1);
            livro.setnPegos(livro.getnPegos() + 1);
            livrosLidos.add(livro);
            System.out.println(this.nome + " pegou " + livro.nome);
        }
        else
            throw new LivroNaoDisponivelException("Livro não disponível"); //Caso não esteja disponível
    }

    //Getter e Setter
    public int getCadastro() {
        return cadastro;
    }

    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }
}
