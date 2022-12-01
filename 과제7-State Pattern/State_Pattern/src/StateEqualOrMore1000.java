public class StateEqualOrMore1000 implements State {
    private VendingMachine vendingMachine;

    public StateEqualOrMore1000(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void addHundred() {
        vendingMachine.setBalance(100);
        vendingMachine.setMsg("");
    }

    @Override
    public void addFiveHundred() {
        vendingMachine.setBalance(500);
        vendingMachine.setMsg("");
    }

    @Override
    public void addThousand() {
        vendingMachine.setMsg("이미 충분한 돈이 투입되었습니다. 음료를 선택하세요");
    }

    @Override
    public void returnChanges() {
        vendingMachine.setState(vendingMachine.getState0());
        vendingMachine.setMsg("" + vendingMachine.getBalance() + "원을 반환합니다");
        vendingMachine.clearBalance();
    }

    @Override
    public void selectBeverage() {
        String msg = "음료를 내보냅니다. 배출구를 확인하세요.";
        vendingMachine.setBalance(-1000);
        if (vendingMachine.getBalance() > 0) {
            msg = msg + " 거스름돈 " + vendingMachine.getBalance() + "원을 반환합니다.";
            vendingMachine.clearBalance();
        }
        vendingMachine.setMsg(msg);
        vendingMachine.setState(vendingMachine.getState0());
    }
}
