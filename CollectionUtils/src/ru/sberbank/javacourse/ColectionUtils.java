package ru.sberbank.javacourse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ColectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(o))
                return i;
        }
        return -1;
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
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

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (!c1.contains(t))
                return false;
        }
        return true;
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (!c1.contains(t))
                return true;
        }
        return false;
    }

    public static <T extends Comparable<? extends T>> List<T> range(List<? extends T> list, T min, T max) {

    }

    public static <T extends Comparable<? extends T>> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {

    }
}
