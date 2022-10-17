package design.command;

public class SimpleControl {

    ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public static void main(String[] args) {
        SimpleControl simpleControl = new SimpleControl();
        LightOnCommand lightOnCommand = new LightOnCommand();
        simpleControl.setCommand(lightOnCommand);
        simpleControl.pressButton();
    }

}
