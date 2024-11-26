package State;

import Order.OrderBuilder;
import Order.Coupon;
import Order.Order;

public class StateHandler {
  
    private OrderState currentState;
    private final OrderBuilder orderBuilder = new OrderBuilder();

    public OrderBuilder getOrderBuilder() {
        return orderBuilder;
    }

    public void setCoupon(Coupon coupon){
        orderBuilder.setCoupon(coupon);
    }

    public void setCurrentState(OrderState state){
        currentState = state;
    }

    public boolean isCartEmpty(){
        return orderBuilder.isEmpty();
    }

    public boolean isCouponEmpty(){
        return orderBuilder.isCouponEmpty();
    }

    public boolean isMainEmpty(){
        return orderBuilder.mainEmpty();
    }

    public void clearMenu(){
        orderBuilder.clearMenu();
    }

    public void handleInput(String input){
        currentState.handleInput(this, input);
    }

    public void displayMenu(){
        currentState.displayMenu(this);
    }

    public void displayCoupon(){
        Coupon.displayCoupon();
    }

    public void displayOrder(){
        Order order = orderBuilder.build();
        order.displayOrder();
    }
}
