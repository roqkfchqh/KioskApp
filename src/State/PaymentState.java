package State;

import Exception.BadInputException;

public class PaymentState implements OrderState{

    private static final PaymentState instance = new PaymentState();

    public static PaymentState getInstance(){
        return instance;
    } 

    @Override
    public void handleInput(StateHandler status, String input) {
        try{
            int choice = Integer.parseInt(input);
            switch(choice){
                case 1 -> status.setCurrentState(CompletedState.getInstance());
                case 2 -> status.setCurrentState(CartState.getInstance());
                default -> throw new BadInputException("올바른 입력값이 아닙니다.");
            }
        }catch(BadInputException e){
            throw new BadInputException(e.getMessage());
        }
    }

    @Override
    public void displayMenu(StateHandler status) {
        System.out.println("\n\n이대로 결제를 진행하시겠습니까?");
        status.getOrderBuilder().displayBuilder();
        System.out.println("1. 결제하기 / 2. 장바구니로 이동");

        System.out.println("\nexit. 키오스크 종료");
        System.out.println("\n번호를 입력하세요:");
    }
}
