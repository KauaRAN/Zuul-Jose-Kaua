import java.util.Scanner;

/**
 * Nesta classe ocorrerá a leitura da entrada como um comando para a aventura. Realizamos mudanças para reduzir acoplamento aqui, vide getCommandList.
 */
public class Parser 
{
    private CommandWords commands;  
    private Scanner reader;        

   
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Retorna o próximo comando para o usuário.
     */
    public Command getCommand() 
    {
        String inputLine;   
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     

        inputLine = reader.nextLine();

        
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      
            }
            tokenizer.close();
        }

        
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }
    public void getCommandList()
    {
        commands.showAll();
    }

}
