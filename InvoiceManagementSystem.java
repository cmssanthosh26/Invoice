package invoice.management.system;
public class InvoiceManagementSystem {
    public static void main(String[] args) {
        InvoiceSystem is=new InvoiceSystem();
        is.addItemList();
        is.takeAction();
    }    
}
