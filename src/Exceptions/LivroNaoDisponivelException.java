package Exceptions;

//Erro para quando não há um livro disponível
public class LivroNaoDisponivelException extends Exception{
    public LivroNaoDisponivelException(String message){
        super(message);
    }
}
