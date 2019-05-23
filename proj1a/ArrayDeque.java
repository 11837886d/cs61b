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
        int cur = plusOne(nextFirst);
        for (int i = 0; i < size; i++){
            a[i] = items[cur];
            cur = plusOne(cur);
        }
        items = a;
        nextLast = size;
        nextFirst = items.length - 1;
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
        }
        T temp = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size--;

        if (items.length >= 16 && size < (int) 0.33 * items.length){
            resize(items.length/2);
        }
        return temp;
    }

    public T removeLast(){
        if (size == 0){
            return null;
        }
        T temp = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size--;

        if (items.length >= 16 && size < (int) 0.33 * items.length){
            resize(items.length/2);
        }
        return temp;
    }

    public T get(int index){
        // out of bound of array
        if (index < 0 | index >= size){
            return null;
        }

        // this circular deque's front item is not stored in index 0
        int current = plusOne(nextFirst);
        for (int i = 0; i < index; i++){
            current = plusOne(current);
        }
        return items[current];
    }
}
