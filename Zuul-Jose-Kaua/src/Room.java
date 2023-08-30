import java.util.HashMap;
import java.util.Set;

/**
 * Esta classe representa uma sala/localidade no jogo. Apresenta direções/saídas que dão em outras localidades.
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Mudança realizada visando baixo acoplamento**/
    public void setExit(String direction, Room neighbor) 
    {
            exits.put(direction, neighbor);
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public String getExitString(){
        String returnString = "Saidas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys){
            returnString += " " + exit;
        }
        return returnString;
    }
            

    /**
     * retorna a descrição da sala.
     */
    public String getDescription()
    {
        return description;
    }

    /**Retorna a descrição completa da localidade do jogador.
    **/
    public String getLongerDescription(){
        return "Voce esta " + description + ".\n" + getExitString();
    }

}
