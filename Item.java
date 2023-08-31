import java.util.HashMap;

public class Item {
    private  String descricaoItem;
    public HashMap<Integer, Room> itens;

    public Item(String descricaoItem) 
    {
        this.descricaoItem = descricaoItem;
        itens = new HashMap<>();
    }

    public void setItem(Integer pesoItem, Room sala) 
    {
        itens.put(pesoItem, sala);
    }

    public HashMap<Integer, Room> getItens() {
        return itens;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

}
