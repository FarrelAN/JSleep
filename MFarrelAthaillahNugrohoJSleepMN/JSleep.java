package MFarrelAthaillahNugrohoJSleepMN;


public class JSleep
{   
    public static void main(String[] args) {
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
    }
    
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
    
    public static Room createRoom() {
        Price price = new Price (100000, 5);
        Room room = new Room("hotel", 30, price, Facility.AC);
        return room;
    }
}
