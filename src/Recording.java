public abstract class Recording extends Item implements PriceableWithVAT25 {
    private final String artist;
    private final int year;
    private int condition;
    private final double price;

    public Recording(String name , String artist , int year, int condition , double price){
        super(name);
        this.artist = artist;
        this.year= year;
        this.condition = condition;
        this.price = price;
    }
    public abstract String getType();

    public String getArtist(){
        return this.artist;
    }
    public double getPrice(){
        //Räkna ut rabatten med formeln ovan
        int discount = (10 - getCondition()) * 10;
        double factor = (100.0 - discount) / 100.0;
        double finalprice = getOriginalPrice() * factor;
        //Kolla om resultatet är under 10 → sätt det till 10 i så fall
        if (finalprice < 10){
            finalprice = 10;
        }

        //Returnera det slutliga värdet (utan moms – moms hanteras separat)

        return finalprice;
    }
    public int getCondition(){
        return this.condition;
    }
    public int getYear(){
        return this.year;
    }
    protected double getOriginalPrice(){
        return this.price;
    }
    public String toString(){
        return getType() + ":  name=" + getName() + ",  artist='" + getArtist() + "', year=" +getYear() + " , condition=" + getCondition() + ", original price=" + getOriginalPrice() + ", price="  + getPrice() + ", price+vat=" + getPriceWithVAT();
    }

}
