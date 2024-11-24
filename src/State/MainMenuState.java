package State;

import Exception.BadInputException;
import Menu.Main.MainMenuFactory;
import Menu.Main.MainMenuType;

public class MainMenuState implements OrderState {

    private static final MainMenuState instance = new MainMenuState();

    public static MainMenuState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {
        try{
            int choice = Integer.parseInt(input);

            if(choice > 0 && choice <= MainMenuType.values().length){
                MainMenuType type = MainMenuType.values()[choice-1];
                System.out.println("\n\n" + type.getName() + "을(를) 선택했습니다.");

                System.out.println("맛을 선택하세요:");
                System.out.println("1. 착한맛");
                System.out.println("2. 초보맛");
                System.out.println("3. 약간매운맛");
                System.out.println("4. 보통맛");
                System.out.println("5. 매운맛");
                System.out.println("8. 메인 메뉴 다시보기");

                String tasteInput = new java.util.Scanner(System.in).nextLine();
                int tasteChoice = Integer.parseInt(tasteInput);
                int taste = switch(tasteChoice){
                    case 1 -> 1;
                    case 2 -> 2;
                    case 3 -> 3;
                    case 4 -> 4;
                    case 5 -> 5;
                    case 6 -> 6;
                    case 7 -> 7;
                    case 8 -> 8;
                    default -> throw new BadInputException(".");
                };
                if(taste >= 1 && taste <= 5){
                    status.getCart().addMainMenuItem(MainMenuFactory.createMainMenu(type, 1, taste));
                    System.out.println("\n\n장바구니에 메뉴가 추가되었습니다.");
                }
            }else if(choice == 6){
                status.setCurrentState(SideMenuState.getInstance());
            }else if(choice == 7){
                status.setCurrentState(CartState.getInstance());
            }else if(choice == 8){
                displayMenu(status);
            }else{
                throw new BadInputException("잘못된 입력입니다. 다시 시도해주세요");
            }
        }catch(BadInputException e){
            System.out.println("잘못된 입력입니다. 다시 시도해주세요");
        }
    }

    @Override
    public void displayMenu(StateHandler status) {
        int index = 1;

        System.out.println("\n\n메인메뉴");
        for(MainMenuType type : MainMenuType.values()){
            System.out.println(index++ + ". " + type.getName() + " | W " + type.getPrice() + " | " + type.getDescription());
        }
        if(!status.isCartEmpty()){
            System.out.println("\n6. 사이드 메뉴 선택");
            System.out.println("7. 장바구니로 이동");
        }
        System.out.println("\nexit. 키오스크 종료");
        System.out.println("\n번호를 입력하세요:");
    }
}