public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T []) new Object[8];
        size =  0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int minusOne(int index){
        if (index == 0){
            return items.length - 1;
        } else {
            return index - 1;
        }
    }

    public int plusOne(int index){
        if (index == items.length - 1){
            return 0;
        } else {
            return index + 1;
        }
    }

    public void addFirst(T item){
        // test full

        items[nextFirst] = item;
        size ++;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item){

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
