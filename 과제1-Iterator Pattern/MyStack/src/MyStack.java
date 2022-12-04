import java.util.ArrayList;
import java.util.Iterator;

public class MyStack<E> implements Iterable<E>{
    private ArrayList<E> list;
    public class MyStackIterator<E> implements Iterator<E> {
        private int index;
        public MyStackIterator() {
            index = list.size() - 1;
        }
        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public E next() {
            E e = (E) list.get(index);  // 여기서 (E)로 형변환을 해줘야함
            index--;
            return e;
        }
    }
    public MyStack() {
        list = new ArrayList<E>();
    }
    public void push(E e) {
        list.add(e);
    }
    public E pop() {
        if (!isEmpty()) {
            E e = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return e;
        }
        return null;
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    @Override
    public Iterator<E> iterator() {
        return new MyStackIterator<>();
    }
}
