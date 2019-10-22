package ru.sberbank.javacourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//import java.util.Collection


public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(o))
                return i;
        }
        return -1;
    }

    public static <T> List<T> limit(List<T> source, int size) {
        return source.subList(0, Math.min(size, source.size()));
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T t : c2) {
            removeFrom.remove(t);
        }
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (!c1.contains(t))
                return false;
        }
        return true;
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (c1.contains(t))
                return true;
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<T> list, T min, T max) {

        List<T> l = new ArrayList<>();
        for (T el : list)
            if (min.compareTo(el) <= 0 && max.compareTo(el) > 0)
                l.add(el);
        return l;
    }

    public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> l = new ArrayList<>();
        for (T t : list) {
            if ((comparator.compare(t, min) >= 0) && (comparator.compare(t, max) < 0)) {
                l.add(t);
            }
        }
        return l;
    }
}
