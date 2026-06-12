package student;

public interface ListObserver<T extends Comparable<T>>
{
    void poppedFromList(MinMidMax<T> source  , T element);
    void pushedToList (MinMidMax<T> source  , T element);
}
