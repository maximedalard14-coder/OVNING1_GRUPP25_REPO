import java.time.Year;
public class LongPlay extends Recording{
    public LongPlay(String name , String artist , int year , int condition , double price){
        super(name , artist , year , condition , price);
    }
    public String getType(){
        return "LP";
    }

    public double getPrice(){   //i LongPlay ska minimipriset kollas efter årstillägget lagts till. Därflr kunde inte vi anropa super.getPrice() och lägga till årstillägget efteråt, det hade gett fell svar.
        int currentYear =Year.now().getValue() ;

        int discount = (10 - getCondition()) * 10;
        double factor = (100.0 - discount) / 100.0;
        double finalprice = getOriginalPrice() * factor + (currentYear - getYear()) * 5.0;
        if(finalprice < 10.0) {
            finalprice = 10.0;
        }
        return finalprice;

    }

}
