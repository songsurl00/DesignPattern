public class Search {
    private Strategy strategy;

    public Search(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setSearch(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean anySearch(int[] objs, int num) {
        return strategy.strategySearch(objs, num);
    }

    /** public boolean binarySearch(int[] objs, int num)
     * <p> 이진 검색 방법을 이용해서 정수를 찾고 있으면 해당 값을 반환함
     * </p>
     * @param objs 오름차순으로 정렬되어 있는 정수 배열
     * @param num 검색할 정수값
     * @return 배열에 검색할 정수값이 있는지 확인하고 true 또는 false를 반환
     */
//    public boolean binarySearch(int[] objs, int num) {
//        int left = 0;
//        int right = objs.length - 1;
//        while (left <= right) {
//            int mid = (right - left)  / 2 + left;
//            if (objs[mid] == num) return true;
//            else if (objs[mid] > num) { // remove right half
//                right = mid - 1;
//            } else {  // remove left half
//                left = mid + 1;
//            }
//        }
//        return false;
//    }

    /** public boolean linearSearch(int[] objs, int num)
     * <p> 단순 반복문을 이용해서 정수를 찾고 있으면 해당 값을 반환함
     * </p>
     * @param objs 오름차순으로 정렬되어 있는 정수 배열
     * @param num 검색할 정수값
     * @return 배열에 검색할 정수값이 있는지 확인하고 true 또는 false를 반환
     */
//    public boolean linearSearch(int[] objs, int num) {
//        for (int n : objs) {
//            if (num == n) return true;
//        }
//        return false;
//    }
}
