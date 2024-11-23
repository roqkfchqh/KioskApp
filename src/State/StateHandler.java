package State;

public class StateHandler {
  
    private OrderState currentState;
    private boolean cartEmpty = true;

    public StateHandler(OrderState initialState){
        this.currentState = initialState;
    }

    public void setCurrentState(OrderState state){
        currentState = state;
    }

    public boolean isCartEmpty(){
        return cartEmpty;
    }

    public void setCartEmpty(boolean cartEmpty){
        this.cartEmpty = cartEmpty;
    }

    public void handleInput(String input){
        currentState.handleInput(this, input);
    }

    public void displayMenu(){
        currentState.displayMenu();
    }
}
