import java.util.HashMap;
import java.util.Set;

/**
 * Essa é a classe que representa uma sala/localidade no jogo. Estas localidades são definidas por saídas que dão em outras.
 */
public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    private Item item;

    /**
     * Construtor para a descrição da sala.
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define as saídas das salas. Os métodos foram mudados para estar de acordo com os conceitos de coesão e acoplamento.
     */
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
     * Retorna a descrição da sala.
     */
    public String getDescription()
    {
        return description;
    }

    /**
    * Métodos para auxiliar o processo para aplicar o item nas salas.
    */
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public String getLongerDescription(){
        return "Voce esta " + description + ".\n" + getExitString();

    }

}
