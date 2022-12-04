import java.time.LocalTime;
import java.util.ArrayList;

public class TimeObservableThread implements Runnable, Subject {
    private static final int SLEEPTIME = 1000;
    private int hour;
    private int min;
    private int sec;
    private String result = "00:00:00";

    private boolean stopRunning = false;
    private ArrayList<Observer> observerList = new ArrayList<Observer>();   // 옵저버를 저장할 ArrayList

    public void stopRunning() { stopRunning = true; }

    public void startRunning() {
        stopRunning = false;
        run();
    }

    private void generateTime() {
        System.out.println(result);
        while (stopRunning == false) {
            LocalTime time = LocalTime.now();
            hour = time.getHour();
            min = time.getMinute();
            sec = time.getSecond();
            result = "" + hour + ":" + min + ":" + sec; // 현재 시간, 분, 초를 문자열로 저장
            System.out.println(result);    // 9:10:25형태로 출력
            notifyObservers();
            try {
                Thread.sleep(SLEEPTIME); // 1초 쉼
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() { generateTime(); }

    @Override
    public void registerObserver(Observer obs) {    // 옵저버를 등록
        observerList.add(obs);
    }

    @Override
    public void unregisterObserver(Observer obs) {  // 해당 옵저버의 위치를 확인하고 제거
         observerList.remove(obs);
    }

    @Override
    public void notifyObservers() { // observerList 안에 있는 모든 옵저버들의 update()를 호출
        for (Observer observer : observerList) {
            observer.update(result);
        }
    }
}
