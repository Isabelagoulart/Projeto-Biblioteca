package Exceptions;

//Erro para quando não encontrar um livro
public class LivroNaoEncontradoException extends Exception{
    public LivroNaoEncontradoException(String message)
    {
        super(message);
    }
}
