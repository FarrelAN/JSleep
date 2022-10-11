package MFarrelAthaillahNugrohoJSleepMN;

import java.util.Iterator;
import java.util.Arrays;

public class Algorithm {

    private Algorithm() {

    }

    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, T value) {
        int count = 0;
        for(T item : array){
            if(item.equals(value)) {
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable , Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        int count = 0;
        for(T item : array){
            if(pred.predicate(item)) {
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while(iterator.hasNext()) {
            T current = iterator.next();
            if(pred.predicate(iterator.next())) {
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        int count = 0;
        for(T item : iterable){
            if(item.equals(value)) {
                count++;
            }
        }
        return count;
    }


    public static <T> T find (T[] array, Predicate<T> pred) {
        for(T item : array){
            if(pred.predicate(item)) {
                return item;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    public static <T> T find (T[] array, T value){
        for(T item : array){
            if(item.equals(value)) {
                return item;
            }
        }
        return null;
    }

    public static <T> T find (Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find (Iterator<T> iterator, T value) {
        while(iterator.hasNext()){
            if(iterator.next().equals(value)) {
                return iterator.next();
            }
        }
        return null;
    }

    public static <T> T find (Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()){
            if (pred.predicate(iterator.next())) {
                return iterator.next();
            }
        }
        return null;
    }


    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value :: equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()){
            T current = iterator.next();
            if(pred.predicate(current)) {
                return true;
            }
        }
        return false;
    }

}