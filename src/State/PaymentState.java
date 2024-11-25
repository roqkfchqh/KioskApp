package State;

import Order.OrderBuilder;

public class PaymentState implements OrderState{

    private final OrderBuilder orderBuilder = new OrderBuilder();

    private static final PaymentState instance = new PaymentState();

    public static PaymentState getInstance(){
        return instance;
    } 

    @Override
    public void handleInput(StateHandler status, String input) {
        
    }

    /**
     * MAIN 시작 시 랜덤으로 돈 (20000~100000) 지급하고 그 안에서 결제하도록 ㄱㄱ
     *
     */
    @Override
    public void displayMenu(StateHandler status) {
        orderBuilder.displayBuilder();
    }
}
