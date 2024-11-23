package State;

public class PaymentState implements OrderState{

    private static final PaymentState instance = new PaymentState();

    public static PaymentState getInstance(){
        return instance;
    } 

    @Override
    public void handleInput(StateHandler status, String input) {
        
    } 

    @Override
    public void displayMenu() {
        
    }
}
