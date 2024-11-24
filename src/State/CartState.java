package State;

public class CartState implements OrderState{

    private static final CartState instance = new CartState();

    public static CartState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {

    }

    @Override
    public void displayMenu(StateHandler status) {

    }
}
