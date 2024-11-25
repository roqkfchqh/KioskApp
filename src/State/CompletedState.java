package State;

import java.util.concurrent.TimeUnit;

public class CompletedState implements OrderState{

    private static final CompletedState instance = new CompletedState();

    public static CompletedState getInstance(){
        return instance;
    }

    @Override
    public void handleInput(StateHandler status, String input) {
        
    }

    @Override
    public void displayMenu(StateHandler status) {
        try{
            System.out.println("결제가 완료되었습니다.");
            status.displayOrder();
            System.out.println("\n 5초 뒤에 메인화면으로 돌아갑니다.");
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        status.setCurrentState(MainMenuState.getInstance());
    }
}

