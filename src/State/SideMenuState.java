package State;

public class SideMenuState implements OrderState{

    private static final SideMenuState instance = new SideMenuState();

    public static SideMenuState getInstance(){
        return instance;
    } 

    @Override
    public void handleInput(StateHandler status, String input) {
        
    }

    @Override
    public void displayMenu() {
        
    }
}
