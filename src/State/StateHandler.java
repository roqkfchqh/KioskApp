package State;

import Order.OrderBuilder;

public class StateHandler {
  
    private OrderState currentState;
    private final OrderBuilder orderBuilder = new OrderBuilder();

    public StateHandler(OrderBuilder orderBuilder){
    }

    public OrderBuilder getOrderBuilder() {
        return orderBuilder;
    }

    public boolean isCartEmpty(){
        return orderBuilder.isEmpty();
    }

    public void setCurrentState(OrderState state){
        currentState = state;
    }

    public void handleInput(String input){
        currentState.handleInput(this, input);
    }

    public void displayMenu(){
        currentState.displayMenu(this);
    }
}
