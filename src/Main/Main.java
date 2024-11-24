package Main;

import Exception.BadInputException;
import Order.OrderBuilder;
import State.MainMenuState;
import State.StateHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderBuilder orderBuilder = new OrderBuilder();
        StateHandler stateHandler = new StateHandler(orderBuilder);
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
