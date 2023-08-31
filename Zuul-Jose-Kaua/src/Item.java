public class Item {
    private  String descricaoItem;
    private Double pesoItem;

    public Item(String descricaoItem, Double pesoItem)
    {
        this.descricaoItem = descricaoItem;
        this.pesoItem = pesoItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public Double getPesoItem() {
        return pesoItem;
    }


}
