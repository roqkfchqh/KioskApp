package State;

public class TastState implements OrderState{

    private static final TastState instance = new TastState();

    public static TastState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {
        
    }

    @Override
    public void displayMenu() {
        
    }
}
