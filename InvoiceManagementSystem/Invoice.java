package invoice.management.system;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Invoice {
    int invoiceId;
    float total;
    float discount;
    int totalNoOfItems;
    static Scanner scanner=new Scanner(System.in);
    ArrayList<Item> a;
    Invoice next;
    public Invoice(int id){
        this.invoiceId=id;
        a=new ArrayList<>();
    }
    public void addItemToInvoice(Item i){
        while(true){
            Item it=i;
            while(it!=null){
                System.out.println(it.itemName+"\t\t"+it.cost);
                it=it.next;
            }
            System.out.println("Select Item Name");
            scanner.nextLine();
            String name=scanner.nextLine();
            it=i;
            while(it!=null){
                if(it.itemName.equalsIgnoreCase(name))
                    break;
                it=it.next;
            }
            if(it!=null){
                this.total+=it.cost;
                this.totalNoOfItems++;
                a.add(it);
            }
            else
                return;
            System.out.println("Do you want to enter one more item enter 1 otherwise enter 0");
            int k=scanner.nextInt();
            if(k==0)
                break;
        }
    }
    public void displayDetails(){
        System.out.println("Product name\t\t\tProduct cost");
        Iterator itr=a.iterator();
        while(itr.hasNext()){
            Item i=(Item)itr.next();
            System.out.println(i.itemName+"\t\t\t"+i.cost);
        }
        System.out.println();
        System.out.println("Total No Of Items: "+this.totalNoOfItems+"\t\t\tTotal Price: "+this.total);
    }
}
