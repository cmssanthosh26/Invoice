package invoice.management.system;
public class Item {
    float cost;
    String itemName;
    Item next;
    public Item(float c,String s){
        this.cost=c;
        this.itemName=s;
    }
}
