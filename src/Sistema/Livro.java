package Sistema;

public class Livro extends SistemaBiblioteca { //herença
    //Atributos
    public String nome;
    public String autor;
    private int nLivres;//Quantidade desses livros na prateleira
    private int nPegos;//Quantidade desses livros já pegos

    //Construtor
    public Livro(String nome, String autor, int nLivres) { //Começa com nLivres sendo a quantidade total de livros na biblioteca
        this.nome = nome;
        this.autor = autor;
        this.nLivres = nLivres;

        if(nLivres <= nPegos)
            SistemaBiblioteca.vazio = true;

        else
            SistemaBiblioteca.vazio = false;
    }

    //Getters e Setters
    public int getnLivres() {
        return nLivres;
    }

    public void setnLivres(int nLivres) {
        this.nLivres = nLivres;
    }

    public int getnPegos() {
        return nPegos;
    }

    public void setnPegos(int nPegos) {
        this.nPegos = nPegos;
    }
}
