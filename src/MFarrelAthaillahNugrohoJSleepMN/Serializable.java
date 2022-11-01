package MFarrelAthaillahNugrohoJSleepMN;

import java.util.HashMap;

/**
 * Ini adalah class Serializable yang digunakan untuk menginisialisasi variabel int id yang akan digunakan di subclass lain
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 6
 */

public class Serializable {
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter =  0;
        }
        else{
            counter +=1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) { return mapCounter.put(clazz, id); }

    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) { return mapCounter.get(clazz); }

    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}