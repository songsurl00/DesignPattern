
public class Sorter {
    private Comparable comparable;

    public Sorter(Comparable comparable) {
        this.comparable = comparable;
    }

    public void setComparable(Comparable comparable) {
        this.comparable = comparable;
    }

    public void bubbleSort(Object[] date) {
        for (int i = 0; i < date.length - 1; i++) {
            for (int j = 0; j < date.length - i - 1; j++) {
                if (comparable.compareTo(date[j], date[j + 1]) > 0) { // swap
                    Object temp = date[j];
                    date[j] = date[j + 1];
                    date[j + 1] = temp;
                }
            }
        }
    }
}
