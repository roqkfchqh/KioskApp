package State;

public interface OrderState {

    /**
     * 사용자 입력 처리
     * @param status 현재 상태
     * @param input 사용자 입력값
     */
    void handleInput(StateHandler status, String input);

    /**
     * 각 상태 별 ui
     * @param status 현재 상태
     */
    void displayMenu(StateHandler status);
}
