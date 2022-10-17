package design.command;

public class LightOnCommand implements ICommand {

    @Override
    public void execute() {
        System.out.println("light on");
    }
}
