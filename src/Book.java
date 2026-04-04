public class Book extends Item implements PriceableWithVAT6  {
    private final double price;
    private final boolean bound;
    private final String author;

    public Book(String name, String author, double price, Boolean bound) {
        super(name);
        this.author = author;
        this.bound = bound;
        this.price = price;
    }
    public double getPrice() {
        if (bound){
            return price * 1.30;
        }
        return this.price;
    }
    public String toString() {
        return "Book: name=" +getName() + ",  author='"+ author+ "',  bound=" + bound + ",  price=" + getPrice() + ", price+vat=" + getPriceWithVAT();
    }
}

