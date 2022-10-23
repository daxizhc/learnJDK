package design.state.status;

import design.state.StateMachineV2;

public class HasMoneyStatus implements IStatus{

    private final StateMachineV2 stateMachineV2;

    public HasMoneyStatus(StateMachineV2 stateMachineV2) {
        this.stateMachineV2 = stateMachineV2;
    }

    @Override
    public void inputMoney() {
        System.out.println("not support input money");
    }

    @Override
    public void outputMoney() {
        System.out.println("output money");
        stateMachineV2.setStatus(stateMachineV2.getNoMoneyStatus());
    }

    @Override
    public void pushButton() {
         stateMachineV2.setStatus(stateMachineV2.getSellingStatus());
         stateMachineV2.outputItem();
    }

    @Override
    public void outputItem() {
        System.out.println("not support output item");
    }
}
