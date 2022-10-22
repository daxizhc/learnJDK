package design.state;

public class StateMachineV1 {

    private static final Integer NO_MONEY = 0;

    private static final Integer HAS_MONEY = 1;

    private static final Integer SELLING = 2;

    private static final Integer SOLD_OUT = 3;

    private int itemCount = 10;

    private Integer status = NO_MONEY;

    /**
     * 加钱
     */
    public void inputMoney() {
        if (NO_MONEY.equals(status)) {
            status = HAS_MONEY;
        } else {
            System.out.println("reject input money");
        }
    }

    /**
     * 退钱
     */
    public void outputMoney() {
        if (HAS_MONEY.equals(status)) {
            status = NO_MONEY;
        } else {
            System.out.println("reject output money");
        }
    }

    /**
     * 按出货按钮
     */
    public void pushButton() {
        if (HAS_MONEY.equals(status)) {
            status = SELLING;
            outputItem();
        } else {
            System.out.println("push button has not effect");
        }
    }

    /**
     * 出货
     */
    private void outputItem() {
        if (SELLING.equals(status)) {
            itemCount --;
            if (itemCount > 0) {
                status = NO_MONEY;
            } else {
                status = SOLD_OUT;
            }
        } else {
            System.out.println("can not output item");
        }
    }

}
