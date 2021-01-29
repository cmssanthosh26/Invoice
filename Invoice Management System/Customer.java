package invoice.management.system;
import java.util.Iterator;
import java.util.Scanner;
public class Customer {
    static Scanner scanner=new Scanner(System.in);
    String customerName;
    String phoneNumber;
    String address;
    Invoice invoice;
    int invoiceId;
    int customerId;
    Customer next;
    public Customer(String name,String phno,String a,int id){
        this.customerName=name;
        this.phoneNumber=phno;
        this.address=a;
        this.customerId=id;
        this.invoiceId=1;
    }
    public void addInvoice(Item i){
        Invoice temp=new Invoice(this.invoiceId);
        if(invoice==null)
            invoice=temp;
        else{
            Invoice t=invoice;
            while(t.next!=null){
                t=t.next;
            }
            t.next=temp;
        }
        System.out.println("Your Invoice id is "+this.invoiceId);
        this.invoiceId++;
        temp.addItemToInvoice(i);
        //addItemToInvoice(i,temp);
    }
    public void addItemToYourInvoice(Item i){
        Invoice temp=validateInvoice();
        if(temp==null)
            System.out.println("Enter correct invoice id");
        else{
            temp.addItemToInvoice(i);
        }
    }
    public Invoice validateInvoice(){
        System.out.println("Enter your invoice number");
        int v=scanner.nextInt();
        Invoice temp=invoice;
        while(temp!=null){
            if(temp.invoiceId==v)
                break;
            temp=temp.next;
        }
        if(temp==null)
            return null;
        return temp;
    }
    public void displayInvoice(){
        Invoice temp=validateInvoice();
        if(temp==null)
            System.out.println("Enter correct invoice id");
        else{
            temp.displayDetails();
            //displayDetails(temp);
        }
    }
    public void listInvoice(){
        if(this.invoice==null){
            System.out.println("Doesn't have any invoice in your account");
            return;
        }
        Invoice temp=this.invoice;
        while(temp!=null){
            temp.displayDetails();
            temp=temp.next;
            System.out.println("***********************************************************************************************");
        }
    }
}
