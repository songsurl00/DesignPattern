public class State0 implements State {
    private VendingMachine vendingMachine;
    State0(VendingMachine vendingMachine) {
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
        vendingMachine.setState(vendingMachine.getState500());
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
        vendingMachine.setMsg("반환할 돈이 없습니다");
    }

    @Override
    public void selectBeverage() {
        vendingMachine.setMsg("돈을 넣은 후에 눌러주세요");
    }
}
