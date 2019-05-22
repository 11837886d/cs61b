 public class LinkedListDeque<T> {
        public class IntNode {
            public T item;
            public IntNode next;
            public IntNode prev;

            public IntNode(T i, IntNode n, IntNode p) {
                item = i;
                next = n;
                prev = p;
            }
        }

        private IntNode sentinel;
        private int size;

        public LinkedListDeque() {
            sentinel = new IntNode(null, null, null);
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size = 0;
        }

        public void addFirst(T x) {
            sentinel.next = new IntNode(x, sentinel.next, sentinel);
            // special case for adding to an empty list
            if (size == 0)
            {
                sentinel.prev = sentinel.next;
            }   else {
                sentinel.next.next.prev = sentinel.next;
            }
            size ++;
        }

        public void addLast(T x) {
            sentinel.prev = new IntNode(x, sentinel, sentinel.prev);
            if (size == 0)
            {
                sentinel.next = sentinel.prev;
            }  else {
                sentinel.prev.prev.next = sentinel.prev;
            }
            size ++;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        }

        public void printDeque(){
            int count = size;
            IntNode p = sentinel;
            while (count > 0){
                System.out.print(p.next.item);
                count --;
                if (count > 0){
                    System.out.print(" ");
                }
            }
        }

        public T removeFirst(){
            if (size == 0){
                return null;
            }
            T temp = sentinel.next.item;
            if (size == 1){
                sentinel.next = sentinel;
                sentinel.prev = sentinel;
            } else {
                sentinel.next = sentinel.next.next;
                sentinel.next.prev = sentinel;
            }
            size --;
            return temp;
        }

     public T removeLast() {
         if (size == 0) {
             return null;
         }
         T temp = sentinel.prev.item;
         if (size == 1){
             sentinel.next = sentinel;
             sentinel.prev = sentinel;
         } else {
             sentinel.prev = sentinel.prev.prev;
             sentinel.prev.next = sentinel;
         }
         size --;
         return temp;
     }

     public T get(int index){
          if (size == 0){
              return null;
          }
          IntNode p = sentinel;
          while (index >= 0){
              p = sentinel.next;
              index --;
          }
          return p.item;
     }

     public T getRecursive(int index) {
         if (size == 0){
             return null;
         }
         return getHelper(index, sentinel.next);
     }

     public T getHelper(int index, IntNode temp) {
         if (index == 0){
             return temp.item;
         } else {
             return getHelper(index - 1, temp.next);
         }

     }
}


