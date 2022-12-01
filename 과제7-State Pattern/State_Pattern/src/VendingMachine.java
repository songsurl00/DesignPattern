public class VendingMachine {
    private State STATE_0;
    private State STATE_LESS_500;
    private State STATE_500;
    private State STATE_LESS_1000;
    private State STATE_EQUAL_OR_MORE_1000;
    private State state;
    private int balance = 0;
    private String msg = "";

    public VendingMachine() {
        STATE_0 = new State0(this);
        STATE_LESS_500 = new StateLess500(this);
        STATE_500 = new State500(this);
        STATE_LESS_1000 = new StateLess1000(this);
        STATE_EQUAL_OR_MORE_1000 = new StateEqualOrMore1000(this);
        state = STATE_0;
    }

    public void addHundred() {
        state.addHundred();
    }

    public void addFiveHundred() {
        state.addFiveHundred();
    }

    public void addThousand() {
        state.addThousand();
    }

    public void returnChanges() {
        state.returnChanges();
    }

    public void selectBeverage() {
        state.selectBeverage();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState0() {
        return STATE_0;
    }

    public State getStateLess500() {
        return STATE_LESS_500;
    }

    public State getState500() {
        return STATE_500;
    }

    public State getStateLess1000() {
        return STATE_LESS_1000;
    }

    public State getStateEqualOrMore1000() {
        return STATE_EQUAL_OR_MORE_1000;
    }

    public void setBalance(int money) {
        balance += money;
    }

    public int getBalance() {
        return balance;
    }

    public void clearBalance() {
        balance = 0;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
