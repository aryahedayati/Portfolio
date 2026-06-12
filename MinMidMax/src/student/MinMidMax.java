package student;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MinMidMax<T extends Comparable<T>> {
    private ArrayList <T> list = new ArrayList<>();
    private ArrayList <ListObserver<T>> observers = new ArrayList<>();

    public MinMidMax (T...elements) {
        for (T element : elements) {
            push(element);
        }
    }

    public boolean push (T element) {
        if (list.contains(element)) {return false;}
        list.add(element);
        Collections.sort(list);
        for (ListObserver<T> observer : observers) {
            observer.pushedToList(this,element);
        }
        return true;
    }
    public int getNumItems () {
        return list.size();
    }
    public T popRight () {
        if(!list.isEmpty()) {
            T removed = list.get(list.size()-1);
            list.remove(list.size()-1);
            for (ListObserver<T> observer : observers) {
                observer.poppedFromList(this,removed);
            }
            return removed;
        }
        else {return null;}
    }
    public T popLeft () {
        if (!list.isEmpty()) {
            T removed = list.get(0);
            list.remove(0);
            for (ListObserver<T> observer : observers) {
                observer.poppedFromList(this,removed);
            }
            return removed;
        }
        else {return null ;}
    }
    public T getMaximum () {
        if (list.isEmpty()) {return null;}
        return list.get(list.size()-1);
    }
    public T getMid () {
        if(list.isEmpty()) {return null;}
        if(list.size() % 2 == 0) {
            return list.get((list.size()/2));
        }
        return list.get(((list.size()-1)/2));
    }
    public T getMinimum () {
        if (list.isEmpty()) {return null;}
        return list.get(0);
    }

    public void addObserver (ListObserver<T> observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }
    public void removeObserver (ListObserver<T> observer) {
        this.observers.remove(observer);
    }

    @Override
    public String toString() {
        if (list.isEmpty()) {
            return "[]";
        }
        String result = "[";
        for (int i = 0 ; i<list.size() ; i++) {
            result += list.get(i);
            if (i<list.size()-1) {
                result += " ";
            }
        }
        result += "]";
        return result;
    }
}