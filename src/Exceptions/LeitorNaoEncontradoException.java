package Exceptions;

//Tratamendo de erro para quando não encontrar um leitor
public class LeitorNaoEncontradoException extends Exception{
    public LeitorNaoEncontradoException(String message)
    {
        super(message);
    }
}
