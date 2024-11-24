package State;

public interface OrderState {

    void handleInput(StateHandler status, String input);
    void displayMenu(StateHandler status);
}
