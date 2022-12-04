import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ObjectDynamicArray arr = new ObjectDynamicArray();
        for (int i = 0; i < 35; i++) {
            arr.add(i);
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("data[%d] = %d\n", i, (int) arr.get(i));
        }

        System.out.println("iterator 사용");
        int j = 0;
        Iterator<Object> iter = arr.iterator();
        while (iter.hasNext()) {
            Object o = iter.next();
            System.out.printf("data[%d] = %d\n", j, (int) o);
            j++;
        }

        System.out.println("for-each 사용");
        int i = 0;
        for (Object o : arr) {
            System.out.printf("data[%d] = %d\n", i, (int) o);
            i++;
        }
    }
}
