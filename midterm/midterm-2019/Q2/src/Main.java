import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int MIN = 11;
        final int MAX = 110;
        final int NUMS = 50;
        IntArrays intArrays = new IntArrays(MIN, MAX, NUMS);

//        Search search = new Search();
//        int[] randints = intArrays.getNumbers();
//        System.out.println(search.linearSearch(randints, randints[NUMS - 10]));
//        System.out.println(search.linearSearch(randints, randints[NUMS - 20]));
//        System.out.println(search.linearSearch(randints, MAX + 10));
//        System.out.println(search.linearSearch(randints, MIN - 10));
//        System.out.println(search.binarySearch(randints, randints[NUMS - 10]));
//        System.out.println(search.binarySearch(randints, randints[NUMS - 20]));
//        System.out.println(search.binarySearch(randints, MAX + 10));
//        System.out.println(search.binarySearch(randints, MIN - 10));

        int[] randints = intArrays.getNumbers();
        Search search = new Search(new linearSearch()); // 선형탐색 방법으로 search
        System.out.println(search.anySearch(randints, randints[NUMS - 10]));
        System.out.println(search.anySearch(randints, randints[NUMS - 20]));
        System.out.println(search.anySearch(randints, MAX + 10));
        System.out.println(search.anySearch(randints, MIN - 10));
        search.setSearch(new binarySearch());    // 이진탐색 방법으로 search
        System.out.println(search.anySearch(randints, randints[NUMS - 10]));
        System.out.println(search.anySearch(randints, randints[NUMS - 20]));
        System.out.println(search.anySearch(randints, MAX + 10));
        System.out.println(search.anySearch(randints, MIN - 10));

    }
}
