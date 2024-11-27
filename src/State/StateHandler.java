package State;

import Order.OrderBuilder;
import Order.Coupon;
import Order.Order;

public class StateHandler {
  
    private OrderState currentState;
    private final OrderBuilder orderBuilder = new OrderBuilder();

    /**
     * orderBuilder 직접 접근용
     * @return 현재 orderBuilder(장바구니)
     */
    public OrderBuilder getOrderBuilder(){
        return orderBuilder;
    }

    /**
     * 쿠폰 setter
     * @param coupon
     */
    public void setCoupon(Coupon coupon){
        orderBuilder.setCoupon(coupon);
    }

    /**
     * 현재상태 setter
     * @param state 현재상태
     */
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

    /**
     * 사용자 입력 처리
     * @param input 사용자 입력값(main.java)
     */
    public void handleInput(String input){
        currentState.handleInput(this, input);
    }

    /**
     * 현재 상태 ui
     */
    public void displayMenu(){
        currentState.displayMenu(this);
    }

    //모든 쿠폰 출력
    public void displayCoupon(){
        Coupon.displayCoupon();
    }

    //주문 내역 출력
    public void displayOrder(){
        Order order = orderBuilder.build();
        order.displayOrder();
    }
}
