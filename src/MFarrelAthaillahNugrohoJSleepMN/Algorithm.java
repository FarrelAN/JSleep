package MFarrelAthaillahNugrohoJSleepMN;

import java.util.Iterator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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

    public static <T> List<T> collect (T[] array, T value) {
        Predicate<T> pred = value::equals;
        return collect(Arrays.stream(array).iterator(), pred);
    }

    public static <T> List<T> collect (Iterable<T> iterable, T value) {
        Predicate<T> pred = value::equals;
        return collect(iterable.iterator(), pred);
    }

    public static <T> List<T> collect (Iterator<T> iterator, T value) {
        Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect (T[] array, Predicate<T> pred) {
        return collect(Arrays.stream(array).iterator(), pred);
    }

    public static <T> List<T> collect (Iterable<T> iterable, Predicate<T> pred) {
        return collect(iterable.iterator(), pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()){
            T next = iterator.next();
            if (pred.predicate(next)){
                list.add(next);
            }
        }
        return list;
    }

    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> iterat = Arrays.stream(array).iterator();
        return paginate(iterat, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> iterab = iterable.iterator();
        return paginate(iterab, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        List<T> list = new ArrayList<T>();
        int counter = 0;
        while (iterator.hasNext()){
            if (pred.predicate(iterator.next())) {
                if (counter >= page * pageSize && counter < (page * pageSize) + pageSize) {
                    list.add(iterator.next());
                }
                counter++;
            }
        }
        return list;
    }

}