package design.state.status;

import design.state.StateMachineV2;

public class SellingStatus implements IStatus{

    private final StateMachineV2 stateMachineV2;

    public SellingStatus(StateMachineV2 stateMachineV2) {
        this.stateMachineV2 = stateMachineV2;
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
        System.out.println("output item");
        stateMachineV2.subtractCount();
        if (stateMachineV2.getItemCount() > 0) {
            stateMachineV2.setStatus(stateMachineV2.getNoMoneyStatus());
        } else {
            stateMachineV2.setStatus(stateMachineV2.getSoldOutStatus());
        }
    }
}
