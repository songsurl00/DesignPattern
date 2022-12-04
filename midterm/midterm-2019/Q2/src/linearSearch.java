public class linearSearch implements Strategy{
    @Override
    public boolean strategySearch(int[] objs, int num) {    // 선형 탐색
        for (int n : objs) {
            if (num == n) return true;
        }
        return false;
    }
}
