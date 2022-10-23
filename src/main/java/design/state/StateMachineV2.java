package design.state;

import design.state.status.*;

public class StateMachineV2 {

    private final IStatus noMoneyStatus;

    private final IStatus hasMoneyStatus;

    private final IStatus sellingStatus;

    private final IStatus soldOutStatus;

    private int itemCount = 3;

    public StateMachineV2() {
        noMoneyStatus = new NoMoneyStatus(this);
        hasMoneyStatus = new HasMoneyStatus(this);
        sellingStatus = new SellingStatus(this);
        soldOutStatus = new SoldOutStatus(this);
        setStatus(noMoneyStatus);
    }

    private IStatus status;

    public void setStatus(IStatus status) {
        this.status = status;
    }

    /**
     * 加钱
     */
    public void inputMoney() {
        status.inputMoney();
    }

    /**
     * 退钱
     */
    public void outputMoney() {
        status.outputMoney();
    }

    /**
     * 按出货按钮
     */
    public void pushButton() {
        status.pushButton();
    }

    /**
     * 出货
     */
    public void outputItem() {
        status.outputItem();
    }


    public void subtractCount() {
        itemCount --;
    }

    public IStatus getNoMoneyStatus() {
        return noMoneyStatus;
    }

    public IStatus getHasMoneyStatus() {
        return hasMoneyStatus;
    }

    public IStatus getSellingStatus() {
        return sellingStatus;
    }

    public IStatus getSoldOutStatus() {
        return soldOutStatus;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        StateMachineV2 stateMachineV2 = new StateMachineV2();
        stateMachineV2.inputMoney();
        stateMachineV2.outputMoney();
        System.out.println("==========");
        stateMachineV2.inputMoney();
        stateMachineV2.pushButton();
        System.out.println("==========");
        stateMachineV2.inputMoney();
        stateMachineV2.pushButton();
        System.out.println("==========");
        stateMachineV2.inputMoney();
        stateMachineV2.pushButton();
        System.out.println("==========");
        stateMachineV2.inputMoney();
        stateMachineV2.pushButton();

    }

}
