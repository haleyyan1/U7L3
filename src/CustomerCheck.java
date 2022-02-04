import java.util.ArrayList;
import java.util.Arrays;
public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double in = 0;
        for (int i = 0; i<check.size();i++){
            in+=check.get(i).getPrice();
        }
        return in;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        boolean daily=false;
        for (int i =0;i<check.size();i++){
            if (check.get(i).isDailySpecial()) {
                daily=true;
            }
        }
        if (totalPrices()<40||daily) {
            return false;
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double og = 0;
        double withoutCoup = totalPrices();
        if (couponApplies()){
            withoutCoup*=.75;
        }
        int cust=0;
        for (int i = 0; i<check.size();i++){
            if (check.get(i).isEntree()) {
                cust++;
            }
        }
        if (cust>=6){
            og = totalPrices()*.2;
        }
        return withoutCoup+og;
    }
}