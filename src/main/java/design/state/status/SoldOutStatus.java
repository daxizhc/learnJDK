package design.state.status;

import design.state.StateMachineV2;

public class SoldOutStatus implements IStatus{

    public SoldOutStatus(StateMachineV2 stateMachineV2) {
    }

    @Override
    public void inputMoney() {
        System.out.println("not support input money");
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
