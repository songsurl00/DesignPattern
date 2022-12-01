import java.util.ArrayList;

public class PrimeObservableThread implements Runnable, Subject {
    private static final int SLEEPTIME = 500;

    private int primeNumber;
    private int numCount = 1;
    private boolean stopRunning = false;
    private ArrayList<Observer> observerList = new ArrayList<Observer>();   // 옵저버를 저장할 ArrayList

    public int getPrimeNumber() { return primeNumber; }

    public void stopRunning() { stopRunning = true; }

    public void startRunning() {
        stopRunning = false;
        run();
    }

    private void generatePrimeNumber() {
        primeNumber = 2;
        System.out.println(primeNumber);
        while (stopRunning == false) {
            numCount += 2; // 2를 제외한 짝수는 소수가 될 수 없음. 따라서 홀수만 검사
            if (isPrimeNumber(numCount)) {
                primeNumber = numCount;
                System.out.println(primeNumber);
                notifyObservers();
            }
            try {
                Thread.sleep(SLEEPTIME); // 1초 쉼
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() { generatePrimeNumber(); }

    @Override
    public void registerObserver(Observer obs) {    // 옵저버를 등록
        observerList.add(obs);
    }

    @Override
    public void unregisterObserver(Observer obs) {  // 해당 옵저버의 위치를 확인하고 제거
        int index = observerList.indexOf(obs);
        if (index >= 0) {
            observerList.remove(obs);
        }
    }

    @Override
    public void notifyObservers() { // observerList 안에 있는 모든 옵저버들의 update()를 호출
        for (Observer observer : observerList) {
            observer.update(primeNumber);
        }
    }
}
