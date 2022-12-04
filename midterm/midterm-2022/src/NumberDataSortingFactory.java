public class NumberDataSortingFactory extends NumberData{
    public SortAlg createSortAlg(String name) {
        if (name.equals("Bubble")) {
            return new BubbleSort();
        } else if (name.equals("Insertion")) {
            return new InsertionSort();
        } else if (name.equals("Selection")) {
            return new SelectionSort();
        }
        return null;
    }
}
