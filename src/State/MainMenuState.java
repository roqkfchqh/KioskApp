package State;

import Exception.BadInputException;
import Menu.Main.MainMenuItem;
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

                System.out.println("맵기를 선택하세요");
                System.out.println("1. 착한맛");
                System.out.println("2. 초보맛");
                System.out.println("3. 약간매운맛");
                System.out.println("4. 보통맛");
                System.out.println("5. 매운맛");
                System.out.println("11. 메인 메뉴로 돌아가기");
                System.out.println("\nexit. 키오스크 종료");
                System.out.println("\n번호를 입력하세요:");

                int tasteInput = new java.util.Scanner(System.in).nextInt();
                int taste = switch(tasteInput){
                    case 1 -> 1;
                    case 2 -> 2;
                    case 3 -> 3;
                    case 4 -> 4;
                    case 5 -> 5;
                    case 11 -> 11;
                    case 12 -> 12;
                    case 13 -> 13;
                    default -> throw new BadInputException("잘못된 입력입니다. 다시 시도해주세요");
                };
                if(taste <= 5){
                    System.out.println(type.getName() + " " + MainMenuItem.getTasteInput(taste) + " | W " + type.getPrice());
                    System.out.println("을(를) 장바구니에 추가하시겠습니까? y / n");
                    String yesOrNo = new java.util.Scanner(System.in).next();

                    if(yesOrNo.equalsIgnoreCase("y")){
                        status.getOrderBuilder().addMain(type, taste);
                        System.out.println("\n\n장바구니에 메뉴가 추가되었습니다.");
                    }else if(yesOrNo.equalsIgnoreCase("n")){
                        status.setCurrentState(MainMenuState.getInstance());
                        System.out.println("메인메뉴로 돌아갑니다.");
                    }else{
                        throw new BadInputException("잘못된 입력입니다.");
                    }
                }

            }else if(choice == 11){
                displayMenu(status);

            }else if(choice == 12){
                if(status.isMainEmpty()){
                    status.setCurrentState(MainMenuState.getInstance());
                    throw new BadInputException("메인메뉴 없이 주문할 수 없습니다.");
                }
                status.setCurrentState(SideMenuState.getInstance());

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

        System.out.println("\n\n메인 메뉴");
        for(MainMenuType type : MainMenuType.values()){
            System.out.println(index++ + ". " + type.getName() + " | W " + type.getPrice() + " | " + type.getDescription());
        }
        if(!status.isCartEmpty()){
            System.out.println("\n12. 사이드 메뉴 선택");
            System.out.println("13. 장바구니로 이동");
        }
        System.out.println("\nexit. 키오스크 종료");
        System.out.println("\n번호를 입력하세요:");
    }
}