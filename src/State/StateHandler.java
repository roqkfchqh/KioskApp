package State;

import Cart.Cart;

public class StateHandler {
  
    private OrderState currentState;
    private Cart cart;

    public StateHandler(Cart cart) {
        this.currentState = currentState;
        this.cart = new Cart();
    }

    public Cart getCart(){
        return cart;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public boolean isCartEmpty(){
        return cart.isEmpty();
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
