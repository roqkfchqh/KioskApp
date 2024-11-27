package Menu.Main;

import Exception.BadInputException;

public class MainMenuItem{
  
    private final MainMenuType type;
    private int quantity;
    private final int taste;

    public MainMenuItem(MainMenuType type, int quantity, int taste){
        this.type = type;
        this.quantity = quantity;
        this.taste = taste;
    }

    public MainMenuType getType(){
        return type;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getTaste(){
        return taste;
    }

    public double getTotalPrice(){
        return type.getPrice() * quantity;
    }

    public static String getTasteItem(int taste){
        return switch(taste){
            case 1 -> "착한맛";
            case 2 -> "초보맛";
            case 3 -> "약간매운맛";
            case 4 -> "보통맛";
            case 5 -> "매운맛";
            default -> throw new BadInputException("오류");
        };
    }

    //장바구니용 메인메뉴 ui
    public void displayMain(){
        String tasteInput =  getTasteItem(taste);
        System.out.println(type.getName() + " | W " + type.getPrice() + " | " + tasteInput + " | 수량: " + quantity);
    }
}
