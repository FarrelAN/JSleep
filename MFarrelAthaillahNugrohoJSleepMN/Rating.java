package MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Rating
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Rating
{
    private long total, count;

    public Rating() {
        total = 0;
        count = 0;
    }

    public void insert(int rating){
        total += rating;
        count++;
    }

    public long getAverage() {
        if(count == 0) {
            return 0;
        }
        return total / count;
    }

    public long getCount(){
        return count;
    }
    
    public long getTotal() {
        return total;
    }

}
