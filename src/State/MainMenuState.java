package State;

public class MainMenuState implements OrderState {

    private static final MainMenuState instance = new MainMenuState();

    public static MainMenuState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {
        
    }

    @Override
    public void displayMenu() {
        
    }
    

}
