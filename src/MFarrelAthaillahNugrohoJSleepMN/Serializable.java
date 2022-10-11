package MFarrelAthaillahNugrohoJSleepMN;

import java.util.HashMap;

/**
 * Ini adalah class Serializable yang digunakan untuk menginisialisasi variabel int id yang akan digunakan di subclass lain
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter;

    protected Serializable(int id) {
        Integer increment = mapCounter.get(getClass());
        if(increment != null)
            this.id = increment + 1;
        else
            this.id = 0;
    }

    public int compareTo(Serializable other) {
        return Integer.compare(this.id, other.id);
    }

    public boolean equals(Object other) {
        if(other instanceof Serializable && ((Serializable) other).id == id){
            return true;
        }
        else {
            return false;
        }

    }

    public boolean equals(Serializable other) {
        if (this.id == other.id) {
            return true;
        }
        else {
            return false;
        }
    }

    public static <T extends Serializable> Integer getClosingId(Class<?> key) {
        return mapCounter.get(key);
    }

    public static Integer setClosingId(Class<?> key, int value) {
        return mapCounter.put(key, value);
    }
}
