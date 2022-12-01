public class State500 implements State {
    private VendingMachine vendingMachine;

    public State500(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void addHundred() {
        vendingMachine.setBalance(100);
        vendingMachine.setState(vendingMachine.getStateLess500());
        vendingMachine.setMsg("");
    }

    @Override
    public void addFiveHundred() {
        vendingMachine.setBalance(500);
        vendingMachine.setState(vendingMachine.getStateEqualOrMore1000());
        vendingMachine.setMsg("");
    }

    @Override
    public void addThousand() {
        vendingMachine.setBalance(1000);
        vendingMachine.setState(vendingMachine.getStateEqualOrMore1000());
        vendingMachine.setMsg("");
    }

    @Override
    public void returnChanges() {
        vendingMachine.setState(vendingMachine.getState0());
        vendingMachine.setMsg("" + vendingMachine.getBalance() + "원을 반환합니다");
        vendingMachine.clearBalance();
    }

    @Override
    public void selectBeverage() {
        vendingMachine.setMsg("1000원 이상을 넣은 후에 눌러주세요");
    }
}
