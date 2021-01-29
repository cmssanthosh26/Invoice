package invoice.management.system;
import java.util.Scanner;
public class InvoiceSystem {
    static Scanner scanner=new Scanner(System.in);
    Customer root;
    Item itemRoot;
    int id;
    public InvoiceSystem(){
        super();
        id=1;
    }
    public void addItemList(){
        System.out.println("Enter item details");
        while(true){
            System.out.println("Enter the item name and item cost");
            String name=scanner.nextLine();
            float cost=scanner.nextFloat();
            scanner.nextLine();
            Item temp=new Item(cost,name);
            if(this.itemRoot==null)
                this.itemRoot=temp;
            else{
                Item t=this.itemRoot;
                while(t.next!=null)
                    t=t.next;
                t.next=temp;
            }
            System.out.println("Do you want to add one more item in your store list enter 1 otherwise 0");
            int v=scanner.nextInt();
            if(v==0)
                break;
            scanner.nextLine();
        }
    }
    public void takeAction(){
        while(true){
            System.out.println("Enter your choice(1-7)");
            System.out.println("1.Add customer");
            System.out.println("2.Add Invoice");
            System.out.println("3.Add item to invoice");
            System.out.println("4.List All customer");
            System.out.println("5.List all invoices of a customer");
            System.out.println("6.Display invoice");
            System.out.println("7.Exit");
            int n=scanner.nextInt();
            switch(n){
                case 1:
                    addCustomer();
                    break;
                case 2:
                    addInvoice();
                    break;
                case 3:
                    addItemToInvoice();
                    break;
                case 4:
                    listCustomer();
                    break;
                case 5:
                    listAllInvoiceOfACustomer();
                    break;
                case 6:
                    display();
                    break;
                case 7:
                    System.exit(1);
                default:
                    System.out.println("Enter correct option");
            }
            System.out.println("Do you want to continue enter 1 otherwise 0");
            int v=scanner.nextInt();
            if(v==0)
                break;
        }
    }
    public void listAllInvoiceOfACustomer(){
        Customer temp=validateCustomer();
        if(temp==null)
            System.out.println("Enter correct Customer id");
        else
            temp.listInvoice();
    }
    public Customer validateCustomer(){
        System.out.println("Enter your customer Id");
        int Cid=scanner.nextInt();
        Customer temp=this.root;
        while(temp!=null){
            if(temp.customerId==Cid)
                break;
            temp=temp.next;
        }
        if(temp==null){
            return null;
        }
        else
            return temp;
    }
    public void addCustomer(){
        scanner.nextLine();
        System.out.println("Enter your name");
        String name=scanner.nextLine();
        System.out.println("Enter phone no");
        String phno=scanner.nextLine();
        System.out.println("Enter Address");
        String address=scanner.nextLine();
        Customer temp=new Customer(name,phno,address,this.id);
        if(this.root==null)
            this.root=temp;
        else
        {
            Customer t=root;
            while(t.next!=null)
                t=t.next;
            t.next=temp;
        }
        System.out.println("Your Customer id is "+this.id++);
    }
    public void addInvoice(){
        System.out.println("Select your option");
        System.out.println("1.New Customer");
        System.out.println("2.Existing customer");
        int v=scanner.nextInt();
        if(v==1)
            this.addCustomer();
        System.out.println("Enter your Customer Id");
        int Cid=scanner.nextInt();
        Customer temp=this.root;
        while(temp!=null){
            if(temp.customerId==Cid)
                break;
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Enter correct Customerid");
        }
        else
            temp.addInvoice(itemRoot);
    }
    public void addItemToInvoice(){
        System.out.println("Enter your customer Id");
        int Cid=scanner.nextInt();
        Customer temp=this.root;
        while(temp!=null){
            if(temp.customerId==Cid)
                break;
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Enter correct Customerid");
        }
        else
            temp.addItemToYourInvoice(itemRoot);
    }
    public void listCustomer(){
        System.out.println("Customer Details");
        Customer temp=this.root;
        while(temp!=null){
            System.out.println(temp.customerId+"\t"+temp.customerName+"\t"+temp.phoneNumber+"\t"+temp.address);
            temp=temp.next;
        }
    }
    public void display(){
        System.out.println("Enter your Customer Id");
        int v=scanner.nextInt();
        Customer temp=this.root;
        while(temp!=null){
            if(temp.customerId==v)
                break;
            temp=temp.next;
        }
        if(temp==null)
            System.out.println("enter correct customer id");
        else
            temp.displayInvoice();
    }
}
