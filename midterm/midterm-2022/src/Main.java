// 수정하지 말 것
public class Main {
    public static void main(String[] args) {
        NumberData nd = new NumberDataSortingFactory();
        String[] algs = { "Bubble", "Insertion", "Selection" };
        for (int i = 0; i < algs.length; i++) {
            System.out.printf("Using %s algorithm\n", algs[i]);
            nd.stirSortPrintData(algs[i]);
        }

        /*
        NumberData를 abstract로 해서 상속받는 sub class에게 SortAlg 객체의 생성을 위임함
        NumberDataSortingFactory는 NumberData를 상속받아서 객체 생성만 하는 팩토리로서 동작(팩토리 메소드 구현)
        SubAlg는 일반화된 sorting 알고리즘을 갖고 있는 인터페이스이고,
        이를 구현한 BubbleSort, InsertionSort, SelectionSort가 각각의 sorting 알고리즘을 구현해서
        클라이언트가 각각의 sorting 알고리즘을 바꿔서 사용할 수 있게 함(스트레트지 패턴 구현)
        */
    }
}
