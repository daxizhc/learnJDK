package design.state.status;

import design.state.StateMachineV2;

public class NoMoneyStatus implements IStatus{

    private final StateMachineV2 stateMachineV2;

    public NoMoneyStatus(StateMachineV2 stateMachineV2) {
        this.stateMachineV2 = stateMachineV2;
    }

    @Override
    public void inputMoney() {
        System.out.println("input money");
        stateMachineV2.setStatus(stateMachineV2.getHasMoneyStatus());
    }

    @Override
    public void outputMoney() {
        System.out.println("not support output money");
    }

    @Override
    public void pushButton() {
        System.out.println("not support push button");
    }

    @Override
    public void outputItem() {
        System.out.println("not support output item");
    }
}
