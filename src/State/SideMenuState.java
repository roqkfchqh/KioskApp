package State;

import Menu.Main.MainMenuItem;
import Menu.Side.SideMenuType;
import Exception.BadInputException;

public class SideMenuState implements OrderState{

    private static final SideMenuState instance = new SideMenuState();

    public static SideMenuState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {
        try{
            int choice = Integer.parseInt(input);

            if(choice > 0 && choice <= SideMenuType.values().length){
                SideMenuType type = SideMenuType.values()[choice-1];
                System.out.println("\n\n" + type.getName() + "을(를) 선택했습니다.");

                System.out.println(type.getName() + " | W " + type.getPrice());
                System.out.println("을(를) 장바구니에 추가하시겠습니까? y / n");
                String yesOrNo = new java.util.Scanner(System.in).next();
                if(yesOrNo.equalsIgnoreCase("y")){
                    status.getOrderBuilder().addSide(type);
                    System.out.println("\n\n장바구니에 메뉴가 추가되었습니다.");
                }else if(yesOrNo.equalsIgnoreCase("n")){
                    status.setCurrentState(SideMenuState.getInstance());
                    System.out.println("메뉴 선택 화면으로 돌아갑니다.");
                }else{
                    throw new BadInputException("잘못된 입력입니다.");
                }

            }else if(choice == 11){
                status.setCurrentState(MainMenuState.getInstance());

            }else if(choice == 13){
                if(status.isMainEmpty()){
                    status.setCurrentState(MainMenuState.getInstance());
                    throw new BadInputException("메인메뉴 없이 장바구니로 갈 수 없습니다.");
                }
                status.setCurrentState(CartState.getInstance());

            }else{
                throw new BadInputException("잘못된 입력입니다. 다시 시도해주세요");
            }
        }catch(BadInputException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void displayMenu(StateHandler status) {
        int index = 1;

        System.out.println("\n\n사이드 메뉴");
        for(SideMenuType type : SideMenuType.values()){
            System.out.println(index++ + ". " + type.getName() + " | W " + type.getPrice());
        }
        if(!status.isCartEmpty()){
            System.out.println("\n11. 메인 메뉴로 돌아가기");
            System.out.println("13. 장바구니로 이동");
        }
        System.out.println("\nexit. 키오스크 종료");
        System.out.println("\n번호를 입력하세요:");
    }
}
