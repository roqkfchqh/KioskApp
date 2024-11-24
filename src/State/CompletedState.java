package State;

public class CompletedState implements OrderState{

    private static final CompletedState instance = new CompletedState();

    public static CompletedState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {
        
    }

    @Override
    public void displayMenu(StateHandler status) {
        
    }
}

