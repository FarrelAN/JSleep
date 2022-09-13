package MFarrelAthaillahNugrohoJSleepMN;


/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    public static int getHotelID() {
        return 0;
    }
    
    public static String getHotelName() {
        return "hotel";
    }
    
    public static boolean isDiscount() {
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount) {
        if(beforeDiscount < afterDiscount) {
            return (float)0.0;
        }
        else{
            return (float)((((float)beforeDiscount - (float)afterDiscount) / (float)beforeDiscount) * ((float)100.0));
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if(discountPercentage > 100.0) {
            return 0;
        }
        else {
           return (int)((float)price * (((float)100.0 - discountPercentage) / (float)100.0)); 
        }
    }

    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        return (int)((float)discountedPrice * (float)(100.0 / (100.0 - discountPercentage)));
    }
    
    public static float getAdminFeePercentage() {
        return (float)0.05;
    }
    
    public static int getAdminFee(int price) {
        return (int)((float)price * getAdminFeePercentage());
    }
    
    public static int getTotalPrice(int price, int numberOfNight) {
        int PretotalPrice = (int)price * (int)numberOfNight;
        return (PretotalPrice + ((int)numberOfNight * getAdminFee(price)));
    }

    public static void main(String[] args) {
        JSleep Hotel = new JSleep();
        System.out.println(Hotel.getHotelID());
        System.out.println(Hotel.getHotelName()); 
        System.out.println(Hotel.isDiscount()); 
        System.out.println(Hotel.getDiscountPercentage(1000,900)); 
        System.out.println(Hotel.getDiscountedPrice(1000, 10)); 
        System.out.println(Hotel.getOriginalPrice(900, 10)); 
        System.out.println(Hotel.getAdminFeePercentage()); 
        System.out.println(Hotel.getAdminFee(1000));
        System.out.println(Hotel.getTotalPrice(10000, 2));
    }
}
