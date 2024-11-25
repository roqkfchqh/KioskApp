package State;

import Order.OrderBuilder;
import Order.Coupon;

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

    public boolean isCouponEmpty(){
        return orderBuilder.isCouponEmpty();
    }

    public void setCoupon(Coupon coupon){
        orderBuilder.setCoupon(coupon);
        System.out.println(coupon.getCouponName() + "이 적용되었습니다.");
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
}
