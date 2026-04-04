import java.util.List;
public class Order {
    private static long counter;
    private final long orderNumber = counter;
    private final List<Item> items;

    public Order(Item...items){
        this.items= List.of(items);
    }
    public double getTotalValue(){
        double itemsPrice = 0.0;
        for(Item item : items){
            itemsPrice+=item.getPrice();
        }
        return itemsPrice;
    }
    public double getTotalValuePlusVAT(){
        double itemsPriceVAT = 0.0;
        for(Item item : items) {
            if (item instanceof Priceable p ) {
                itemsPriceVAT += p.getPriceWithVAT();
            }
        }
        return itemsPriceVAT;
    }
    public String getReceipt(){
        counter++;
        String result = "Receipt for order #"  + orderNumber + "\n" +  "-----------\n";
        for (Item item: items)
            result += item.toString() + "\n";
        return result  +"\n"+ "Total excl. VAT: " + getTotalValue() + "\n" +"Total incl. VAT: " + getTotalValuePlusVAT() + "\n" + "-----------\n";


    }

}