public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T []) new Object[8];
        size =  0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    // set helper functions as private
    private int minusOne(int index){
        if (index == 0){
            return items.length - 1;
        } else {
            return index - 1;
        }
    }

    private int plusOne(int index){
        if (index == items.length - 1){
            return 0;
        } else {
            return index + 1;
        }
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < nextLast; i++){
            a[i] = items[i];
        }
        for (int j = nextLast; j < items.length; j++){
            a[j + items.length] = items[j];
        }
        nextFirst += items.length;
        items = a;
    }

    public void addFirst(T item){
        if (size == items.length){
            resize (size * 2);
        }
        items[nextFirst] = item;
        size ++;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item){
        if (size == items.length){
            resize (size * 2);
        }
        items[nextLast] = item;
        size ++;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque() {
        int count = 0;
        while (count < size) {
            System.out.print(items[count]);
            count++;
            if (count < size) {
                System.out.print(" ");
            }
        }
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            return items[plusOne(nextFirst + 1)];
        }
    }

    public T removeLast(){
        if (size == 0){
            return null;
        } else {
            return items[minusOne(nextLast - 1)];
        }
    }

    public T get(int index){
        return items[index];
    }
}
