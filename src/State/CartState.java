package State;

import Exception.BadInputException;
import Order.Coupon;

import static Main.Main.exitHandler;

public class CartState implements OrderState{

    private static final CartState instance = new CartState();

    public static CartState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {
        try{
            int choice = Integer.parseInt(input);

            switch(choice){
                case 11 -> status.setCurrentState(MainMenuState.getInstance());

                case 12 -> {
                    if(status.isMainEmpty()){
                        status.setCurrentState(MainMenuState.getInstance());
                        throw new BadInputException("메인메뉴 없이 주문할 수 없습니다.");
                    }
                    status.setCurrentState(SideMenuState.getInstance());
                }

                case 14 -> {
                    System.out.println("1. 메인 메뉴에서 삭제 | 2. 사이드 메뉴에서 삭제");
                    String delete = new java.util.Scanner(System.in).nextLine();
                    exitHandler(delete);
                    switch(delete){
                        case "1" -> {
                            System.out.println("삭제할 메인 메뉴의 이름을 정확히 입력해주세요:");
                            String index = new java.util.Scanner(System.in).nextLine();
                            status.getOrderBuilder().deleteMain(index);
                            System.out.println("해당 메뉴가 삭제되었습니다.");

                            if(!status.isMainEmpty()){
                                status.setCurrentState(CartState.getInstance());
                            }else{
                                status.setCurrentState(MainMenuState.getInstance());
                            }
                        }
                        case "2" -> {
                            System.out.println("삭제할 사이드 메뉴의 이름을 정확히 입력해주세요:");
                            String index = new java.util.Scanner(System.in).nextLine();
                            exitHandler(index);
                            status.getOrderBuilder().deleteSide(index);
                            System.out.println("해당 메뉴가 삭제되었습니다.");

                            if(!status.isMainEmpty()){
                                status.setCurrentState(CartState.getInstance());
                            }else{
                                status.setCurrentState(MainMenuState.getInstance());
                            }
                        }
                        default -> throw new BadInputException("잘못된 입력입니다. 다시 시도해주세요");
                    }
                }

                case 15 -> {
                    if(!status.isCouponEmpty()){
                        System.out.println("쿠폰 적용을 취소합니다.");
                        status.setCoupon(null);
                    }else{
                        System.out.println("\n\n쿠폰 선택");
                        status.displayCoupon();
                        System.out.println("적용하실 쿠폰을 선택해주세요:");
                        String couponInput = new java.util.Scanner(System.in).nextLine();
                        exitHandler(couponInput);
                        Coupon coupon = Coupon.getCoupon(Integer.parseInt(couponInput));
                        status.setCoupon(coupon);
                        System.out.println(coupon.getCouponName() + "이 적용되었습니다.");
                    }
                }

                case 16 -> status.setCurrentState(PaymentState.getInstance());
                default -> throw new BadInputException("잘못된 입력입니다. 다시 시도해주세요");
            }
        }catch(BadInputException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void displayMenu(StateHandler status) {
        System.out.println("\n\n장바구니");
        status.getOrderBuilder().displayBuilder();
        if(!status.isCartEmpty()){
            System.out.println("\n11. 메인 메뉴 더 담기");
            System.out.println("12. 사이드 메뉴 더 담기");
            System.out.println("14. 메뉴 삭제하기");
            if(status.isCouponEmpty()){
                System.out.println("\n15. 쿠폰 적용하기");
            }else{
                System.out.println("15. 쿠폰 적용 취소하기");
            }
            System.out.println("16. 주문하기");
        }
        System.out.println("\nexit. 키오스크 종료");
        System.out.println("\n번호를 입력하세요:");
    }
}
