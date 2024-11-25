package State;

import Order.OrderBuilder;
import Order.Coupon;
import Order.Order;

public class StateHandler {
  
    private OrderState currentState;
    private final OrderBuilder orderBuilder = new OrderBuilder();
    private final Order order;

    public StateHandler(OrderBuilder orderBuilder){
        this.order = orderBuilder.build();
    }

    public OrderBuilder getOrderBuilder() {
        return orderBuilder;
    }

    public boolean isCartEmpty(){
        return orderBuilder.isEmpty();
    }

    public boolean isCouponEmpty(){
        return orderBuilder.isCouponEmpty();
    }

    public void setCoupon(Coupon coupon){
        orderBuilder.setCoupon(coupon);
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

    public void displayCoupon(){
        Coupon.displayCoupon();
    }

    public void displayOrder(){
        order.displayOrder();
    }
}
