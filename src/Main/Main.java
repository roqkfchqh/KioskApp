package Main;

import Exception.BadInputException;
import State.MainMenuState;
import State.StateHandler;
import Cart.Cart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        StateHandler stateHandler = new StateHandler(cart);
        stateHandler.setCurrentState(MainMenuState.getInstance());

        Scanner scanner = new Scanner(System.in);
        System.out.println("엽기떡볶이 키오스크");

        while(true){
            try{
                stateHandler.displayMenu();

                String input = scanner.nextLine();

                if("exit".equalsIgnoreCase(input)){
                    System.out.println("키오스크 종료");
                    break;
                }

                stateHandler.handleInput(input);
            }catch(BadInputException e){
                throw new BadInputException("에러: " + e);
            }
        }
        scanner.close();
    }
}