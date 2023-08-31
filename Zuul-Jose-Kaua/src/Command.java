/**
 *  Essa classe irá "guardar" o comando oferecido pelo usuário. Consiste de duas palavras, sendo uma de ação e a outra a direção, objeto etc que 
 *  faz jus a primeira palavra e sofre efeito dela.
 **/

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Construtor para definir os atributos.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Retorna a palavra de comando, ou seja, a primeira.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * Retorna a segunda palavra.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * Métodos para retornar verdadeiro caso sejam os comandos.
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

